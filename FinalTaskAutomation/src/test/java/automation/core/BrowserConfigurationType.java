package automation.core;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public enum BrowserConfigurationType {
    FIREFOX_HEADLESS,
    FIREFOX_PRIVATE_MODE,
    EDGE_HEADLESS,
    EDGE_INPRIVATE_MODE,
    CHROME_HEADLESS,
    CHROME_INCOGNITO,
    FIREFOX,
    CHROME,
    EDGE;
}
