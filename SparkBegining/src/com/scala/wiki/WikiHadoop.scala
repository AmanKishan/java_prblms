package com.scala.wiki

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.hadoop.mapred.JobConf
import org.apache.hadoop.mapred.FileInputFormat
import org.apache.hadoop.io.Text
import org.apache.hadoop.streaming.StreamXmlRecordReader
import org.apache.hadoop.streaming.StreamInputFormat
import scala.xml.XML

import org.apache.log4j.Logger

import org.apache.log4j.Level
import org.apache.spark.rdd.RDD
  

object WikiHadoop extends App{
  
  Logger.getLogger("org").setLevel(Level.OFF)

Logger.getLogger("akka").setLevel(Level.OFF)


  val conf = new SparkConf().setAppName("wiki hadoop").setMaster("local")
  val sc = new SparkContext(conf)
  val jobConf = new JobConf()
  jobConf.set("stream.recordreader.class","org.apache.hadoop.streaming.StreamXmlRecordReader")
  jobConf.set("stream.recordreader.begin","<catalog>")
  jobConf.set("stream.recordreader.end","</catalog>")
  FileInputFormat.addInputPaths(jobConf, "C:/Users/aman_rastogi/Desktop/enwiki-latest-abstract/book.xml")
   val bookDocs = sc.hadoopRDD(jobConf, classOf[org.apache.hadoop.streaming.StreamInputFormat], classOf[Text], classOf[Text])
 
   println(bookDocs.map(_._1.toString()).count())
   
   
   /*  val stringBookDocs = bookDocs.map(hadoopxml =>hadoopxml._1.toString())
   
   val bookMap = stringBookDocs.map(bookString => 
     {
       val xml = XML.loadString(bookString)
       val bookTag = xml \ "book"
       val titlePriceMap =bookTag.map(xmlNode => ((xmlNode \ "title").text , (xmlNode \ "price" ).text.toDouble))
       titlePriceMap.toList
     })
     println(bookMap.first)*/ 
 
   /*list of map of title and price where price is greater than 10 */
   val bookMap = bookDocs
      .map({ bookString =>
        val xml = XML.loadString(bookString._1.toString())
        //println("author Names ------> " + (xml \ "book" \ "author").text)
        val bookTag = xml \ "book"
        val titlePriceMap = bookTag.filter(xmlNode => ( xmlNode \ "price").text.toFloat > 10 ).map(
          xmlNode =>(
            (xmlNode \ "title").text,
            (xmlNode \ "price").text.toFloat
          ))
        titlePriceMap.toList
      })
    println("%%%%%%" + bookMap.first)
    
   
   /*Now fetch words from the title*/
    bookMap.first().flatMap(title => {
      
      //println("@@@@@" + title._1);
      title.toString();
    });
    
    
    /*this is done using scala*/
    /*val titleToken = bookMap.first().flatMap(title => title._1.toString().split(" "))
    .map(token => token.replaceAll("[.|,|'|\"|?|)|(]", "").trim()).filter(token => token.length() > 2)
    .distinct.sortBy( token => token.length)
    
    println(titleToken)*/
   
    /*this is done using spark rdd*/
    val tokens =  bookMap.flatMap(title => title.flatMap(t => t._1.toString().split(" ")).
        map(token => token.replaceAll("[.|,|'|\"|?|)|(]", "").trim()).filter(f => f.length() > 2)//.distinct
        .sortBy(sortE => sortE.length))
        
    println("Distinct token count => " + tokens.count())
    println(tokens.collect().foreach(a => print(" , " + a)))
    
    val tokenMap = tokens.countByValue();
    println(tokenMap)
    println(tokenMap.maxBy(x => x._2))
    
    val trainRdd: RDD[(String, Long)]  = sc.parallelize(tokenMap.toSeq);
    val map = trainRdd.reduceByKey((accumulator , newValue ) => accumulator + newValue)
    val folMap =trainRdd.foldByKey(0)((accumulator , newValue ) => accumulator + newValue)
    
    val scalaMap = map.collect().toMap
    val scalaMapFol =folMap.collect().toMap; 
    print(scalaMap)
    
}