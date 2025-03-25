package automation.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

public interface WebDriverAbstractFactory extends WebDriverFactory{
    public WebDriver createHeadlessDriver();
    public WebDriver createDriverInPrivateMode();

    public default void setSizeWindow(WebDriver driver, Logger log, String logMessageType){
        if(System.getProperty("width") != null && System.getProperty("height") != null){
            String width = System.getProperty("width");
            String height = System.getProperty("height");
            log.info("Creating {} with fixed size: {}x{}", logMessageType, width, height);
            driver.manage().window().setSize(new Dimension(Integer.parseInt(width), Integer.parseInt(height)));
        }else{
            log.info("Creating {}", logMessageType);
            driver.manage().window().maximize();
        }
    }

}
