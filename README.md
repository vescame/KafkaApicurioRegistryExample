# Apicurio Registry with Kafka

Start everything
```sh
docker-compose up -d
```

Verify if infra is up and running
```sh
docker-compose ps
```

Create the kafka topic
```sh
docker-compose exec kafka bash
# when attached to kafka container
kafka-topics --bootstrap-server kafka:9092 --create --topic user-creation --partitions 1 --if-not-exists
```

Refer to scripts/README.md to register, update schemas and send a test POST request
to the producer application

