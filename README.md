

1. Set a key in Redis:

GET http://localhost:8080/set?key=mykey&value=HelloRedis
Response: Set key: mykey with value: HelloRedis

2. Get a key from Redis:

GET http://localhost:8080/get?key=mykey
Response: HelloRedis

Delete a key from Redis:

3. GET http://localhost:8080/delete?key=mykey
Response: Deleted key: mykey

