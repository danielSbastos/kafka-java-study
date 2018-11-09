# kafka-java-study

## Start everything

`docker-compose up`

### Entering kafka's bash

`docker-compose exec kafka /bin/bash`

### Entering zookeeper's bash

`${KAFKA_HOME}/bin/zookeeper-shell.sh zookeeper`

### Creating a topic
```sh
${KAFKA_HOME}/bin/kafka-topics.sh \
  --zookeeper zookeeper:2181 \
  --create \
  --topic daniel \
  --partitions 2 \
  --replication-factor 1
```

### Feeding a topic

`seq 1 100 > numlist`

```sh
${KAFKA_HOME}/bin/kafka-console-producer.sh \
  --broker-list 172.18.0.1:9092 \
  --topic daniel < numlist
```

### Reading from a topic

```sh
${KAFKA_HOME}/bin/kafka-console-consumer.sh \
  --bootstrap-server 172.18.0.1:9092 \
  --from-beginning \
  --topic daniel
```
