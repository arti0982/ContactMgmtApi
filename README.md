# CustomerPhoneMgmt

This project is a sample take on retrieving and updating phone numbers for a customer.
## Table of Contents

-   [About](#about)
-   [Getting Started](#getting-started)
    -   [Prerequisites](#prerequisites)
    -   [Installation](#installation)
    -   [Running the Application](#running-the-application)
-   [Usage and Assumptions](#Usage-and-Assumptions)
-   [API Documentation](#api-documentation)
-   [Improvements](#Improvements)

## About

CustomerPhoneMgmt is a SPRING BOOT application demonstrating some sample REST API calls to
- Retrieve phone numbers associated with a customer of a Telco company.
- Ability to call an API to activate a phone number associated to a customer.
- Retrieve all phone numbers of the company.

A phone number is always associated with a customer and a customer can have multiple phone numbers.

## Getting Started

### Prerequisites

-   Java version (8 or later)
-   Maven
-   Spring Boot
-   Lombok
-   OpenAPI

### Installation

1.  Clone the repository:
    ```bash
    git clone https://github.com/arti0982/CustomerPhoneMgmt.git
    ```
2.  Navigate to the project directory:
    ```bash
    cd [your-project-directory]
    ```
3.  Build the application using Maven:

    **Maven:**
    ```bash
    ./mvnw clean install
    ```

### Running the Application

1.  Run the Spring Boot application via below options.
-   Run the CustomerPhoneMgmtApiApplication.java class via any editor like Intellij

-    **Maven:**
    ```bash
    ./mvnw spring-boot:run
    ```

2.  The application will start on port number 8080.


### Usage and Assumptions
As mentioned in the requirements this application does not involve data retrieval or updates from a database.
Instead the data setup is loaded at startup and the set up populates a hashmap the code for which is in the class **StaticCustomerPhoneData**
The phone number is validated to check if its a 10 digit number starting with a 0

Below are details of the API calls implemented

- A GET request send to http://localhost:8080/ returns a 200 response code on success as well as all phone number entries that are available in setup.

- A GET request send to http://localhost:8080/customers/{customerId}/phone-numbers returns a 200 response code on success as well as the phone numbers associated with the customer id passed. It  returns 404 if the requested customer id was not found and 400 if the customer id is not in expected format.

- A PATCH request send to http://localhost:8080/customers/{customerId}/phone-numbers/{phoneNumber} returns a 200 response code on successful update of Active flag of the phone number passed along with the customer id. It  returns 404 if the requested customer id or phone number were not found and 400 if the customer id / phone number is not in expected format.

### API Documentation

"API documentation available at http://localhost:8080/swagger-ui/index.html#/"

### Improvements
The current implementation the data is not fetched from database but rather set up in a hashmap at the startup for better search performance.
The API call for getting all the phone numbers will retrieve a large data set which will demand the need to introduce pagination for that API. Given the choice of dataset and its characteristic pagination is not implemented in current solution.



