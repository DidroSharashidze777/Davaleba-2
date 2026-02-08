# DidroSharashidze

TestNG Practical Project with Java + Selenium WebDriver - Parallel Execution Framework

## Project Overview

This project demonstrates a complete test automation framework using:
- **Java 17+**
- **Selenium WebDriver 4.15.0**
- **TestNG 7.9.0**
- **Maven** for build management
- **Parallel execution** using testng.xml

## Features

✅ Two Test Classes running in parallel  
✅ Page Object Model approach  
✅ WebDriverManager for automatic driver management  
✅ Explicit waits (no Thread.sleep)  
✅ Relative XPath selectors  
✅ TestNG Assertions  
✅ Parallel execution configuration  

## Test Classes

### 1. FormTests
- **URL**: https://demoqa.com/automation-practice-form
- **Test Case**: Fill automation practice form and verify submission pop-up
- **Coverage**:
  - Form fields completion
  - Dropdown selection
  - Radio button selection
  - Checkbox selection
  - Date selection
  - Modal verification with assertions

### 2. AlertTests
- **URL**: https://demo.automationtesting.in/Alerts.html
- **Test Case**: Handle alert with text input and verify result
- **Coverage**:
  - Alert handling
  - Text input in alerts
  - Accept alert action
  - Result verification with assertions

## Project Structure

```
DidroSharashidze/
├── pom.xml
├── README.md
├── .gitignore
└── src/
    └── test/
        ├── java/
        │   └── com/automation/
        │       ├── base/
        │       │   └── BaseTest.java
        │       └── tests/
        │           ├── FormTests.java
        │           └── AlertTests.java
        └── resources/
            └── testng.xml
```

## Setup Instructions

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Chrome browser

### Installation

1. Clone the repository:
```bash
git clone <repo-url>
cd DidroSharashidze
```

2. Install dependencies:
```bash
mvn clean install
```

## Running Tests

### Run all tests in parallel:
```bash
mvn clean test
```

### Run specific test class:
```bash
mvn -Dtest=FormTests test
mvn -Dtest=AlertTests test
```

### Run with custom testng.xml:
```bash
mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testng.xml
```

## Parallel Execution Configuration

The `testng.xml` is configured with:
- **parallel="classes"** - Runs test classes in parallel
- **thread-count="2"** - Number of parallel threads

Both test classes (FormTests and AlertTests) will execute simultaneously.

## Dependencies

- **Selenium WebDriver**: 4.15.0
- **TestNG**: 7.9.0
- **WebDriverManager**: 5.6.3 (automatic driver management)
- **Log4j**: 2.21.1

## Best Practices Used

1. ✅ **No hardcoded waits** - Using WebDriverWait for explicit waits
2. ✅ **Relative XPath** - All XPath selectors are relative, not absolute
3. ✅ **Base Test Class** - Common setup/teardown logic
4. ✅ **TestNG Assertions** - Using TestNG assertions for validations
5. ✅ **WebDriverManager** - Automatic driver management, no manual driver setup
6. ✅ **Parallel Execution** - Classes run in parallel using testng.xml

## Browser Support

Currently configured for Chrome. To add other browsers:
- Update ChromeDriver in BaseTest.java
- Configure in testng.xml

---

**Author**: Didro Sharashidze  
**Branch**: HomeWork2  
**Created**: February 8, 2026
