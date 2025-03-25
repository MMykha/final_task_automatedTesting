package automation.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FireFoxDriverFactory implements WebDriverAbstractFactory {
    private static final Logger log= LoggerFactory.getLogger(FireFoxDriverFactory.class);
    private final FirefoxOptions options = new FirefoxOptions();
    private WebDriver driver;

    @Override
    public WebDriver createDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        setSizeWindow(driver, log,"FireFox Driver");
        return driver;
    }

    @Override
    public WebDriver createHeadlessDriver(){
        options.addArguments("--headless");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(options);
        setSizeWindow(driver, log,"Headless FireFox Driver");
        return driver;
    }

    @Override
    public WebDriver createDriverInPrivateMode(){
        log.info("Creating FirefoxDriver Driver in Private mode");
        options.addArguments("-private");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(options);
        setSizeWindow(driver, log,"FireFox Driver in private mode");
        return driver;
    }

}
