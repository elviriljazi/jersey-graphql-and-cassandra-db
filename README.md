# Jersey GraphQL Cassandra Project

## Overview

This project is a backend application built using Jersey for RESTful web services, GraphQL for API querying, and Cassandra as the database. The application is deployed on Tomcat 10, making it easy to run in a variety of environments.

## Features

- **Jersey Framework**: Handles RESTful API endpoints with ease.
- **GraphQL Integration**: Enables powerful querying capabilities, allowing clients to request exactly the data they need.
- **Cassandra DB**: Provides a highly scalable and distributed NoSQL database solution, ideal for handling large amounts of data across multiple nodes.
- **Tomcat 10**: Serves as the application server, providing a robust and stable environment for deploying the application.
- **Schema-First Approach**: The GraphQL schema defines the structure of the API, ensuring consistency and type safety.
- **High Performance**: The use of Cassandra and GraphQL ensures high throughput and low latency for data operations.

## Technology Stack

- **Jersey**: RESTful Web Services in Java.
- **GraphQL**: A query language for APIs, integrated with Jersey.
- **Cassandra DB**: A distributed NoSQL database designed to handle large amounts of data across many commodity servers.
- **Tomcat 10**: A widely used servlet container for deploying Java applications.
- **Java**: The primary programming language used in the project.

## Getting Started

### Prerequisites

- **Java 8 or later**
- **Apache Cassandra 3.x or later**
- **Apache Tomcat 10**
- **Maven** (for building the project)

### Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/your-repo-name.git
    cd your-repo-name
    ```

2. **Build the project**:
    ```bash
    mvn clean install
    ```

3. **Deploy to Tomcat**:
    - Copy the generated WAR file from the `target` directory to the Tomcat `webapps` directory.
    - Start Tomcat and access the application via `http://localhost:8080/your-app-name`.

## Usage

- **Access the RESTful API**: `http://localhost:8080/your-app-name/api/`
- **Access the GraphQL API**: `http://localhost:8080/your-app-name/graphql`
