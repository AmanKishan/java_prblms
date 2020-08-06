package com.scala.spark.db
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import oracle.jdbc.driver.OracleDriver;

object DbConnect extends App{
  
   Logger.getLogger("org").setLevel(Level.OFF)
   Logger.getLogger("akka").setLevel(Level.OFF)
   
   val conf = new SparkConf().setAppName("db connect").setMaster("local")
   val sc = new SparkContext(conf)
  val sparkSession = SparkSession.builder().config(conf).getOrCreate()   
  
  val query = "(select * from eqi_m_user emu where emu.user_id in (1,2,20015,3,4))"
  
  val  empDF = sparkSession.read 
    .format("jdbc") 
    .option("url", "jdbc:oracle:thin:eqi/app$1234@//aws-dev-priv-db-use1a-237.mhf.mhc:1521/IISD") 
    .option("dbtable", query) 
    .option("driver", "oracle.jdbc.driver.OracleDriver") 
    .load()
    println(empDF.show())
    
}