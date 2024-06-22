# Spring Boot Microservices with Hüseyin BABAL

This repository contains my practical implementations and learnings from the [Spring Boot Microservices series](https://www.youtube.com/watch?v=QRVz-KqAXHU&list=PL-Z0o2McR6b4YhePHVTynQUfNyG4pUKAr) by Hüseyin BABAL on YouTube. The goal of this repository is to understand microservices architecture and how to implement it using Spring Boot.

## Tech Stack

For this training, I will be using the following technologies:

- **Java 17**: A modern programming language for building robust and scalable applications.
- **Apache Kafka**: A distributed streaming platform used for building real-time data pipelines and streaming applications, running locally.
- **PostgreSQL**: A powerful, open-source object-relational database system.
- **Spring Boot 3.3.0**: A framework for creating production-ready applications using Spring.
- **Lombok**: A Java library that helps reduce boilerplate code by generating common methods like getters, setters, and more.
- **Gradle**: A build automation tool used to manage project dependencies and automate the build process.

## Setup

To run the projects in this repository, follow these steps:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/gunesserkan/microservices.git
   cd microservice-training
Install Java 17: Ensure Java 17 is installed on your system. You can download it from the official site.

Set Up Kafka:

Download and extract Kafka from the official website.
Follow the instructions in the Kafka Quickstart guide to start a local Kafka server.
Install PostgreSQL:

Download and install PostgreSQL from the official site.
Create a database for the project as per the application configuration.
Build and Run the Application:

Navigate to the project directory and use Gradle to build and run the application.
Example with Gradle:
bash
Kodu kopyala
./gradlew bootRun
Learning Objectives
Through this training, I aim to achieve the following objectives:

Understand the fundamentals of microservices architecture.
Learn how to design, build, and deploy microservices.
Gain practical experience with technologies such as Kafka, PostgreSQL, and Spring Boot.
Explore best practices for microservices communication, data management, and deployment.
Projects
This repository will include various projects and examples implemented as part of the training:

Basic Microservice Setup: Setting up a simple microservice using Spring Boot.
Inter-Service Communication: Implementing communication between microservices using Kafka.
Database Integration: Integrating PostgreSQL with microservices for persistent data storage.

Spring Boot Documentation
Apache Kafka Documentation
PostgreSQL Documentation
Project Lombok
Gradle Documentation