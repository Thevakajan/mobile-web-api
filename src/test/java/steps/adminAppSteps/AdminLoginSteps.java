package steps.adminAppSteps;

import org.testng.Assert;
import spadesappPages.adminApp.AdminLoginPage;

import java.io.IOException;

import static spadesappPages.adminApp.AdminLoginPage.*;

public class AdminLoginSteps {

    public static void AdminAppLoginSteps() throws IOException {
        Assert.assertTrue(AdminLoginPage.isAdminLoginPageTitleDisplayed(),"That login page Title is Not display here ") ;
        Assert.assertTrue(AdminLoginPage.isEmailAddressDisplayed(),"That login page email liable Title is Not display here ") ;
        setEmailAddress("sahanperera@arimaclanka.com");
        clickLoginButton();
        Assert.assertEquals(AdminLoginPage.getUserEmailId(),"sahanperera@arimaclanka.com","Email Id is incorrect");
        AdminLoginPage.enterVerificationCode();
        Assert.assertTrue(AdminLoginPage.isTransactionPageDisplayed(),"Translation Page Title is not displaying ");
    }
}
