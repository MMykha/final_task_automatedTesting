package automation.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChromeDriverFactory implements WebDriverAbstractFactory {
    private static final Logger log= LoggerFactory.getLogger(ChromeDriverFactory.class);
    private final ChromeOptions options = new ChromeOptions();
    private WebDriver driver;

    @Override
    public WebDriver createDriver(){
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver();
        setSizeWindow(driver, log,"Chrome Driver");
        return driver;
    }

    @Override
    public WebDriver createHeadlessDriver(){
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        setSizeWindow(driver, log,"Headless Chrome Driver");
        return driver;
    }

    @Override
    public WebDriver createDriverInPrivateMode(){
        options.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        setSizeWindow(driver, log,"Incognito Chrome Driver");
        return driver;
    }

}
