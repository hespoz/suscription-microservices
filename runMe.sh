#!/bin/sh
echo 'Runnint discovery service'
cd ./discovery-service/ && ./mvnw spring-boot:run &

echo 'Runnint email service'
cd ./email-service && ./mvnw spring-boot:run &

echo 'Runnint event service'
cd ./event-service && ./mvnw spring-boot:run &

echo 'Runnint suscription service'
cd ./suscription-service && ./mvnw spring-boot:run &

cd ./suscription-portal/ && npm install && npm start