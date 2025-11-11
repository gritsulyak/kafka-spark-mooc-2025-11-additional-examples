# Direct Kafka Word Count

Пример простого приложения Spark Streaming, которое читает данные из Kafka

## Запуск

* Запускаем Kafka через ../docker/docker-compose up -d
* Создаем тему *words*:
docker exec -it kafka-1 bash

# Внутри контейнера создать тему
kafka-topics --create \
  --topic words \
  --bootstrap-server localhost:9093 \
  --partitions 1 \
  --replication-factor 1

# Выйти из контейнера
exit

# Проверка создания темы
Убедитесь, что тема создалась:

bash
docker exec kafka-1 kafka-topics --list --bootstrap-server localhost:9092
Должны увидеть:

text
words

* В первом терминале запускаем *usr/local/kafka/bin/kafka-console-producer.sh --topic words --bootstrap-server localhost:9092* и вводим слова, разделённые пробелом

docker exec -it kafka-1 kafka-console-producer \
  --topic words \
  --bootstrap-server localhost:9093

* Во втором терминале запускаем *spark-submit DirectKafkaWordCount-assembly-1.0.jar localhost:9092 group1 words*

для локального запуска - запускаем в sbt shell Idea:

runMain org.apache.spark.examples.streaming.DirectKafkaWordCount localhost:29093 group1 words