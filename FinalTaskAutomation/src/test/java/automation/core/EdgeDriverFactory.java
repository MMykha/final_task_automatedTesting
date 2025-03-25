package automation.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EdgeDriverFactory implements WebDriverAbstractFactory{
    private static final Logger log= LoggerFactory.getLogger(EdgeDriverFactory.class);
    private final EdgeOptions options = new EdgeOptions();
    private WebDriver driver;

    @Override
    public WebDriver createDriver(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        setSizeWindow(driver, log,"Edge Driver");
        return driver;
    }

    @Override
    public WebDriver createHeadlessDriver(){
        options.addArguments("-headless");
        options.addArguments("-disable-gpu");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver(options);
        setSizeWindow(driver, log,"Headless Edge Driver");
        return driver;
    }

    @Override
    public WebDriver createDriverInPrivateMode(){
        options.addArguments("-inprivate");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver(options);
        setSizeWindow(driver, log,"Edge Driver in private mode");
        return driver;
    }

}
