package automation.stepdefinitions;

import automation.core.WebDriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {
    protected static WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(Hooks.class);

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void setUp() {
        driver = WebDriverInstance.getDriver(System.getProperty("browser"));
    }

    @After
    public void onTestFailure(Scenario scenario){
        if(scenario.isFailed()){
            saveScreenshot(scenario.getName());
        }
    }

    private void saveScreenshot(String scenarioName) {
        File screenCapture = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"
                            + getCurrentTimeAsString()
                            +"_"
                            + scenarioName +
                            ".png"));
        } catch (IOException e) {
            log.error("Failed to save screenshot: {}", e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "uuuu-MM-dd_HH-mm-ss" );
        return ZonedDateTime.now().format(formatter);
    }

    @After
    public void stopBrowser() {
        WebDriverInstance.closeDriver();
    }

}
