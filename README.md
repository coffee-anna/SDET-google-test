# Google Calculator Testing

Java project for Google calculator tests execution.
Firstly, chromedriver and Chrome app are initialised, then calculator page is got with search engine. Three test cases based on *Base Test*. Each of them require set up and tear down of browser and driver. 
- Java
- Selenium Webdriver (Google Chrome)
- TestNG
- Gradle
- Page Object Model
- Allure

## Usage

Clone the repo:
```java
git clone https://github.com/coffee-anna/google-calculator-testing
```
For MAC OS users:
```java
cd src/test/resources/drivers/chromedriver_mac
xattr -d com.apple.quarantine chromedriver
```
Tests execution:
```java
./gradlew clean test
```
Get pretty allure report:
```java
allure generate allure-results --clean
allure open
```