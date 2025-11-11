package org.apache.spark.examples.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object RddElementals extends App {

    // run locally
    val sparkConf = new SparkConf()
      .setAppName("RddElementals")
      .setMaster("local[2]") // Добавьте local[2] - для локального вместо ниже
      // spark://spark-master:7077
      .set("spark.log.level", "INFO")

    // Create context with 2 second batch interval
    val ssc = new StreamingContext(sparkConf, Seconds(2))

    // ssc

    println("ex1")
    // val rdd = ssc.sparkContext.parallelize(List(1, 2, 3, 4))
    val rdd = ssc.sparkContext.makeRDD(List(1, 2, 3, 4), 3)

    val newrdd = rdd.flatMap(x => List(x, x * 2))

    val newrdd2 = newrdd //.++(rdd)

    newrdd2.foreach(println)

    println("ex2")

    newrdd.filter(x=>x%3!=0).foreach(println)

    println("ex3")
    // ...

     println(rdd.reduce(_+_))

  }
