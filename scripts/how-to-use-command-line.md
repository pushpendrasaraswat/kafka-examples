   1. Start Zookeeper
    ./bin/zookeeper-server-start.sh ./config/zookeeper.properties
   2. Start kafka server
    ./bin/kafka-server-start.sh ./config/server.properties
   3. Create a topic
    ./bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
    ./bin/kafka-console-producer.sh --topic test --broker-list localhost:9092
   4. create producer
    ./bin/kafka-console-producer.sh --topic test --broker-list localhost:9092
   5. create consumer
    ./bin/kafka-console-consumer.sh --topic test --from-beginning --bootstrap-server localhost:9092


to describe topic 

kafka-topics.sh --describe --topic invoice --bootstrap-server localhost:9092 