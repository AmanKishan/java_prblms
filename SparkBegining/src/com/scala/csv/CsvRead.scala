package com.scala.csv

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Logger

import org.apache.log4j.Level

object CsvRead extends App {
  Logger.getLogger("org").setLevel(Level.OFF)

  Logger.getLogger("akka").setLevel(Level.OFF)

  val conf = new SparkConf().setAppName("wiki hadoop").setMaster("local")
  val sc = new SparkContext(conf)
  val sparkSession = SparkSession.builder().config(conf).getOrCreate()

  val df = sparkSession.read.format("csv").option("header", "true").option("mode", "DROPMALFORMED")
    .load("C:/Users/aman_rastogi/Desktop/enwiki-latest-abstract/stock.csv")

  val url = "jdbc:oracle:thin:eqi/app$1234@//aws-dev-priv-db-use1a-237.mhf.mhc:1521/IISD"
  val driver = "oracle.jdbc.driver.OracleDriver"
  val prop = new java.util.Properties
  prop.setProperty("driver", driver)
 
  val empDF = sparkSession.read
    .format("jdbc")
    .option("url", url)
    .option("driver", driver)

  df.write.mode("append").jdbc(url, "test_spark", prop)

  println(df.show())

}