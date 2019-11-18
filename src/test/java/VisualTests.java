package test.java;

import main.java.TestBaseEyes;
import main.java.Utility;
import main.pages.DashboardPage;
import main.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test.data.LoginData;

public class VisualTests extends TestBaseEyes {

    @Test
    public void testLoginPageUIElements(){
        WebDriver driver = Utility.initializeEyes(browser,eyes,"Hackathon Test 1","Login UI Test");
        driver.get(Utility.getValueFromPropertyFile("app_url"));
        Utility.captureScreenshot(eyes,"Login Page");
        eyes.close();
    }

    @Test(dataProvider="loginDataNegativeTests", dataProviderClass = LoginData.class)
    public void testLoginValidation(String userName, String password, String validationMessage, String testName){
        WebDriver driver = Utility.initializeEyes(browser,eyes,"Hackathon Test2",testName);
        driver.get(Utility.getValueFromPropertyFile("app_url"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        Utility.captureScreenshot(eyes, testName);
        eyes.close();
    }


    @Test
    public void testTableSorting(){
        WebDriver driver = Utility.initializeEyes(browser,eyes,"Hackathon Test 3","Table Sorting");
        driver.get(Utility.getValueFromPropertyFile("app_url"));
        LoginPage login = new LoginPage(driver);
        login.enterUserName("satheesh");
        login.enterPassword("qa_rockstar");
        login.clickLogin();
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickAmountRow();
        Utility.captureScreenshot(eyes, "Table Sorting");
        eyes.close();
    }


    @Test
    public void testCanvasChart(){
        WebDriver driver = Utility.initializeEyes(browser,eyes,"Hackathon Test 4","Chart Test");
        driver.get(Utility.getValueFromPropertyFile("app_url"));
        LoginPage login = new LoginPage(driver);
        login.enterUserName("satheesh");
        login.enterPassword("qa_rockstar");
        login.clickLogin();
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickCompareExpenses();
        Utility.captureScreenshot(eyes, "Chart Test 2017_2018");
        dashboard.clickShowDataNextYear();
        Utility.captureScreenshot(eyes, "Chart Test 2019");
        eyes.close();
    }

    @Test
    public void testDynamicContentTest(){
        WebDriver driver = Utility.initializeEyes(browser,eyes,"Hackathon Test 5","Dynamic Image Test");
        driver.get(Utility.getValueFromPropertyFile("app_url"));
        LoginPage login = new LoginPage(driver);
        login.openDynamicAdPage();
        login.enterUserName("satheesh");
        login.enterPassword("qa_rockstar");
        login.clickLogin();
        DashboardPage dashboard = new DashboardPage(driver);
        Utility.captureScreenshot(eyes, "Dynamic Image");
        eyes.close();
    }
}
