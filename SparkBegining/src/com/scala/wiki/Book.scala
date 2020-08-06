package com.scala.wiki

import java.io.File
import scala.xml.pull._
import scala.io.Source
import scala.collection.mutable.ArrayBuffer
import scala.xml.XML
import java.io.FileOutputStream

object Book extends App {
  
  val xmlFile = "C:/Users/aman_rastogi/Desktop/enwiki-latest-abstract/book.xml";
  val outputFileLocation = new File("C:/spark/amanworkspace")
  val xml = new XMLEventReader(Source.fromFile(xmlFile))
   var insidePage = false
  var buf = ArrayBuffer[String]()
  for (event <- xml) {
    event match {
      case EvElemStart(_, "catalog", _, _) => {
        insidePage = true
        val tag = "<catalog>"
        buf += tag
      }
      case EvElemEnd(_, "catalog") => {
        println("inside")
        val tag = "</catalog>"
        buf += tag
        insidePage = false
 
        writePage(buf)
        buf.clear
      }
      case e @ EvElemStart(_, book, _, _) => {
        if (insidePage) {
          buf += ("<" + book + ">")
        }
      }
      case e @ EvElemEnd(_, book) => {
        if (insidePage) {
          buf += ("</" + book + ">")
        }
      }
      case EvText(t) => {
        if (insidePage) {
          buf += (t)
        }
      }
      case _ => // ignore
    }
  }
  
    def writePage(buf: ArrayBuffer[String]) = {
    val s = buf.mkString
    val x = XML.loadString(s)
    
    val pageElementsBook = (x \ "book")
    
    val pageFirstElementFirstTag = (x \ "book")(0).child(1).text
    println("pageFirstElementFirstTag  --->" + pageFirstElementFirstTag)
    
    val bookElemtCount = pageElementsBook.length;
     println("Number of books " + bookElemtCount)
    
    /*those book price is less than 10*/
    
    val prices = pageElementsBook.map(book => ((book \\ "title").text , (book \\ "price").text))
    println(prices)
    val filterPrice = pageElementsBook.filter(book => (book \\ "price").text.toFloat > 10 ).map(book => ((book \\ "title").text , (book \\ "price").text))
    println(filterPrice)
    
    val f = new File(outputFileLocation, "aa.xml")
    println("writing to: " + f.getAbsolutePath())
    val out = new FileOutputStream(f)
    out.write(s.getBytes())
    out.close
    
   
  }
}