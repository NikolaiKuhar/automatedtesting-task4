
# Task #4 — Domain Testing

## 1. Task Description

The user enters three positive integers (a, b, c).
The application determines whether these numbers
can represent the sides of a triangle.

If the triangle exists, the application determines
its type: right-angled, acute-angled or obtuse-angled.

## 2. Equivalence Partitioning

| ID | Equivalence Class | Expected Result |
|---|---|---|
| EC-01 | Valid right-angled triangle | RIGHT |
| EC-02 | Valid acute-angled triangle | ACUTE |
| EC-03 | Valid obtuse-angled triangle | OBTUSE |
| EC-04 | Triangle inequality is not satisfied | NOT_A_TRIANGLE |
| EC-05 | Zero or negative side | INVALID_INPUT |
| EC-06 | Non-integer input | Invalid input |
| EC-07 | Value outside the supported integer range | Invalid input |
| EC-08 | Insufficient input values | Invalid input |

## 3. Domain Testing Table

### 3.1. Triangle Validation and Classification

| ID | a | b | c | isTriangle | Classification | Description |
|---|---:|---:|---:|---|---|---|
| TC-01 | 3 | 4 | 5 | true | RIGHT | Right-angled triangle |
| TC-02 | 5 | 3 | 4 | true | RIGHT | Different side order |
| TC-03 | 3 | 3 | 3 | true | ACUTE | Equal sides |
| TC-04 | 4 | 5 | 6 | true | ACUTE | Different sides |
| TC-05 | 2 | 3 | 4 | true | OBTUSE | Valid boundary value |
| TC-06 | 3 | 3 | 5 | true | OBTUSE | Two equal sides |
| TC-07 | 1 | 1 | 1 | true | ACUTE | Minimum positive values |
| TC-08 | 1 | 2 | 3 | false | NOT_A_TRIANGLE | Equal to the boundary |
| TC-09 | 1 | 2 | 4 | false | NOT_A_TRIANGLE | Invalid triangle |
| TC-10 | 2 | 3 | 5 | false | NOT_A_TRIANGLE | Equal to the boundary |
| TC-11 | 2 | 3 | 6 | false | NOT_A_TRIANGLE | Above the boundary |
| TC-12 | 0 | 3 | 4 | false | INVALID_INPUT | Zero first side |
| TC-13 | -1 | 3 | 4 | false | INVALID_INPUT | Negative first side |
| TC-14 | 3 | 0 | 4 | false | INVALID_INPUT | Zero second side |
| TC-15 | 3 | 4 | -1 | false | INVALID_INPUT | Negative third side |
| TC-16 | 2147483647 | 2147483647 | 2147483647 | true | ACUTE | Maximum integer values |

### 3.2. Console Input Testing

| ID | Input | Expected Output |
|---|---|---|
| TC-17 | 3 4 5 | Triangle type: Right-angled |
| TC-18 | 3 3 3 | Triangle type: Acute-angled |
| TC-19 | 2 3 4 | Triangle type: Obtuse-angled |
| TC-20 | 1 2 3 | These sides do not form a triangle. |
| TC-21 | 0 3 4 | Invalid input: sides must be positive integers. |
| TC-22 | -1 3 4 | Invalid input: sides must be positive integers. |
| TC-23 | 2.5 3 4 | Invalid input: please enter integers only. |
| TC-24 | abc 3 4 | Invalid input: please enter integers only. |
| TC-25 | 2147483648 3 4 | Invalid input: please enter integers only. |
| TC-26 | 3 4 | Invalid input: three sides are required. |
| TC-27 | Empty input | Invalid input: three sides are required. |

## 4. Boundary Value Analysis

The following boundary values are tested:

- Minimum positive integer: 1
- Zero: 0
- Negative value: -1
- Maximum supported integer: 2147483647
- Value above the supported range: 2147483648

Triangle inequality boundary:

| a | b | c | Condition | Expected Result |
|---:|---:|---:|---|---|
| 2 | 3 | 4 | a + b > c | OBTUSE |
| 2 | 3 | 5 | a + b = c | NOT_A_TRIANGLE |
| 2 | 3 | 6 | a + b < c | NOT_A_TRIANGLE |

## 5. Test Execution

The selected values are used in parameterized
TestNG tests with the @DataProvider annotation.

| Test Method | Number of Executions |
|---|---:|
| testIsTriangle | 16 |
| testClassify | 16 |
| testRun | 11 |
| testMain | 1 |
| Total | 44 |

All 44 test executions passed successfully.

Failures: 0
Errors: 0
Skipped: 0