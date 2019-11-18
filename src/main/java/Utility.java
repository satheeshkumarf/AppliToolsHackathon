package main.java;

import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import com.testautomationguru.ocular.Ocular;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class Utility {
    public static String getTestResourcesPath(){
        return System.getProperty("user.dir") + "/src/test/resources/";
    }

    public static void setOcculkarConfigs(){
        Ocular.config()
                .snapshotPath(Paths.get(getTestResourcesPath()+"/snap"))
                .resultPath(Paths.get(getTestResourcesPath()+"/results"))
                .globalSimilarity(90);
    }

    public static WebDriver initializeEyes(WebDriver driver, Eyes eyes, String appName, String testName){
        return eyes.open(driver, appName, testName, new RectangleSize(1400,679));
    }

    public static void captureScreenshot(Eyes eyes, String windowName){
        eyes.checkWindow(windowName);
    }

    public static Properties readPropertiesFile(String filepath) {
        Properties prop = new Properties();
        InputStream input = null;
        File configFile = new File(filepath);
        try {
            input = new FileInputStream(configFile.getAbsolutePath());
            prop.load(input);
        } catch (Exception e) {
            System.out.println("ERROR: Unable to read config file");
        }
        return prop;
    }

    public static String getValueFromPropertyFile(String key){
        String properiesFilePath = Utility.getTestResourcesPath()+"config.properties";
        Properties prop = Utility.readPropertiesFile(properiesFilePath);
        return prop.getProperty(key);
    }
}
