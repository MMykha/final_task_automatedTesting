package automation.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverFactoryConfig {
    private static final Logger log = LoggerFactory.getLogger(WebDriverFactoryConfig.class);
    public static WebDriverFactory getFactory(String browser){
        return switch (browser) {
            case "firefox" -> new FireFoxDriverFactory();
            case "edge" -> new EdgeDriverFactory();
            default -> {
                log.error("Unknown browser");
                yield new EdgeDriverFactory();
            }
        };
    }
}
