package test.java;

import main.java.TestBaseTraditional;
import main.java.Utility;
import main.pages.DashboardPage;
import main.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.data.LoginData;

import java.util.Arrays;

import static java.util.Arrays.sort;

public class TraditionalTests extends TestBaseTraditional {

    @Test
    public void testLoginPageUIElements(){
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isCompanyLogoPresent());
        Assert.assertTrue(loginPage.isLoginHeaderPresent());
        Assert.assertTrue(loginPage.isUserNamePresent());
        Assert.assertTrue(loginPage.isUserNameIconPresent());
        Assert.assertTrue(loginPage.isUserNamePlaceHolderPresent());
        Assert.assertTrue(loginPage.isPasswordPresent());
        Assert.assertTrue(loginPage.isPasswordPlaceHolderPresent());
        Assert.assertTrue(loginPage.isPasswordIconPresent());
        Assert.assertTrue(loginPage.isSignInPresent());
        Assert.assertTrue(loginPage.isRememberMeLinkPresent());
        Assert.assertTrue(loginPage.isLinkedInImgPresent());
        Assert.assertTrue(loginPage.isFacebookImgPresent());
        Assert.assertTrue(loginPage.isTwitterImgPresent());

    }

    @Test(dataProvider="loginDataNegativeTests", dataProviderClass = LoginData.class)
    public void testLoginValidationTraditinal(String userName, String password, String validationMessage, String testName){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.getValidationMessage(validationMessage));
    }


    @Test
    public void testTableSorting(){
        LoginPage login = new LoginPage(driver);
        login.enterUserName("satheesh");
        login.enterPassword("qa_rockstar");
        login.clickLogin();
        DashboardPage dashboard = new DashboardPage(driver);
        double[] beforeSorting = dashboard.getAmountValues();
        dashboard.clickAmountRow();
        double[] sortedAmountFromUI = dashboard.getAmountValues();
        Arrays.sort(beforeSorting);
        Assert.assertEquals(sortedAmountFromUI, beforeSorting);
    }


    @Test
    public void testCanvasChart(){
        LoginPage login = new LoginPage(driver);
        login.enterUserName("satheesh");
        login.enterPassword("qa_rockstar");
        login.clickLogin();
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickCompareExpenses();
        Utility.setOcculkarConfigs();
        Assert.assertTrue(dashboard.compareChart("chart_2017_18.png"));
        dashboard.clickShowDataNextYear();
        Assert.assertTrue(dashboard.compareChart("chart_2019.png"));
    }

    @Test
    public void testDynamicContentTest(){
        LoginPage login = new LoginPage(driver);
        login.openDynamicAdPage();
        login.enterUserName("satheesh");
        login.enterPassword("qa_rockstar");
        login.clickLogin();
        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertTrue(dashboard.flashSaleImage1Exist());
        Assert.assertTrue(dashboard.flashSaleImage2Exist());
    }
}
