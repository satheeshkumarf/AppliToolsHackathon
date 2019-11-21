package main.java;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.selenium.Eyes;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.Properties;

public class TestBaseEyes {

    public WebDriver browser;
    public Eyes eyes;
    private static BatchInfo batch;

    @BeforeClass
    public static void setBatch(){
        batch = new BatchInfo("Hackathon");
    }

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", Utility.getTestResourcesPath()+"/chromedriver");
        String properiesFilePath = Utility.getTestResourcesPath()+"config.properties";
        Properties prop = Utility.readPropertiesFile(properiesFilePath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        browser = new ChromeDriver(options);

        eyes = new Eyes();
        eyes.setApiKey(prop.getProperty("eyes_api_key"));
        eyes.setBatch(batch);
        eyes.setForceFullPageScreenshot(true);
    }

    @AfterTest
    public void closeDriver(){
        browser.quit();
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
