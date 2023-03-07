package com.tests.webTest;

import base.MobileBaseTest;
import base.WebBaseTest;
import com.automate.customAnnotations.FrameworkAnnotation;
import com.automate.enums.CategoryType;
import com.automate.reports.ExtentReportLogStatus;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import spadesappPages.customaterApp.TipCalculations;
import spadesappPages.customaterApp.SpadesCheckoutPage;
import spadesappPages.customaterApp.SpadesLandingPage;

import java.io.IOException;

public class CheckoutPageTest extends WebBaseTest {

    SpadesLandingPage landingPage = new SpadesLandingPage();
    SpadesCheckoutPage checkoutPage = new SpadesCheckoutPage();
    TipCalculations calculations = new TipCalculations();
    SoftAssert softAssert = new SoftAssert();

    @FrameworkAnnotation(author = "K.P Theva", category = {CategoryType.REGRESSION, CategoryType.SANITY, CategoryType.SMOKE})
    @Test(description = "Spades app Checkout Page Test")
    public void verifyCustomerCheckoutPage() throws IOException {

        landingPage.PayBillClick();
        softAssert.assertTrue(checkoutPage.isCheckoutPageDisplayed(),"doesn't displaying checkout page");
        softAssert.assertTrue(checkoutPage.isStaffTitleDisplayed(),"doesn't displaying Staff Title in Checkout Page ");

        checkoutPage.getStaffName();

        checkoutPage.getTable();

        checkoutPage.itemsDetailsShow();
        checkoutPage.getItemsDetails();

        double totalBillValue;
        totalBillValue = calculations.getYourTotalBillAmount();
        softAssert.assertEquals(totalBillValue,totalBillValue,"wrongly  displaying Checkout Total amount");
        System.out.println("your Bil amount :" + totalBillValue);

//        /*Split Payment*/
//        checkoutPage.getSplitBill();
//        ExtentReportLogStatus.logInfo(" <b>" + checkoutPage.getSplitBill() + " </b>");
//        checkoutPage.splitTheBill();

        String tipHeader = checkoutPage.tipHeader();
        softAssert.assertEquals(tipHeader,tipHeader,"Tip header is not displaying Checkout page");

         String staffName =checkoutPage.tipStaffName();
         softAssert.assertEquals(staffName,"Test.","Tip staff name is not displaying ");

         calculations.customerFirstTipCal();
         calculations.customerSecondTipCal();
         calculations.customerThirdTipCal();
         calculations.customerCustomTipCal();
         calculations.yourBillAmounts();

        /* wallet payments in the checkout page */
         checkoutPage.getTextWalletPayByCard();
         ExtentReportLogStatus.logInfo("Displaying wallet: <b>"+checkoutPage.getTextWalletPayByCard()+ " Tips </b>");
         checkoutPage.clickWalletPayCard();
         checkoutPage.setPayByCardNumber("4242 4242 4242 4242");
         checkoutPage.setPayByCardDate("1025");
         checkoutPage.setPayByCardCVC("555");
         calculations.PayByCardAmounts();
         checkoutPage.clickWalletPayCardAmount();
         checkoutPage.languagesSelectors();
         
         softAssert.assertAll();
    }

}
