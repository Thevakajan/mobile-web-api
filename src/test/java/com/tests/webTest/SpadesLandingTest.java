package com.tests.webTest;

import base.WebBaseTest;
import com.automate.customAnnotations.FrameworkAnnotation;
import com.automate.enums.CategoryType;
import com.automate.reports.ExtentReportLogStatus;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import spadesappPages.customaterApp.SpadesLandingPage;

import java.io.IOException;


public class SpadesLandingTest extends WebBaseTest {

    SpadesLandingPage landingPage = new SpadesLandingPage();
     SoftAssert softAssert = new SoftAssert();

    @FrameworkAnnotation(author = "K.P Theva", category = {CategoryType.REGRESSION, CategoryType.SANITY, CategoryType.SMOKE})
    @Test(description = "Spades app Bill Landing Test")
    public void verifyLandingPage() throws IOException, InterruptedException {

        if (landingPage.isArabicDisplayed()==true){
            System.out.println("english is select as default languages");
            ExtentReportLogStatus.logInfo("english is select as default languages");

        }else {
            landingPage.clickEnglish();
            System.out.println("Arabic language Selected");
        }

        softAssert.assertTrue(landingPage.isLandingPagePageDisplayed(),"That Logo is Not display here");
        softAssert.assertEquals(landingPage.getOutletName(),"L!@#$%^&*((()&_+{}:\">?~","That outlet name is Not display here");
        landingPage.NotYourTableClick();
        softAssert.assertTrue(landingPage.notYourTableTitle(),"Not Your Table is not Display");
        landingPage.ClickNotYourTableClose();
        String table =landingPage.getTableNumber();
        softAssert.assertEquals(table,"T10","Table number is in correct");
        ExtentReportLogStatus.logInfo("outlet " + table +"displaying landing Page ");
        String payBillAmount = landingPage.getTextPayBillAmount();
        softAssert.assertEquals(payBillAmount,payBillAmount,"pay bill Amount is not displaying ");
        ExtentReportLogStatus.logInfo("outlet " + payBillAmount  + ""+ " amount is displaying landing Page ");
        softAssert.assertTrue(landingPage.applePayLogoDisplayed(),"That apple pay Logo is Not display here");
        softAssert.assertTrue(landingPage.gPayLogoDisplayed(),"That Gpay Logo is Not display here");
        softAssert.assertTrue(landingPage.visaPayLogoDisplayed(),"That VisaPay Logo is Not display here");
        softAssert.assertTrue(landingPage.masterPayLogoDisplayed(),"That Mastercard Logo is Not display here");
        softAssert.assertTrue(landingPage.tabbyPayLogoDisplayed(),"That Tabby Logo is Not display here");
        softAssert.assertTrue(landingPage.bannerPayLogoDisplayed(),"That Tabby Logo is Not display here");
        landingPage.RefreshYourBillClick();
        softAssert.assertAll();
    }

}
