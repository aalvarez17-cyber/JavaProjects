# Help Desk Ticket Management System
Author: Alexis Alvarez
ITMD 411 – Final Project

## Description
This project is a Java based Help Desk Ticket Management System.
This application allows users to log in, create tickets, and view their own tickets.
Administrators have additional features that allows them to view, update, close, and delete all tickets.

The system uses a MySQL database for storing the tickets and includes password hashing
for ensuring secure authentication when users log in.

------------------------------------------------------------------------------------------------------------------------------

## Features

### User Features
- Secure login with hashed passwords
- Create new support tickets
- View only tickets created by the logged in user

### Admin Features
- View all tickets in the system
- Update ticket status and resolution notes
- Close tickets (automatically sets close date)
- Delete tickets

------------------------------------------------------------------------------------------------------------------------------

## Technologies Used
- Java (Swing for GUI)
- MySQL (remote database)
- JDBC
- SHA-256 password hashing
- Executable JAR 

---

## How to Run the Program

### Requirements
- Internet connection (database is remote)

### Steps
1. Download `HelpDesk.jar`
2. Open a terminal and make sure you are in the in the folder containing the JAR
3. Run the application using your terminal and type this command:

  java -jar HelpDesk.jar
