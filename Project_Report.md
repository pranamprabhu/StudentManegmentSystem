# Project Report: Student Management System

## 1. Introduction
The **Student Management System** is a console-based Java application designed to store, manage, and retrieve student records efficiently. The system allows users to interact with a centralized database of students through a menu-driven interface, providing capabilities to add new students, search for existing ones, update their details, and view a comprehensive list of all enrolled students.

## 2. Objectives
The primary objectives of this project were to build a functional CRUD (Create, Read, Update, Delete/Display) application to demonstrate an understanding of foundational data structures and modular programming in Java. Specific learning outcomes include:
* Utilizing single-dimensional **Arrays** for parallel data storage.
* Breaking down complex logic into reusable **Methods**.
* Managing continuous program execution using `while` loops and `switch` statements.
* Handling exceptions and parsing formatted strings (`Integer.parseInt`).
* Formatting console output for improved readability.

## 3. Tools and Technologies Used
* **Programming Language:** Java (Standard Edition)
* **Development Environment:** Visual Studio Code / Command Line
* **Core Libraries:** 
  * `java.util.Scanner` - Used for capturing and processing user inputs from the console.

## 4. Implementation Details

### 4.1 Data Storage (Parallel Arrays)
Since this project focuses on fundamental data structures rather than advanced Collections (like ArrayLists) or Object-Oriented Domain Models, the data is stored in parallel arrays. 
* `int[] studentIds`, `String[] studentNames`, `int[] studentAges`, and `String[] studentGrades` hold the attributes.
* A static `studentCount` integer tracks the current number of enrolled students and acts as the insertion index for new records.

### 4.2 Application Menu & Control Flow
The main method initiates a `while` loop that continuously displays a 5-option menu to the user. A `switch` statement processes the user's input, routing execution to the appropriate helper method (`addStudent`, `searchStudent`, `updateStudent`, or `displayStudents`). Selecting the 'Exit' option changes the loop condition to false, gracefully terminating the program.

### 4.3 Adding and Searching Records
* **Adding:** When a new student is added, the program validates that the provided ID does not already exist by scanning the `studentIds` array. If unique, the data is appended to the next available index across all parallel arrays, and `studentCount` is incremented.
* **Searching:** A linear search algorithm is implemented in the `findStudentIndex()` method. It iterates through the populated portion of the ID array and returns the corresponding index if a match is found, which is then used to retrieve the student's name, age, and grade.

### 4.4 Updating Records
The update functionality leverages the same linear search to locate the student. It then prompts the user for new details. To enhance user experience, if the user presses 'Enter' without typing anything (an empty string), the program retains the original value instead of overwriting it with blank data.

### 4.5 Error Handling and Input Validation
To prevent runtime crashes (`NumberFormatException`), user inputs that require integer conversion (such as selecting a menu option, entering an ID, or entering an age) are wrapped in `try-catch` blocks. If a user inputs text when a number is expected, the system catches the error, alerts the user, and re-prompts them without crashing.

## 5. Conclusion
The Student Management System successfully fulfills all project deliverables. It serves as a robust demonstration of applying core Java principles—specifically arrays, loops, methods, and error handling—to build a practical, menu-driven data management application.
