package test.data;

import org.testng.annotations.DataProvider;

public class LoginData {

    @DataProvider(name="loginDataNegativeTests")
    public Object[][] loginDataNegativeTests(){
        return new Object[][]{
                {"","","Both Username and Password must be present", "Login Test Both username and password are empty"},
                {"satheesh","","Password must be present","Login Test Password is empty"},
                {"","mypassword","Username must be present","Login Test Username is empty"}
        };
    }
}
