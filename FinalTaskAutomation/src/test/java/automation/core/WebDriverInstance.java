package automation.core;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverInstance {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static final Logger log= LoggerFactory.getLogger(WebDriverInstance.class);

    private WebDriverInstance() {}

    public static WebDriver getDriver(String browser){
        if( driverThreadLocal.get() == null ){
            log.info("WebDriver initialization for thread {}", Thread.currentThread().getId());
             driverThreadLocal.set(WebDriverFactoryConfig.getFactoryDriver(BrowserConfigurationType.valueOf(browser)));
        }
        return driverThreadLocal.get();
    }

    public static void closeDriver(){
        if( driverThreadLocal.get() != null){
            log.info("Closing driver of thread {}", Thread.currentThread().getId());
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}
