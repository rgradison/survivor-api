# Survivor API

The Survivor API is a RESTful web service for managing information about survivors during a robot apocalypse. It allows users to add survivors, update their locations, flag them as infected, and retrieve various reports about survivors and robots.

## Table of Contents
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Usage](#usage)
  - [Endpoints](#endpoints)
  - [Sample Request](#Post Request Response)
  - [API Documentation](#api-documentation)
- [Configuration](#configuration)
- [Contributing](#contributing)


# Getting Started

### Prerequisites

To run the Survivor API, you need the following prerequisites:
===
- Java 8 or higher
- Apache Maven
- PostgreSQL database
- I used intellij idea

### Installation

1. Clone this repository to your local machine:
   ```bash
   git clone https://github.com/rgradison/survivor-api.git
1.Navigate to the project directory:
===
    cd survivor-api
2.Build the project using Maven:
===
    mvn clean install
3.Run the application:
===
java -jar target/survivor-api-1.0.0.jar

The application will start and be accessible at: 
===
http://localhost:8080.

### Usage:

### Endpoints
- Add Survivor: Create a new survivor with a name, age, gender, and inventory of resources (Water, Food, Medication, Ammunition). (POST /api/survivors)

- Update Survivor Location: Update a survivor's last location using their latitude and longitude. (PUT /api/survivors/{survivorId}/location)

- Flag Survivor as Infected: Mark a survivor as infected when reported by at least three other survivors. (POST /api/survivors/{survivorId}/flagInfected)

- Reports: Retrieve various reports on survivors and robots, including percentages of infected survivors and lists of infected/non-infected survivors and robots.

- List of Robots: Fetch the list of robots and their known locations from an external source. (GET /api/reports/robots)

## Post Request Response
### Request

{
  "name": "John Doe",
  "age": 30,
  "gender": "Male",
   "survivorId":"123400812",
  "lastLocation": {
    "latitude": 40.7128,
    "longitude": -74.0060
  },
  "resources": {
    "WATER": 5,
    "FOOD": 10,
    "MEDICATION": 3,
    "AMMUNITION": 50
  }
}
### Response

### status: 200 OK

{
"id": 5,
"name": "John Doe",
"age": 30,
"gender": "Male",
"lastLocation": {
"latitude": 40.7128,
"longitude": -74.006
},
"resources": {
"WATER": 5,
"FOOD": 10,
"MEDICATION": 3,
"AMMUNITION": 50
},
"survivorId": "123400812",
"infected": false
}

## API Documentation
You can access the API documentation by visiting http://localhost:8080/swagger-ui.html after starting the application. The interactive Swagger documentation provides details about the available endpoints and allows you to test them.

## Configuration
You can configure the application properties in the application.properties file. Be sure to set up your PostgreSQL database and any other necessary configurations.

## Contributing
Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them.
4. Push your changes to your fork.
5. Create a pull request with a clear description of your changes.