package tests;

import io.qameta.allure.Description;
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
    public void setUp() {
        //setting chrome driver ver.98
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")){System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver_win.exe");}
        if (os.contains("mac")){System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver_mac");}
        else{System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver_linux");}

        // specifying the Chrome binary location
        options = new ChromeOptions();
        String binary_mac_default = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";
        String binary_mac = "/Volumes/Transcend/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";
        String binary_win = "C:\\Users\\%USERNAME%\\AppData\\Local\\Google\\ Chrome\\Application\\chrome.exe";
        String binary_lin = "/usr/bin/google-chrome";

        if (Files.exists(Path.of(binary_mac_default))){
            options.setBinary(binary_mac_default);
        }else if (Files.exists(Path.of(binary_mac))){
            options.setBinary(binary_mac);
        }else if (Files.exists(Path.of(binary_win))){
            options.setBinary(binary_win);
        }else if (Files.exists(Path.of(binary_lin))){
            options.setBinary(binary_lin);
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