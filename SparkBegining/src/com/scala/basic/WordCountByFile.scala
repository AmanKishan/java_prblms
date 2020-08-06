package com.scala.basic

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext


object WordCountByFile {
  
  def main (args : Array[String]){
    
    val conf = 
    new SparkConf()
    .setAppName("word-counter")
    .setMaster("local") 
    .set("spark.storage.memoryFraction", "1")
    val sc = new SparkContext(conf)
    val textFile = sc.textFile("C:/spark/README.md")
    val wordTokenArray = textFile.flatMap(line => line.split(" "))
    val wordKeyValueMap = wordTokenArray.map(word => (word,1))
    val wordkeyValueUniqueMap =  wordKeyValueMap.reduceByKey((accumVal,newVal)=> accumVal+newVal)
    val WordCountSortByValue = wordkeyValueUniqueMap.sortBy(kvPair=>kvPair._2,false)
    WordCountSortByValue.saveAsTextFile("C:/spark/amanworkspace/ReadWordCountViaApp")
  }
}