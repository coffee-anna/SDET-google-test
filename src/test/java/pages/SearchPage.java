package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tests.BaseTest;

public class SearchPage extends BaseTest {
    WebDriver driver;
    WebElement searchLine;
    final String pageUrl = "https://google.com";
    final String calcRequest = "калькулятор";

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        driver.get(pageUrl);
    }

    @Step("Redirecting to calculator page...")
    public CalculatorPage goToCalc() {
        searchLine = driver.findElement(By.name("q"));
        searchLine.sendKeys(calcRequest, Keys.ENTER);
        return new CalculatorPage(driver);
    }
}