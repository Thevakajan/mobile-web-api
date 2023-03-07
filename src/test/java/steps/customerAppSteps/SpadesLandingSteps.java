package steps.customerAppSteps;

import org.testng.Assert;
import spadesappPages.customaterApp.SpadesLandingPage;


import java.io.IOException;


public class SpadesLandingSteps   {

    static SpadesLandingPage landingPage = new SpadesLandingPage();

    public static void CustomerLandingSteps() throws IOException {
        Assert.assertTrue(landingPage.isLandingPagePageDisplayed(),"That Logo is Not display here ") ;
        Assert.assertTrue(landingPage.isViewMenuDisplayed(),"That Menu is Not display here");
        Assert.assertTrue(landingPage.isOutletNameDisplayed(),"That outlet name is Not display here");
        Assert.assertTrue(landingPage.isTableNumDisplayed(),"That Table is Not display here");

        landingPage.RefreshYourBillClick();
        landingPage.NotYourTableClick();
       // ViewMenuClick();
    }

}
