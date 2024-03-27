# Birth Registration API

## Table of Contents

- [Prerequisites](#prerequisites)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
- [License](#license)

## Prerequisites

Before running the Birth Registration API, make sure you have the following prerequisites installed:

- Java: [Installation Guide](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- Kubernetes: [Installation Guide](https://kubernetes.io/docs/setup/)
- PostgreSQL: [Installation Guide](https://www.postgresql.org/download/)
- Apache Kafka: [Installation Guide](https://kafka.apache.org/quickstart)
- Zookeeper: [Installation Guide](https://zookeeper.apache.org/doc/r3.7.0/zookeeperStarted.html)
- IntellIJ IDEA: [Installation Guide](https://www.jetbrains.com/idea/download/)

## Tech Stack

This project uses the following technologies:

- Java: The backend service is written in Java.
- Kubernetes: Kubernetes is used for container orchestration.
- PostgreSQL: PostgreSQL is used as the database.
- Apache Kafka: Kafka is used for handling real-time birth registration events.
- Zookeeper: Zookeeper is used as the coordination service for Kafka.

## Getting Started

Follow these steps to get started with the Birth Registration API:

1. (Open This in InetllIJ) Clone the repository:

   ```bash
   git clone https://github.com/narasimha-1511/birth-registration.git
    ```
   
2. Start PostgreSQL, Zookeeper, and Kafka.
    
    (Start Zookeeper)
      ```bash
      zookeeper-server-start.sh config/zookeeper.properties
      ```
    (Start Kafka)
      ```bash
      kafka-server-start.sh config/server.properties
      ```
    (Start Postgres)
      ```bash
      systemctl start postgresql
      ```

3. Clone the DIGIT-OSS repository:
```bash
git clone git@github.com:egovernments/DIGIT-OSS.git
```

4. Open the Persister Core Model in the cloned DIGIT-OSS directory.
5. Test the API using Postman.

Example:

* Request : 
  ```json
   {
  "RequestInfo": 
   {
   "apiId": "Hello ",
   "ver": "0.00",
   "ts": null,
   "action": "string",
   "did": "string",
   "key": "string",
   "msgId": "Narasimha",
   "authToken": "6456b2cf-49ca-47c7-b7b6-c179f19614c7",
   "correlationId": "e721639b-c095-40b3-86e2-acecb2cb6efb",
   "userInfo": {
   "id": "23299",
   "uuid": "e721639b-c095-40b3-86e2-acecb2cb6efb",
   "userName": "9337682030",
   "name": "Abhilash Seth",
   "type": "EMPLOYEE",
   "mobileNumber": "9337682030",
   "emailId": "abhilash.seth@gmail.com",
   "roles": [
   {
   "id": 281,
   "name": "Employee"
   }
   ]
   }
   },
   "idRequests": [
   {
   "tenantId": "pb.amritsar",
   "idName": "btr.registrationid"
   }
   ],
   "BirthRegistrationApplications":[
   {
   "id":5656,
   "tenantId":"pb.amritsar",
   "timeOfBirth":12072001,
   "babyFirstName":"hehe",
   "babyLastName":"haha",
   "doctorName":"Aaa",
   "hospitalName":"Hospital",
   "fatherMobileNumber":"9090909090",
   "motherOfApplicant":"mother",
   "fatherOfApplicant":"father",
   "placeOfBirth":"Visakhapatnam",
   "motherMobileNumber":"9999999999",
   "applicant":{
   "id": "69",
   "userName": "aaa",
   "password": "pass",
   "salutation": "**",
   "name": "devil",
   "gender": "male",
   "mobileNumber": 8888888888
   }
   
         }
         ]
   
   }
   ```

## License
This project is licensed under the MIT License.