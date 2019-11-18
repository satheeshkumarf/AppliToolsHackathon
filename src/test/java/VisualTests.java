package test.java;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.selenium.Eyes;
import main.java.TestBase;
import main.java.Utility;
import main.pages.DashboardPage;
import main.pages.LoginPage;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import test.data.LoginData;

public class VisualTests extends TestBase {

    @Test
    public void testLoginPageUIElements(){
        Utility.takeScreenShotUsingEyes(driver,eyes,"Hackathon Test 1","Login UI Test");
    }

    @Test(dataProvider="loginDataNegativeTests", dataProviderClass = LoginData.class)
    public void testLoginValidation(String userName, String password, String validationMessage, String testName){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        Utility.takeScreenShotUsingEyes(driver,eyes,"Hackathon Test 2",testName);
    }


    @Test
    public void testTableSorting(){
        LoginPage login = new LoginPage(driver);
        login.enterUserName("satheesh");
        login.enterPassword("qa_rockstar");
        login.clickLogin();
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickAmountRow();
        Utility.takeScreenShotUsingEyes(driver,eyes,"Hackathon Test 3","Table Sorting");
    }


    @Test
    public void testCanvasChart(){
        LoginPage login = new LoginPage(driver);
        login.enterUserName("satheesh");
        login.enterPassword("qa_rockstar");
        login.clickLogin();
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickCompareExpenses();
        Utility.takeScreenShotUsingEyes(driver,eyes,"Hackathon Test 4","Chart 2017_2018");
        dashboard.clickShowDataNextYear();
        Utility.takeScreenShotUsingEyes(driver,eyes,"Hackathon Test 4","Chart 2019");
    }

    @Test
    public void testDynamicContentTest(){
        LoginPage login = new LoginPage(driver);
        login.openDynamicAdPage();
        login.enterUserName("satheesh");
        login.enterPassword("qa_rockstar");
        login.clickLogin();
        DashboardPage dashboard = new DashboardPage(driver);
        Utility.takeScreenShotUsingEyes(driver,eyes,"Hackathon Test 5","Dynamic Test");
    }
}
