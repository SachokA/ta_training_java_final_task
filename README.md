# Test Automation for Login Form

This project involves the automation of testing a login form on the website [https://www.saucedemo.com/](https://www.saucedemo.com/). The tests are designed to validate different scenarios for the login form using Selenium WebDriver, Maven, TestNG, and AssertJ, with a focus on Behavior-Driven Development (BDD).

## Test Cases

   **UC-1: Test Login Form with Empty Credentials**
   - **Steps:**
    1. Type any credentials into the "Username" and "Password" fields.
    2. Clear the inputs.
    3. Hit the "Login" button.
  - **Expected Result:**
    Error message: "Username is required."

   **UC-2: Test Login Form with Credentials by Passing Username**
   - **Steps:**
    1. Type any credentials in the "Username" field.
    2. Enter a password.
    3. Clear the "Password" input.
    4. Hit the "Login" button.
  - **Expected Result:**
    Error message: "Password is required."

   **UC-3: Test Login Form with Credentials by Passing Username & Password**
   - **Steps:**
    1. Type accepted credentials in the "Username" field.
    2. Enter the password "secret sauce."
    3. Click the "Login" button.
  - **Expected Result:**
    Validate the title "Swag Labs" on the dashboard.

## Test Automation Setup

- **Test Automation Tool:** Selenium WebDriver
- **Project Builder:** Maven
- **Browsers:**
    - Firefox
    - Chrome
- **Locators:** CSS
- **Test Runner:** TestNG
- **Test Automation Approach:** BDD
- **Assertions:** AssertJ
- **Optional:**
    - **Design Patterns:**
        - Singleton
        - Adapter
        - Strategy
    - **Loggers:** SLF4J


## Notes

- Ensure that the browsers are set up properly and WebDriver binaries are correctly configured.
- The project uses CSS locators for interacting with web elements.
- For optional patterns, ensure that the design patterns are properly implemented in the codebase.
- Logs are generated using SLF4J to help trace the execution flow and diagnose issues.

## Author
- **Name:** Aliona Sachok
- **Course:** Final Assignment for TA_JAVA

For further details, refer to the project's documentation and configuration files.