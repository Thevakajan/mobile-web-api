package com.tests.webTest.adminAppTest;

import base.WebBaseTest;
import com.automate.customAnnotations.FrameworkAnnotation;
import com.automate.driver.DriverManager;
import com.automate.enums.CategoryType;
import com.automate.utils.configloader.JsonUtils;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static steps.adminAppSteps.AdminLoginSteps.AdminAppLoginSteps;


public class AdminLoginTest extends WebBaseTest {

    @FrameworkAnnotation(author = "K.P Theva", category = {CategoryType.REGRESSION, CategoryType.SANITY, CategoryType.SMOKE})
    @Test(description = "Spades admin app Login Test")
    public void verifyAdminLoginPage() throws IOException {
        softAssert = new SoftAssert();
        DriverManager.getDriver().get(JsonUtils.getValue("admin_url"));
        AdminAppLoginSteps();
        softAssert.assertAll();
    }
}
