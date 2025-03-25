package automation.core;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverFactoryConfig {
    private static final Logger log = LoggerFactory.getLogger(WebDriverFactoryConfig.class);
    public static WebDriver getFactoryDriver(BrowserConfigurationType browser){
        return switch (browser) {
            case FIREFOX -> new FireFoxDriverFactory().createDriver();
            case EDGE -> new EdgeDriverFactory().createDriver();
            case CHROME -> new ChromeDriverFactory().createDriver();
            case FIREFOX_HEADLESS -> new FireFoxDriverFactory().createHeadlessDriver();
            case EDGE_HEADLESS -> new EdgeDriverFactory().createHeadlessDriver();
            case CHROME_HEADLESS -> new ChromeDriverFactory().createHeadlessDriver();
            case FIREFOX_PRIVATE_MODE -> new FireFoxDriverFactory().createDriverInPrivateMode();
            case EDGE_INPRIVATE_MODE -> new EdgeDriverFactory().createDriverInPrivateMode();
            case CHROME_INCOGNITO -> new ChromeDriverFactory().createDriverInPrivateMode();
            default -> {
                log.error("Unknown browser");
                yield new EdgeDriverFactory().createDriver();
            }
        };
    }
}
