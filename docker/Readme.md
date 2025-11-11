1. Start all services:
docker-compose up -d
3. Terminal 1 - Start netcat server:
docker-compose exec spark-master nc -lk 9999
4. Terminal 2 - Run the Spark streaming job:
docker-compose exec spark-master /opt/spark/bin/spark-submit --master spark://spark-master:7077 --class org.apache.spark.examples.sql.streaming.StructuredNetworkWordCount /opt/spark/examples/jars/spark-examples_2.12-3.5.7.jar localhost 9999
