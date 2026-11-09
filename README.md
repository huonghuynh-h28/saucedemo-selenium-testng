# SauceDemo Web Test Automation

Automated UI tests for [saucedemo.com](https://www.saucedemo.com) built with **Java, Selenium WebDriver, TestNG** and the **Page Object Model (POM)**. Test results are published as an **Allure** report.

## Tech stack

| Tool | Purpose |
|---|---|
| Java 25 | Language |
| Selenium WebDriver 4.51 | Browser automation |
| TestNG | Test framework and assertions |
| Maven | Build and dependency management |
| Allure Report | HTML test report |
| Page Object Model | Keeps locators and actions out of the tests |

## Project structure

```
src
├── main/java/pages        # Page objects: LoginPage, InventoryPage, CheckoutPage
└── test/java
    ├── base/BaseTest      # Browser setup and teardown
    └── tests              # LoginTest, CartTest, CheckoutTest
testng.xml                 # Test suite definition
```

## Test cases

| ID | Title | Expected result |
|---|---|---|
| TC01 | Login with valid credentials | User is redirected to the Products page |
| TC02 | Login with invalid password | Error message is displayed |
| TC03 | Login with a locked-out account | "Locked out" error message is displayed |
| TC04 | Add a product to the cart | Cart badge shows 1 |
| TC05 | Complete checkout successfully | "Thank you for your order!" is displayed |
| TC06 | Checkout with missing First Name | "First Name is required" error is displayed |

## How to run

**Prerequisites:** JDK 25, Maven, Google Chrome.

```bash
git clone https://github.com/huonghuynh-h28/saucedemo-selenium-testng.git
cd saucedemo-selenium-testng
mvn clean test
```

## View the Allure report

Install [Allure](https://allurereport.org/docs/install/) (on macOS: `brew install allure`), then:

```bash
allure serve target/allure-results
```

## Key practices used

- Page Object Model: one class per page, tests read like user stories.
- Explicit waits instead of `Thread.sleep`.
- Browser setup in a shared `BaseTest` (disables the Chrome password popup, runs in incognito).
- Test data and expected messages verified against the real site.