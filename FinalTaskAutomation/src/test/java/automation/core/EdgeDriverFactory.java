package automation.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EdgeDriverFactory implements WebDriverFactory{
    private static final Logger log= LoggerFactory.getLogger(EdgeDriverFactory.class);
    public WebDriver createDriver(){
        log.info("Creating Edge Driver");
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
