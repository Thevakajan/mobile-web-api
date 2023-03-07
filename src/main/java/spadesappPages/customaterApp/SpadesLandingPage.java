package spadesappPages.customaterApp;



import com.automate.enums.WaitStrategy;
import com.automate.factories.WaitFactory;
import com.automate.pages.screen.PageActionHelper;
import com.automate.reports.ExtentReportLogStatus;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.automate.pages.screen.PageActionHelper.*;


public class SpadesLandingPage {
    public static final Logger LOG = Logger.getLogger(PageActionHelper.class);

    private static  By english = By.xpath("//span[text()='English']");
    private static  By arabic = By.xpath("//span[text()='العربية']");
    private static  By LOGO_Display = By.xpath("//img[@data-id='logo']");
    private static  By View_MenuClick = By.xpath("//*[@data-id='viewmenu_btn']");
    private static  By outletName = By.xpath("//*[@data-id='outlet_name_btn']");
    private static  By tableCoun = By.xpath("//span[@data-id='table_num']");
    private static  By table = By.xpath("//span[@data-id='table']");
    private static  By not_your_table = By.xpath("//*[@data-id='not_your_table_btn']");
    private static  By payBillAmount = By.xpath("//button[@type='button']");
    private static  By applePayLogo = By.xpath("//img[@alt='apple-pay']");
    private static  By gPayLogo = By.xpath("//img[@alt='gpay']");
    private static  By visaPayLogo = By.xpath("//img[@alt='visa']");
    private static  By masterPayLogo = By.xpath("//img[@alt='master-card']");
    private static  By tabbyPayLogo = By.xpath("//img[@alt='tabby']");
    private static  By banner = By.xpath("//img[@alt='Clickable banner']");
    private static  By notYourTableTitle = By.xpath("//h4");
    private static  By notYourTablePopClose = By.xpath("//button[@data-id='close_btn']");
    private static  By refreshButton = By.xpath("//div[@data-id='refresh_bill']");




    public  boolean  isLandingPagePageDisplayed(){
        return isElementNotEnabled(LOGO_Display);

    }
    public  boolean  isOutletNameDisplayed(){
        return isElementNotEnabled(outletName);

    }

    public  boolean  notYourTableTitle(){
        return isElementNotEnabled(notYourTableTitle);

    }
    public  boolean  isViewMenuDisplayed(){
        return isElementNotEnabled(View_MenuClick);

    }
    public  boolean  isTableNumDisplayed(){
        return isElementNotEnabled(table);

    }
    public  boolean  isEnglishDisplayed(){
        return isElementNotEnabled(arabic);

    }
    public  boolean  isArabicDisplayed(){
        return isElementNotEnabled(arabic);

    }

    public  void clickEnglish() throws IOException {
        waitAndClick(english,"Landing Page English Button Click ");
    }

     public  void ViewMenuClick() throws IOException {
         waitAndClick(View_MenuClick,"Landing Page View Menu Click ");
     }
     public  void ClickNotYourTableClose() throws IOException {

         waitAndClick(notYourTablePopClose,"Not Your table popup Page close Click ");

     }

    public  void RefreshYourBillClick() throws IOException {
        waitAndClick(refreshButton,"Refresh Your Bill Click ");

    }


    public  String getTableNumber()  {
        WaitFactory.explicitlyWaitForElementLocatedBy(WaitStrategy.VISIBLE,refreshButton);
        return getText(tableCoun,"its Table number is Displayed");
    }

    public  String getOutletName() throws IOException {
        return getTextValue(outletName);
    }

    public  void NotYourTableClick() throws IOException {

        waitAndClick(not_your_table,"Not your table ");
    }

    public  String[] getPayBillAmount() throws IOException {
        return getTextValueAmout(payBillAmount);
    }

    public  String getTextPayBillAmount()  {
        WaitFactory.explicitlyWaitForElementLocatedBy(WaitStrategy.VISIBLE,refreshButton);
        return getText(payBillAmount,"its Table number is Displayed");
    }

    public  boolean  applePayLogoDisplayed(){
        return isElementNotEnabled(applePayLogo);

    }

    public  boolean  gPayLogoDisplayed(){
        return isElementNotEnabled(gPayLogo);

    }

    public  boolean  visaPayLogoDisplayed(){
        return isElementNotEnabled(visaPayLogo);

    }

    public  boolean  masterPayLogoDisplayed(){
        return isElementNotEnabled(masterPayLogo);

    }

    public  boolean  tabbyPayLogoDisplayed(){
        return isElementNotEnabled(tabbyPayLogo);

    }

    public  boolean  bannerPayLogoDisplayed(){
        return isElementNotEnabled(banner);

    }

    public  boolean  isPayBillADisplayed(){
        return isElementNotEnabled(payBillAmount);

    }

    public  void PayBillClick() {
        try{
            WaitFactory.explicitlyWaitForElementLocatedBy(WaitStrategy.VISIBLE,refreshButton);
            waitAndClick(payBillAmount,"Pay Bill  ");
        }catch (Exception e){
            System.out.println(e);

        }

    }
}
