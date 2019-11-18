package main.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

public class LoginPage {

    @FindBy(css="img[src*='logo-big.png']")
    WebElement imgCompanyLogo;

    @FindBy(css="h4.auth-header")
    WebElement lblHearderLogin;

    @FindBy(xpath="//label[text()='Username']")
    WebElement lblUserName;

    @FindBy(id="username")
    WebElement txtUserName;

    @FindBy(css="input[id='username'][placeholder='Enter your username']")
    WebElement lblUserNamePlaceHolder;

    @FindBy(css="[class*='user-male']")
    WebElement imgUserNameIcon;

    @FindBy(xpath="//label[text()='Password']")
    WebElement lblPassword;

    @FindBy(id="password")
    WebElement txtPassword;

    @FindBy(css="input[id='password'][placeholder='Enter your password']")
    WebElement lblPasswordPlaceHolder;

    @FindBy(css="[class*='fingerprint']")
    WebElement imgPasswordIcon;

    @FindBy(id="log-in")
    WebElement btnSignIn;

    @FindBy(css="[type='checkbox']")
    WebElement chkRememberMe;

    @FindBy(xpath = "//label[text()='Remember Me']")
    WebElement lblRememberMe;

    @FindBy(css="img[src*='twitter.png']")
    WebElement imgTwitter;

    @FindBy(css="img[src*='facebook.png']")
    WebElement imgFacebook;

    @FindBy(css="img[src*='linkedin.png']")
    WebElement imgLinkedIn;

    @FindBy(css="div[role='alert'][style='display: block;']")
    WebElement lblMessage;

    WebDriver driver;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    public boolean isCompanyLogoPresent(){
        return imgCompanyLogo.isDisplayed();
    }

    public boolean isLoginHeaderPresent(){
        return lblHearderLogin.isDisplayed();
    }

    public boolean isUserNamePresent(){
        return lblUserName.isDisplayed() && txtUserName.isDisplayed();
    }

    public boolean isUserNamePlaceHolderPresent(){
        return lblUserNamePlaceHolder.isDisplayed();
    }

    public boolean isPasswordPresent(){
        return lblPassword.isDisplayed() && txtPassword.isDisplayed();
    }

    public boolean isPasswordPlaceHolderPresent(){
        return lblPasswordPlaceHolder.isDisplayed();
    }

    public boolean isPasswordIconPresent(){
        return imgPasswordIcon.isDisplayed();
    }

    public boolean isUserNameIconPresent(){
        return imgUserNameIcon.isDisplayed();
    }

    public boolean isSignInPresent(){
        return btnSignIn.isDisplayed() && btnSignIn.getText().equals("Log In");
    }

    public boolean isRememberMeLinkPresent(){
        return chkRememberMe.isDisplayed() && lblRememberMe.isDisplayed();
    }

    public boolean isLinkedInImgPresent(){
        return imgLinkedIn.isDisplayed();
    }

    public boolean isFacebookImgPresent(){
        return imgFacebook.isDisplayed();
    }

    public boolean isTwitterImgPresent(){
        return imgTwitter.isDisplayed();
    }

    public void enterUserName(String username){
        txtUserName.clear();
        txtUserName.sendKeys(username);
    }

    public void enterPassword(String password){
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void clickLogin(){
        btnSignIn.click();
    }

    public boolean getValidationMessage(String message){
        return lblMessage.getText().toString().equals(message);
    }

    public void openDynamicAdPage(){
        driver.get(driver.getCurrentUrl()+"?showAd=true");
    }
}
