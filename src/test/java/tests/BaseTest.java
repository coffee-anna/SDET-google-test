package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Flaky;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.nio.file.Files;
import java.nio.file.Path;


public class BaseTest {
    public static WebDriver driver;
    public static ChromeOptions options;

    @Step("Initialization")
    @Description("Setting up Webdriver")
    @BeforeClass
    @Flaky
    public void setUp() {
        //setting chrome driver ver.98
        String os = System.getProperty("os.name").toLowerCase();

        //xattr -d com.apple.quarantine <name-of-executable>
        if (os.contains("win")){System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver_win.exe");}
        if (os.contains("mac")){System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver_mac");}
        else{System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver_linux");}

        options = new ChromeOptions();
        String binary_mac_default = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";
        String binary_mac = "/Volumes/Transcend/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";

        if (Files.exists(Path.of(binary_mac_default))){
            options.setBinary(binary_mac_default);
        }else {
            options.setBinary(binary_mac);
        }

        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
    }

    @Step("Quitting browser...")
    @Description("Quitting web browser")
    @AfterClass
    public void tearDown() {
        //driver.close();
        driver.quit();
    }
}