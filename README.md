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

📁 Project Structure

ExpenseTracker/
│
├── src/
│   ├── model/
│   │   └── Expense.java
│   │
│   ├── repository/
│   │   └── ExpenseRepository.java
│   │
│   ├── service/
│   │   └── ExpenseService.java
│   │
│   ├── util/
│   │   └── InputUtil.java
│   │
│   └── Main.java
│
├── data/
│   └── expenses.txt
│
├── .gitignore
└── README.md

▶️ How to Run

1. Clone the repository

git clone https://github.com/indreshps5/Expense-Tracker.git

2. Navigate to the project

cd Expense-Tracker

3. Compile the project

javac -d . src\model\Expense.java src\service\ExpenseService.java src\repository\ExpenseRepository.java src\util\InputUtil.java src\main.java

4. Run the application

java -cp . main

🖥️ Application Menu

================================
         EXPENSE TRACKER
================================
1. Add Expense
2. View All Expenses
3. Find Expense
4. Update Expense
5. Delete Expense
6. Search Expense
7. Expense Summary
0. Exit
================================

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
