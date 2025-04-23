Final Journal Answers:

How can I ensure that my code, program, or software is functional and secure?
By writing thorough unit and integration tests. Using static analysis tools can also be helpful. Following secure coding practices and regularaly updating needed dependencys is also important.

How do I interpret user needs and incorporate them into a program?
By gathering requirements through interviews and user stories. I prioritze the wanted features, and try to translate them into clear specifications and test cases.

How do I approach designing software?
I begin by trying to understand the user requirements, planning a system architecture, and possibly utilizing UML diagrams. I always try to keep modularity, scalability, and maintainablity in mind when designing software.

# Contact & Appointment Management Java App

A Java-based backend system created as part of my Software Testing coursework at Southern New Hampshire University. This project focuses on building and testing a contact and appointment service with strict validation logic and full JUnit test coverage.

The application includes three core modules: contactservice, appointmentservice, and taskservice. Each module is responsible for managing its own data with proper input validation and exception handling.

## Features

- ✅ Create, read, update, and delete contact records
- ✅ Add, delete, and retrieve appointment records
- ✅ Enforce strict validation rules on input (e.g. phone format, name/address/description length, date constraints)
- ✅ Exception handling for invalid operations
- ✅ Fully tested using JUnit
- ✅ Modular service architecture using Java classes

## Tech Stack

- **Java** – Core development language
- **JUnit 5** – Unit testing framework
- **HashMap** – Internal data storage for both services
- **IntelliJ / Eclipse / Visual Studio Code** – IDE-agnostic development

## What I Learned

- Writing testable Java services using encapsulation and validation
- Structuring Java applications using service-based design
- Mastering JUnit 5
- Implementing exception handling and input validation
- Validating real-world data inputs such as formatted phone numbers and date constraints

## Screenshots
![Junit Coverage Test](https://github.com/user-attachments/assets/211c4e17-5df7-4239-9af0-beb7c403c516)

## How to Run

1. Clone this repository: git clone https://github.com/mkibler7/JUnitTestingProject.git
2. Open the project in your preferred Java IDE (e.g. IntelliJ IDEA, Eclipse)
3. Ensure JUnit 5 is installed (or included as a Maven/Gradle dependency)
4. Run the test files:
   - ContactTest.java
   - ContactServiceTest.java
   - AppointmentTest.java
   - AppointmentServiceTest.java
   - TaskTest.java
   - TaskServiceTest.java

## Contact Info

Created by **Michael Kibler**  
[LinkedIn](https://www.linkedin.com/in/michael-kibler-11369519b/) | [Email](mailto:mpkibler7@gmail.com)
