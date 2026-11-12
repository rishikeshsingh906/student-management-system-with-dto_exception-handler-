

\# Student Management System



A REST API backend project built using Java 21, Spring Boot and MySQL.



\## Technologies Used



\- Java 21

\- Spring Boot 4.1.2

\- Spring Web MVC

\- Spring Data JPA

\- Hibernate

\- MySQL 8.4

\- Maven

\- Postman



\## Features



\- Create Student

\- Get All Students

\- Get Student By ID

\- Update Student

\- Delete Student



\## API Endpoints



| Method | Endpoint | Description |

|---|---|---|

| POST | /api/students | Add Student |

| GET | /api/students | Get All Students |

| GET | /api/students/{id} | Get Student By ID |

| PUT | /api/students/{id} | Update Student |

| DELETE | /api/students/{id} | Delete Student |



\## Database Configuration



Create database in MySQL:



```sql

CREATE DATABASE student\_db;

```



Configure the following environment variables:



\- DB\_PASSWORD

\- DB\_URL (optional)



Default database URL:



jdbc:mysql://localhost:3306/student\_db



\## How to Run



1\. Clone this repository.

2\. Open the project in IntelliJ IDEA.

3\. Configure MySQL environment variables.

4\. Reload Maven dependencies.

5\. Run BackendApplication.java.



Backend URL: http://localhost:8080



\## Project Status



Version 1: Basic CRUD REST API completed.



\### Upcoming Features



\- DTO and Validation

\- Global Exception Handling

\- React Frontend

\- Frontend and Backend Integration



