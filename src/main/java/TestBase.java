package main.java;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.Properties;

public class TestBase {

    public WebDriver driver;
    public Eyes eyes;

    @BeforeClass
    public void initializeEyes(){
        String properiesFilePath = Utility.getTestResourcesPath()+"config.properties";
        Properties prop = Utility.readPropertiesFile(properiesFilePath);
        BatchInfo batchInfo = new BatchInfo("Hackathon Tests");
        eyes = new Eyes();
        eyes.setApiKey(prop.getProperty("eyes_api_key"));
        eyes.setBatch(batchInfo);
        eyes.setForceFullPageScreenshot(true);

    }

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", Utility.getTestResourcesPath()+"/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.get("https://demo.applitools.com/hackathonV2.html");

    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }

    @AfterClass
    public void tearDown(){
        try{
            eyes.abortIfNotClosed();
        }catch (Exception e){
            System.out.println("Eyes already closed");
        }
    }
}
