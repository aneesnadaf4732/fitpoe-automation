FitPeo Test Automation

Overview

This project contains an automation script for testing the FitPeo website using Selenium WebDriver with Java and TestNG. It includes a script that interacts with the website and validates certain input fields.

Setup Instructions

Prerequisites

1. Java Development Kit (JDK)**: Ensure that JDK 8 or higher is installed.
2. Maven: This project uses Maven for dependency management.
3. ChromeDriver: Download ChromeDriver and set its path in the `FitPeo.java` file.

Steps to Set Up

1. Clone the Repository

   sh
   git clone <repository-url>
   cd <repository-directory>
   Install Dependencies

Navigate to the project directory and run:

sh
Copy code
mvn install
Configure ChromeDriver

Update the path to ChromeDriver in FitPeo.java:
System.setProperty("webdriver.chrome.driver", "C:\\Users\\anees\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
Run the Tests

Use Maven to run the tests:
mvn test
Alternatively, you can run the tests from Eclipse IDE.

Test Details

Test Class: FitPeo.java
Test Method: testFitPoe

Description: Navigates the FitPeo website, interacts with elements, sets input values, and performs validations.
Troubleshooting

Compilation Issues: Ensure all dependencies are properly set up and imported.

Element Locator Issues: Verify XPath or element locators for accuracy.

Value Setting Issues: Confirm that JavaScript is executing correctly to set values.
Contributing
Feel free to fork, modify, and submit pull requests. Please ensure code adheres to best practices and includes necessary test cases.

License
This project is licensed under the MIT License. See the LICENSE file for details.

Contact
For questions or support, please contact:
Anees Nadaf anees26337nadaf@gmail.com


