package automation.pages;

import automation.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends AbstractPage {
    private final String PAGE_URL = "https://www.saucedemo.com/";
    private final Logger log = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(xpath="//input[@id='user-name']")
    private WebElement inputUsername;

    @FindBy(xpath="//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath="//input[@id='login-button']")
    private WebElement buttonLogin;

    private final By errorMessageLocator = By.xpath("//div[@id='login_button_container']/descendant::h3");

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LoginPage openPage(){
        driver.navigate().to(PAGE_URL);
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        wait.until(ExpectedConditions.titleContains("Swag Labs"));
        log.info("Login page is opened");
        return this;
    }

    public void fillUsernameInput(User user){
        log.info("Filling input username with {}", user.getUsername());
        inputUsername.sendKeys(user.getUsername());
    }

    public void fillPasswordInput(User user){
        log.info("Filling input password");
        inputPassword.sendKeys(user.getPassword());
    }

    public void clearUsernameInput(){
        log.info("Clearing input username");
        inputUsername.clear();
    }

    public void clearPasswordInput(){
        log.info("Clearing input password");
        inputPassword.clear();
    }

    public void clickLoginButton(){
        log.info("Clicking login button");
        buttonLogin.click();
    }

    public String getErrorMessage(){
        WebElement errorMessage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(errorMessageLocator));
        return errorMessage.getText();
    }
}
