package spadesappPages.customaterApp;

import com.automate.driver.DriverManager;
import com.automate.pages.screen.PageActionHelper;
import com.automate.reports.ExtentReportLogStatus;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static com.automate.pages.screen.PageActionHelper.*;

public class SpadesCheckoutPage {

    SpadesLandingPage landingPage = new SpadesLandingPage();
    public static final Logger LOG = Logger.getLogger(PageActionHelper.class);

    private static  By TitleYourBill = By.xpath("//h4");
    private static  By Staff = By.xpath("//span[@data-id='staff_title']");
    private static  By StaffName = By.xpath("//span[@data-id='staff_name']");
    private static  By TableTitle = By.xpath("//span[@data-id='table_title']");
    private static  By TableNum = By.xpath("//span[@data-id='table_num']");
    private static  By HideBillDetails = By.xpath("//div[@data-id='hide_details_collapse']");
    private static  By ShowBillDetails = By.xpath("//div[@data-id='show_details_collapse']");
    private static  By billItems = By.xpath("//*[@class='MuiTableRow-root css-1wouw3v']");
    private static  By TitleAddTip = By.xpath("//p[text()='Would you like to add a tip?']");
    private static  By TitleStaff = By.xpath("//span[text()='This will go directly to your staff']");
    private static  By tipStaffName = By.xpath("//span[@data-id='staff_name_text']");
    private static  By getWalletPayByCard = By.xpath("//p[text()='Pay by card']");
    private static  By inputWalletPayByCard = By.xpath("//input[@placeholder='1234 1234 1234 1234']");
    private static  By inputWalletPayByCardDateAndYY = By.xpath("//input[@name='exp-date']");
    private static  By inputWalletPayByCardCVC = By.xpath("//input[@placeholder='CVC']");
    private static  By btnWalletPayByCardAmount = By.xpath("//button[@data-id='pay_btn']");
    private static  By txtSplitTheBIll = By.xpath("//p[@data-id='split_bill_text']");
    private static  By btnSplitNone = By.xpath("//button[@data-id='split_bill_btn']//div[@class='css-141pk5z']");
    private static  By btnAlreadySplit = By.xpath("//*[local-name()='svg' and @data-id='split_close_btn']");

    public  boolean  isCheckoutPageDisplayed(){
        return isElementNotEnabled(TitleYourBill);
    }

    public  boolean  isStaffTitleDisplayed(){
        return isElementNotEnabled(Staff);
    }


    public  boolean  isNoneSplitDisplayed(){
        return isElementNotEnabled(btnSplitNone);
    }

    public void getStaffName() {
        listGetText(StaffName,"its Staff Name is Displayed : ");

    }
     public void getTable() {
         listGetText(TableNum,"its Table Number is Displayed : ");

    }

    public boolean  isHideDetailsDisplayed(){
        return isElementNotEnabled(HideBillDetails);
    }

    public void clickShowBillDetails() throws IOException {
        waitAndClick(ShowBillDetails,"Show Bill Details Collapse");
    }
    public void clickHideBillDetails() throws IOException {
        waitAndClick(HideBillDetails,"Hide Bill Details Collapse");
    }


    public void itemsDetailsShow() throws IOException {

        if (isHideDetailsDisplayed()==true){

            System.out.println("Already show Bill Details");
            ExtentReportLogStatus.logInfo("Already show Bill Details");

        }else {
            clickHideBillDetails();
            System.out.println("Click on Show Bill Details ");
        }

    }

    public void getItemsDetails() throws IOException {

        listGetText(billItems,"Checkout Page Bill Items : ");

    }

    public String tipHeader(){

        return listGetText(TitleAddTip,"Displaying Tip Header ");
    }

    public String tipStaffTitle(){

        return listGetText(TitleStaff,"Displaying Tip Staff Header : ");
    }

    public String tipStaffName(){

        return getTextValue(tipStaffName);
    }

    public String getTextWalletPayByCard(){

        return getTextValue(getWalletPayByCard);
    }

    public void clickWalletPayCard() throws IOException {
        waitAndClick(getWalletPayByCard,"Wallet pay by card");
    }

    public String getSplitBill(){

        return getTextValue(txtSplitTheBIll);
    }

    public void clickSplitNone() throws IOException {
        waitAndClick(btnSplitNone,"Split the bill payment");
    }

    public void clickAlreadySplit() throws IOException {
        waitAndClick(btnAlreadySplit," Already Split");
    }

    public static void setPayByCardNumber(String cardNumber) throws IOException {
        DriverManager.getDriver().switchTo().frame(0);
        enterValue(inputWalletPayByCard,cardNumber,"Entered Pay By Card Number");
        DriverManager.getDriver().switchTo().defaultContent();
    }

    public static void setPayByCardDate(String Date) throws IOException {
        DriverManager.getDriver().switchTo().frame(1);
        enterValue(inputWalletPayByCardDateAndYY,Date,"Entered Pay By Card Date & Years");
        DriverManager.getDriver().switchTo().defaultContent();
    }

    public static void setPayByCardCVC(String CVC) throws IOException {
        DriverManager.getDriver().switchTo().frame(2);
        enterValue(inputWalletPayByCardCVC,CVC,"Entered Pay By Card CVC");
        DriverManager.getDriver().switchTo().defaultContent();
    }

    public void clickWalletPayCardAmount() throws IOException {
        waitAndClick(btnWalletPayByCardAmount,"Wallet pay by card Amount");
    }

    public void languagesSelectors() throws IOException {
        if (landingPage.isArabicDisplayed()==true){
            System.out.println("english is select as default languages");
            ExtentReportLogStatus.logInfo("english is select as default languages");

        }else {
            landingPage.clickEnglish();
            System.out.println("Arabic language Selected");
        }
    }

    public void splitTheBill() throws IOException {
        if (isNoneSplitDisplayed()==true){
            clickSplitNone();
            System.out.println("Split Bill Payment Clicked ");
        }else
        {
            System.out.println("Already someone made Split Payment ");
            ExtentReportLogStatus.logInfo("Already someone made Split Payment ");
        }
    }

}
