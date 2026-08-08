# ShelfGuard — E2E QA Automation Suite

Selenium + Java + TestNG framework testing DemoQA's Book Store application:
**Register → Login → Search Book → Add to Collection → Profile (confirmation)**.

## Why DemoQA
DemoQA is purpose-built for automation practice — stable HTML IDs, no OTP,
no real payment gateway, no bot-detection blocking. That means ShelfGuard
runs a genuinely complete end-to-end flow with a real confirmation step (the
added book appearing in your Profile), unlike testing a live commercial site
where checkout requires a real human for OTP and payment.

## Tech Stack
- Java 11, Maven
- Selenium WebDriver 4.21
- TestNG 7.10
- WebDriverManager (auto ChromeDriver setup)
- Page Object Model

## Project Structure
```
src/test/java/
  base/    -> BaseTest.java
  pages/   -> RegisterPage, LoginPage, BookStorePage, ProfilePage
  tests/   -> BookStoreE2ETest.java, LoginTest.java
testng.xml
TestCases.md   -> 9 documented test cases
.github/workflows/run-tests.yml  -> GitHub Actions CI
```

## How to Run Locally (No IDE Needed)
1. Install Java 11+ (https://adoptium.net) and Maven (https://maven.apache.org)
2. Verify: `java -version` and `mvn -version`
3. Run: `mvn clean test`
4. To watch the browser instead of headless:
   - Mac/Linux: `HEADLESS=false mvn clean test`
   - Windows PowerShell: `$env:HEADLESS="false"; mvn clean test`
5. View results: terminal output, or `target/surefire-reports/index.html`

## GitHub Actions
Every push to `main` runs the full suite automatically — check the
"Actions" tab on your repo.
