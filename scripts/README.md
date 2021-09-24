# Apicurio Registry Script

Register the v1 user schema
```sh
./register_schema.sh user-v1.avsc
```

Then update it
```sh
./update_schema.sh user-v2.avsc
```

With the application up and running
```sh
./create_user.sh "user name" 25
```

If you wish, you can check the topic with kafkacat after running the
`create_user.sh` script
```sh
kafkacat -b localhost:9092 -t user-creation -p 0
```
