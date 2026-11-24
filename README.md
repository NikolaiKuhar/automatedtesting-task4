
# Automated Testing — Task 4

## Unit Testing: Triangle Classification

### Project Description

This Java console application determines whether
three positive integers can form a triangle.

If the triangle exists, the application classifies it
as right-angled, acute-angled or obtuse-angled.

The application also handles invalid input values.

### Technologies

- Java 21
- Apache Maven
- TestNG 7.10.2
- Git
- IntelliJ IDEA

### Project Structure

    automatedtesting-task4/
    |-- docs/
    |   `-- domain-testing.md
    |-- src/
    |   |-- main/java/com/mikalai/autotesting/
    |   |   |-- Main.java
    |   |   |-- Triangle.java
    |   |   `-- TriangleType.java
    |   `-- test/java/com/mikalai/autotesting/
    |       |-- MainTest.java
    |       `-- TriangleTest.java
    |-- pom.xml
    |-- README.md
    `-- .gitignore

### Application Features

- Positive integer validation
- Triangle inequality validation
- Triangle classification by angles
- Invalid input handling
- Integer overflow prevention in triangle calculations
- Console input and output

### Testing Approach

- Equivalence Partitioning
- Boundary Value Analysis
- Unit Testing
- Data-Driven Testing
- Parameterized tests using TestNG DataProvider

The test data is documented in:

[Domain Testing Table](docs/domain-testing.md)

### How to Run the Application

Compile the project:

    mvn clean compile

Run the application:

    java -cp target/classes com.mikalai.autotesting.Main

Example input:

    3
    4
    5

Expected output:

    Triangle type: Right-angled

### How to Run Tests

Execute all automated tests:

    mvn clean test

### Test Results

| Metric | Result |
|---|---:|
| Tests executed | 44 |
| Passed | 44 |
| Failed | 0 |
| Errors | 0 |
| Skipped | 0 |

Build status: BUILD SUCCESS

### Author

Mikalai Kukhar

Course: Automated Testing

Assignment: Task #4 — Unit Testing
