# PersonServletDemo

## Overview
This is a **small Java Servlet project** developed as part of the **JobinTech training**, specifically in the **JEE module**. The project demonstrates how to connect a **Java web application** to a **MySQL database** and display data dynamically in an HTML table.

## Project Purpose
The main goal of this demo is to showcase the **Servlet-JDBC integration**:

- Connecting to a MySQL database.
- Executing **SQL queries** using JDBC.
- Retrieving data from a table (`Person`).
- Displaying the results dynamically in a **HTML table** through a Servlet.

## Technology Stack
- **Java 17+**
- **Jakarta Servlet API**
- **JDBC (Java Database Connectivity)**
- **MySQL Database**
- **Tomcat 9+ (or any compatible servlet container)**

## Key Features
- A `DFSExemple` Servlet handles HTTP requests and retrieves data from the `Person` table.
- Uses **try-with-resources** for safe management of JDBC resources.
- Dynamically generates an **HTML table** with all records from the database.
- Handles SQL exceptions and displays error messages gracefully.

## How It Works
1. The user accesses the servlet URL: `/DFSExemple`.
2. The Servlet establishes a connection to the MySQL database using JDBC.
3. Executes a **SELECT query** to fetch all records from the `Person` table.
4. Iterates through the **ResultSet** and prints each row as an HTML table row.
5. The result is displayed in the browser as a styled table with columns: `Id`, `Nom`, `Prenom`, `DateNaissance`, and `Moyenne`.

## Usage
1. Configure your MySQL database and update the connection string in the Servlet.
2. Deploy the project on a **servlet container** (e.g., Tomcat).
3. Access the Servlet URL in a browser to view the `Person` table.

## Notes
- This project is a **hands-on demo** from the JobinTech JEE training.  
- It focuses on **Servlets, JDBC, and dynamic HTML generation**.

## Screenshot
![Screenshot Placeholder](path/to/screenshot.png)
