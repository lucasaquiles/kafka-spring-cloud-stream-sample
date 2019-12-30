# kafka-spring-cloud-stream-example

scenarios using kafka and spring cloud stream


seed
```
while :; do  
 curl -X POST "http://localhost:8080/" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"description\": \"string\", \"lat\":"$ind" , \"lon\": "$ind"}"; 
 let ind=ind+1;
done
```

examples with kafka producer and consumers and partitions topic groups

```
docker-compose up --build -d mongodb
```
