💰 Expense Tracker

A console-based Expense Tracker application built with Java to manage and track personal expenses.

This is Version 1 of the project. The main goal of this version was to strengthen my understanding of Java, Object-Oriented Programming, collections, file handling, exception handling, and project structure.

✨ Features

- ➕ Add a new expense
- 📋 View all expenses
- 🔍 Find an expense by ID
- ✏️ Update an existing expense
- 🗑️ Delete an expense
- 🔎 Search expenses by category or description
- 📊 Calculate total expenses
- 📂 Calculate expenses by category
- 💾 Store expenses in a text file
- 🆔 Automatic expense ID generation
- 📅 Store expense dates using "LocalDate"

🛠️ Technologies & Concepts

- Java
- Object-Oriented Programming (OOP)
- Classes and Objects
- Encapsulation
- "ArrayList"
- Exception Handling
- File Handling
- "BufferedWriter"
- "FileWriter"
- "LocalDate"
- Java Packages
- Git & GitHub

<h2>📁 Project Structure</h2>

<pre>
ExpenseTracker/
|
+-- src/
|   +-- model/
|   |   +-- Expense.java
|   |
|   +-- repository/
|   |   +-- ExpenseRepository.java
|   |
|   +-- service/
|   |   +-- ExpenseService.java
|   |
|   +-- util/
|   |   +-- InputUtil.java
|   |
|   +-- Main.java
|
+-- data/
|   +-- expenses.txt
|
+-- .gitignore
+-- README.md
</pre>


▶️ How to Run

1. Clone the repository

git clone https://github.com/indreshps5/Expense-Tracker.git

2. Navigate to the project

cd Expense-Tracker

3. Compile the project

javac -d . src\model\Expense.java src\service\ExpenseService.java src\repository\ExpenseRepository.java src\util\InputUtil.java src\Main.java

4. Run the application

java -cp . Main

## 🖥️ Application Menu

<pre>
╔══════════════════════════════════════════╗
║            💰 EXPENSE TRACKER            ║
╠══════════════════════════════════════════╣
║                                          ║
║   1.  Add Expense                        ║
║   2.  View All Expenses                  ║
║   3.  Find Expense                       ║
║   4.  Update Expense                     ║
║   5.  Delete Expense                     ║
║   6.  Search Expense                     ║
║   7.  Expense Summary                    ║
║   8.  Exit                               ║
║                                          ║
╚══════════════════════════════════════════╝
</pre>

💾 Data Storage

Version 1 uses a simple text file for storing expense data.

Each expense contains:

ID
Amount
Category
Description
Date
Payment Method

The data is stored locally in:

data/expenses.txt

🚀 Future Improvements

This is only Version 1. Future versions may include:

- MySQL database integration
- JDBC
- Improved data persistence
- Spring Boot backend
- REST APIs
- Web-based frontend
- User authentication
- Expense analytics and dashboards

📌 Version

Current Version: v1.0

This version focuses on building a strong foundation in Java and backend development concepts.

---

👨‍💻 Author

Indresh Pratap Singh

Computer Science & Engineering Student

---

⭐ If you found this project interesting, feel free to explore the repository and follow its future versions.

















💰 Expense Tracker

A console-based Expense Tracker application built with Java to manage and track personal expenses.

The project started with Version 1, which focused on Java fundamentals and file handling. The current version, Version 2, upgrades the application to use MySQL and JDBC for database-based persistence.

✨ Features

- ➕ Add a new expense
- 📋 View all expenses
- ✏️ Update an existing expense
- 🗑 Delete an expense
- 🔍 Find an expense by ID
- 🔎 Search expenses by category or description
- 📊 Calculate total expenses
- 📂 Generate category-wise expense summaries
- 📅 Search expenses within a date range
- 🆔 Automatic expense ID generation using MySQL
- 💾 Store expenses in a MySQL database
- ✅ Input validation and error handling

🛠 Technologies & Concepts

- Java
- Object-Oriented Programming (OOP)
- Encapsulation
- Collections
- Exception Handling
- MySQL
- JDBC
- Maven
- PreparedStatement
- ResultSet
- SQL CRUD operations
- SQL aggregation and filtering
- LocalDate
- Java Packages
- Environment Variables
- Git & GitHub

📁 Project Structure

<pre>
ExpenseTracker/
|
+-- src/
|   +-- main/
|       +-- java/
|           +-- dao/
|           |   +-- ExpenseDAO.java
|           |
|           +-- database/
|           |   +-- DBConnection.java
|           |
|           +-- model/
|           |   +-- Expense.java
|           |
|           +-- InputHelper.java
|           +-- Main.java
|
+-- pom.xml
+-- .gitignore
+-- README.md
</pre>🗄️ Database

Version 2 uses MySQL for storing expense data.

Database

CREATE DATABASE expense_tracker;

Table

CREATE TABLE expenses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    amount DOUBLE NOT NULL,
    category VARCHAR(50) NOT NULL,
    description VARCHAR(255),
    expense_date DATE NOT NULL,
    payment_method VARCHAR(50)
);

Each expense contains:

- ID
- Amount
- Category
- Description
- Date
- Payment Method

The expense ID is automatically generated by MySQL using "AUTO_INCREMENT".

🔐 Database Configuration

The database password is not stored in the source code.

The application reads the MySQL password from the environment variable:

DB_PASSWORD

Before running the application, set the environment variable with your own MySQL password.

For example, on Windows:

setx DB_PASSWORD "your-password"

After setting it, restart your terminal before running the application.

«Never commit your actual database password to GitHub.»

▶️ How to Run

1. Clone the repository

git clone https://github.com/indreshps5/Expense-Tracker.git

2. Navigate to the project

cd Expense-Tracker

3. Make sure MySQL is running

Create the "expense_tracker" database and "expenses" table using the SQL commands above.

4. Configure the database password

Set the "DB_PASSWORD" environment variable with your MySQL password.

5. Build the project using Maven

mvn clean package

6. Run the application

mvn exec:java

«If the Maven Exec plugin is not configured, the application can also be run using the compiled classes and Maven dependencies.»

🖥️ Application Menu

<pre>
===== EXPENSE TRACKER V2 =====
1. Add Expense
2. View Expenses
3. Update Expense
4. Find Expense by ID
5. Search Expenses
6. Total Expense
7. Category-wise Summary
8. Delete Expense
9. Find Expenses by Date Range
0. Exit
</pre>🚀 Version History

Version 2.0 — Current

- MySQL database integration
- JDBC
- Maven project structure
- CRUD operations
- Search functionality
- Category-wise summary
- Date-range search
- Input validation
- Automatic database-generated IDs
- Environment variable for database password

Version 1.0

The first version focused on building the foundation of the application using:

- Java
- OOP
- Collections
- File handling
- Exception handling
- LocalDate

Version 1.0 is preserved in the Git history and can be accessed through the "v1.0" tag/release.

📌 Current Version

v2.0

Version 2 moves the project from file-based storage to a MySQL database using JDBC and Maven, providing a stronger foundation for future Java backend development.

🚀 Future Improvements

Planned future versions may include:

- Spring Boot backend
- REST APIs
- Web-based frontend
- User authentication
- Expense analytics and dashboards
- Full-stack integration

---

👨‍💻 Author

Indresh Pratap Singh

Computer Science & Engineering Student

---

⭐ If you found this project interesting, feel free to explore the repository and follow its future development.
