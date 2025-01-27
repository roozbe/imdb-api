# IMDb REST API Documentation

## Overview
This project provides a RESTful API built with Spring Boot that processes IMDb datasets and exposes endpoints to query movie-related data. The application allows users to retrieve information such as movies where the writer and director are the same person, movies featuring specific actors, top-rated movies in specific genres, and the total number of requests made to the API since startup.

## Features

1. **Import IMDb Dataset**:
    - The application processes IMDb datasets to create in-memory data structures for querying.
2. **Endpoints**:
    - Retrieve movies where the writer and director are the same and the writer is still alive.
    - Fetch movies featuring two specific actors.
    - Get the best-rated movie for a given genre by year.
    - Track the total number of requests made to the API.

## IMDb Datasets Used
The application processes the following IMDb dataset files:

- `name.basics.tsv`: Contains information about people involved in movies.
- `title.basics.tsv`: Contains basic movie information like title, year, and genres.
- `title.crew.tsv`: Contains information about directors and writers of movies.
- `title.principals.tsv`: Contains information about primary cast members.
- `title.ratings.tsv`: Contains movie ratings.

## Technologies Used
- **Java 17**
- **Spring Boot** (Spring Web)
- **Lombok** (for reducing boilerplate code)
- **PostgreSQL** (Relational Database)
- **Mapstruct** (Simplifies the implementation of mappings)
- **Flyway** (database-migration tool)
- **Swagger** (Recommended for API testing)

## Endpoints

### **Swagger**
- **URL**: `http://localhost:8085/swagger-ui`
- **Method**: `GET`

## Setup Instructions

### Prerequisites
- **Java 17** installed.
- **Maven** installed.

### Steps to Run the Application
1. Download and save IMDb dataset files in C:\
2. Clone the repository:
   ```bash
   git clone <repository-url>
   cd imdb_rest_api
   ```
3. Build the application:
   ```bash
   mvn clean package
   ```
4. Run the application:
   ```bash
   java -jar target/imdb_rest_api-1.0.1.jar
   ```
5. Access the API using browser at `http://localhost:8085/swagger-ui`.

