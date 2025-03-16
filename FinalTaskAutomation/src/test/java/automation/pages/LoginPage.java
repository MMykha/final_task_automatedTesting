package automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends AbstractPage {
    private final String PAGE_URL = "";
    private final Logger log = LoggerFactory.getLogger(LoginPage.class);

    private WebElement inputLogin;

    private WebElement inputPassword;

    private WebElement buttonLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LoginPage openPage(){
        driver.navigate().to(PAGE_URL);
        log.info("Login page is opened");
        return this;
    }

    public void Login(String username, String password){

    }

    public String getErrorMessage(){
        return null;
    }
}
