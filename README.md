# Student-Grade-Calculator
An interactive console-based Student Grade Calculator implemented in Java, featuring dynamic average percentage computation, robust input validation, scalable grading logic, and customized performance feedback.
# Student Grade Calculator (Java)

A clean, modular, and interactive console application built in Java to automate the calculation of student grades. The system processes raw marks across multiple subjects, computes total metrics and average percentages, assigns an alphabetical grade, and generates custom performance evaluations.

## 🚀 Features

* **Dynamic Data Collection:** Allows users to input an custom number of subjects and seamlessly collects data for each one.
* **Robust Input Validation:** Utilizes `try-catch` blocks and exception handling (`InputMismatchException`) to ensure that inputs remain strictly within numeric boundaries (0-100 marks) and prevents system crashes from typos.
* **Automated Grading Scale:** Dynamically maps out performance percentages to classic GPA scales:
  * **A:** $\ge 90\%$ (Top Performer)
  * **B:** $80\% - 89\%$ (Great Job)
  * **C:** $70\% - 79\%$ (Good Job)
  * **D:** $60\% - 69\%$ (Satisfactory)
  * **F:** $< 60\%$ (Needs Improvement)
* **Session Replay Loops:** Includes an interactive post-report prompt asking users if they would like to process grades for another student without restarting the application.

## 📊 Technical Architecture

The program is cleanly separated into helper routines to ensure maximum code reusability and clarity:
* `getNumberOfSubjects()` & `getValidatedMark()`: Enforces robust entry constraints.
* `calculateAverage()` & `determineGrade()`: Handles the logical and mathematical calculations.
* `displayResult()` & `displayPerformanceMessage()`: Manages the stylized console user output.

## 🎮 How to Run

1. Ensure you have **JDK 8 or higher** installed on your machine.
2. Compile the source code:
   ```bash
   javac Student.java
