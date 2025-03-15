package automation.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FireFoxDriverFactory implements WebDriverFactory {
    private static final Logger log= LoggerFactory.getLogger(FireFoxDriverFactory.class);
    public WebDriver createDriver() {
        log.info("Creating FireFox Driver");
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
