# Technical assignment 
### requested by :
- Ferhan Yetiş
- Burhan Yetis
- Lobox.com

The purpose is for us to get a better understanding of your technical skills and focus. There is no real deadline but we hope that you will have had the time to finish the project by this time next 2 weeks. Spend a few days on it and attach a summary of what you would have done given more time. The most important things are performance efficiency and code cleanness.



Use IMDB Dataset in order to develop these functionalities using Java 8+ and expose proper RESTful HTTP APIs :

1. Import the dataset into the application
2. Return all the titles in which both director and writer are the same person and he/she is still alive
3. Get two actors and return all the titles in which both of them played at
4. Get a genre from the user and return best titles on each year for that genre based on number of votes and rating
5. Count how many HTTP requests you received in this application since the last startup



Considerations:

●  You Don’t have to use any external database application but if you want to just usethem in in-memory mode, your application should run standalone

●  You are free to use any web framework you like but if you choose anything other than Spring Boot you need to explain why

●  Do not implement any UI
You can find the dataset and its explanation here: https://www.imdb.com/interfaces Let us know if you have any questions and good luck!



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
- **PostgreSQL** installed.
- **Java 17** installed.
- **Maven** installed.

### Steps to Run the Application
1. Download and save IMDb dataset files in C:\
2. Install PostgreSQL, create databse and user lobox identified by lobox with required privileges.
3. Clone the repository:
   ```bash
   git clone <repository-url>
   cd imdb_rest_api
   ```
4. Build the application:
   ```bash
   mvn clean package
   ```
5. Run the application:
   ```bash
   java -jar target/imdb_rest_api-1.0.1.jar
   ```
6. Access the API using browser at `http://localhost:8085/swagger-ui`.

