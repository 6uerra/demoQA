package Driver;
import Data.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.logging.Level;
public class Hook {
    public static WebDriver driver;
    ConfigReader data = new ConfigReader();

    public Hook() throws IOException {
    }

    @Before
    public void driver() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences loggingPrefs = new LoggingPreferences();

        loggingPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("disable-features=NetworkService");
        options.addArguments("remote-allow-origins=*");
        options.addArguments("disable-gpu");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(data.getTimeOut()));
        driver.manage().window().maximize();


    }



    @After
    public void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}
