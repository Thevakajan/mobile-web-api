package spadesappPages.customaterApp;

import com.automate.pages.screen.PageActionHelper;
import com.automate.reports.ExtentReportLogStatus;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import java.text.DecimalFormat;

import static com.automate.pages.screen.PageActionHelper.*;

public class TipCalculations {

    public static final Logger LOG = Logger.getLogger(TipCalculations.class);

    static PageActionHelper pageActionHelper = new PageActionHelper();


    private static  DecimalFormat df = new DecimalFormat("0.00");
    private static  By yourBillTotal = By.xpath("//p[@data-id='your_bill_amount']");
    private static  By getFirstTip = By.xpath("//*[@data-id='first_tip_per']");
    private static  By getSecondTip = By.xpath("//*[@data-id='second_tip_per']");
    private static  By getThirdTip = By.xpath("//*[@data-id='third_tip_per']");
    private static  By FirstTipInput = By.xpath("//p[@data-id='first_tip_value']");
    private static  By SecondTipInput = By.xpath("//p[@data-id='second_tip_value']");
    private static  By ThirdTipInput = By.xpath("//p[@data-id='third_tip_value']");
    private static  By yourPaymentTotal = By.xpath("//span[@data-id='your_payment_amount']");
    private static  By getCustomTip = By.xpath("//span[@data-id='custom_btn']");
    private static  By getCustomTipHeader = By.xpath("//*[@data-id='presentation_text']");
    private static  By sendCustomTipAEDAmount = By.xpath("//*[@data-id='amount_input_pop']");
    private static  By getCustomTipYourBillAmount = By.xpath("//*[@class='css-1g586m2']//*[@data-id='amount_value_pop']");
    private static  By btnCustomTipConformation = By.xpath("//button[text()='Confirm']");
    private static   By getCustomTipAmount = By.xpath("//p[@data-id='custom_value']");
    private static  By getYourBillAmount = By.xpath("//span[@data-id='your_payment_amount']");
    private static  By getIncludesTip = By.xpath("//span[@data-id='include_tips']");
    private static  By getWalletPayByCardAmount = By.xpath("//button[@data-id='pay_btn']");
    private static  By check = By.xpath("//span[@class='MuiTypography-root MuiTypography-body3 css-4uhw7x']");

    double bill;
    double billAmount;
    String tipValue;
    double calTip;
    double YourPayment;

    public double tipCalculation(double totalValue,int Percentage) {
        double tipValue = (totalValue / 100) * Percentage;
        DecimalFormat dft = new DecimalFormat("0.00");
        if (dft.format(tipValue).length()==3){
            tipValue = Double.parseDouble(df.format(tipValue)+"0");
        }else {
            tipValue= Double.parseDouble(dft.format(tipValue));
        }
        return tipValue;
    }

    public String getFirstTip(){

        return newlistGetText(getFirstTip);
    }

    public String getSecondTip(){

        return newlistGetText(getSecondTip);
    }

    public String getThirdTip(){

        return newlistGetText(getThirdTip);
    }

    public String getCustomTip(){

        return newlistGetText(getCustomTipAmount);
    }

    public String getCustomTipHeader(){

        return newlistGetText(getCustomTipHeader);
    }

    public String getFirstInputTip(){
        return  newlistGetText(FirstTipInput);
    }

    public String getSecondInputTip(){
        return  newlistGetText(SecondTipInput);
    }

    public String getThirdInputTip(){
        return  newlistGetText(ThirdTipInput);
    }

    public static void clickFirstTip() throws IOException {
      PageActionHelper.waitAndClick(getFirstTip,"First tip");
    }

    public static void clickSecondTip() throws IOException {
        PageActionHelper.waitAndClick(getSecondTip,"Second tip Amount");
    }

    public static void clickThirdTip() throws IOException {
        PageActionHelper.waitAndClick(getThirdTip,"Third tip Amount");
    }

    public static void clickCustom() throws IOException {
        PageActionHelper.waitAndClick(getCustomTip,"Custom tip Amount");
    }

    public static String yourBillAmount(){
         pageActionHelper.scrollInToElement(yourPaymentTotal);
         String[] parts = PageActionHelper.getTextValue(yourBillTotal).split(" ");

         return parts[1];
    }

    public static String setCustomTipAmount(String CustomTipAmount) throws IOException {
        enterValue(sendCustomTipAEDAmount,CustomTipAmount,"Entered Custom AED Amount");
        return CustomTipAmount;
    }


    public static double getYourTotalBillAmount(){
        double billValue = Double.parseDouble(yourBillAmount());
        ExtentReportLogStatus.logInfo(" Your Bill Amount :  <b>"  + billValue + " </b>");
        return billValue;
    }

    public String getCustomBillAmount(){

        return newlistGetText(getCustomTipYourBillAmount);
    }


    public String getIncludesTipAmount(){

        return newlistGetText(getIncludesTip);
    }

    public static void clickCustomTip() throws IOException {
        PageActionHelper.waitAndClick(btnCustomTipConformation,"Custom Tip Conformation");
    }

    public String getCustomTipInput(){

        return newlistGetText(sendCustomTipAEDAmount);
    }

    public String getYourPayment(){

        return newlistGetText(getYourBillAmount);
    }

    public String getTextWalletPayByCardAmount(){

        return getTextValue(getWalletPayByCardAmount);
    }


    public void customerFirstTipCal() throws IOException {
        SoftAssert softAssert = new SoftAssert();
        clickFirstTip();
        bill = Double.parseDouble(yourBillAmount().replaceAll("AED", "").trim());
        billAmount = Double.valueOf(df.format(bill));
        int percentageValue = Integer.parseInt(getFirstTip().replaceAll("%", ""));
        double tip = (billAmount*percentageValue)/100;
        double tipAmount = (double) Math.round(tip * 100) / 100;
        calTip = Double.parseDouble(getFirstInputTip());
        softAssert.assertEquals(df.format(tipAmount),df.format(calTip),"The Calculated Tip Percentage is InCorrect");
        ExtentReportLogStatus.logInfo("Displaying Tip Percentage value : <b>"+percentageValue+ "% </b>");
        ExtentReportLogStatus.logInfo("Displaying Tip Amount is : <b>"+tipAmount+ "</b>");
        ExtentReportLogStatus.logInfo("Displaying Calculated Tip amount is : <b>"+calTip+ "</b>");
        YourPayment = Double.valueOf(yourBillAmount().replaceAll("AED", ""))+Double.valueOf(calTip);
        softAssert.assertEquals(YourPayment,getYourPayment(),"doesn't much Your payment");
        ExtentReportLogStatus.logInfo("Displaying Your payment Bill value : <b>"+YourPayment+ " </b>");

    }


    public void customerSecondTipCal() throws IOException {
        SoftAssert softAssert = new SoftAssert();
        clickSecondTip();
        bill = Double.parseDouble(yourBillAmount().replaceAll("AED", "").trim());
        billAmount = Double.valueOf(df.format(bill));
        int percentageValue = Integer.parseInt(getSecondTip().replaceAll("%", ""));
        double tip = (billAmount*percentageValue)/100;
        double tipAmount = (double) Math.round(tip * 100) / 100;
        calTip = Double.parseDouble(getSecondInputTip());
        softAssert.assertEquals(df.format(tipAmount),df.format(calTip),"The Calculated Tip Percentage is InCorrect");
        ExtentReportLogStatus.logInfo("Displaying Tip Percentage value : <b>"+percentageValue+ "% </b>");
        ExtentReportLogStatus.logInfo("Displaying Tip Amount is : <b>"+tipAmount+ "</b>");
        ExtentReportLogStatus.logInfo("Displaying Calculated Tip amount is : <b>"+calTip+ "</b>");
        YourPayment = Double.valueOf(yourBillAmount().replaceAll("AED", ""))+Double.valueOf(calTip);
        softAssert.assertEquals(YourPayment,getYourPayment(),"doesn't much Your payment");
        ExtentReportLogStatus.logInfo("Displaying Your payment Bill value : <b>"+YourPayment+ " </b>");

    }

    public void customerThirdTipCal() throws IOException {
        SoftAssert softAssert = new SoftAssert();
        clickThirdTip();
        Double bill = Double.parseDouble(yourBillAmount().replaceAll("AED", "").trim());
        Double billAmount = Double.valueOf(df.format(bill));
        int percentageValue = Integer.parseInt(getThirdTip().replaceAll("%", ""));
        double tip = (billAmount*percentageValue)/100;
        double tipAmount = (double) Math.round(tip * 100) / 100;
        calTip = Double.parseDouble(getThirdInputTip());
        softAssert.assertEquals(df.format(tipAmount),df.format(calTip),"The Calculated Tip Percentage is InCorrect");
        ExtentReportLogStatus.logInfo("Displaying Tip Percentage value : <b>"+percentageValue+ "% </b>");
        ExtentReportLogStatus.logInfo("Displaying Tip Amount is : <b>"+tipAmount+ "</b>");
        ExtentReportLogStatus.logInfo("Displaying Calculated Tip amount is : <b>"+calTip+ "</b>");
        YourPayment = Double.valueOf(yourBillAmount().replaceAll("AED", ""))+Double.valueOf(calTip);
        softAssert.assertEquals(YourPayment,getYourPayment(),"doesn't much Your payment");
        ExtentReportLogStatus.logInfo("Displaying Your payment Bill value : <b>"+YourPayment+ " </b>");
    }

    public void customerCustomTipCal() throws IOException {
        SoftAssert softAssert = new SoftAssert();
        clickCustom();
        softAssert.assertEquals(getCustomTipHeader(),"How much would you like to tip?"," Custom Tip Header is not displaying ");
        ExtentReportLogStatus.logInfo("Displaying Custom Tip Header is : <b>"+getCustomTipHeader()+ "</b>");
        tipValue =setCustomTipAmount("10");
        ExtentReportLogStatus.logInfo("Displaying Custom Tip : <b>"+tipValue+".00"+" </b>");
        softAssert.assertEquals(getCustomBillAmount(),yourBillAmount(),"doesn't much Your Bill amount");
        ExtentReportLogStatus.logInfo("Displaying Custom Bill value : <b>"+getCustomBillAmount()+ " </b>");
        clickCustomTip();
        double customTip = Double.parseDouble(getCustomTip());
        softAssert.assertEquals(customTip,tipValue+".00","doesn't much Your Custom Bill amount");


    }

    public void yourBillAmounts(){
        SoftAssert softAssert = new SoftAssert();
        YourPayment  = Double.valueOf(yourBillAmount().replaceAll("AED", ""))+Double.valueOf(tipValue);
        ExtentReportLogStatus.logInfo("Displaying Your payment Bill value : <b>"+YourPayment+ " </b>");
        softAssert.assertEquals(YourPayment,getYourPayment(),"doesn't much Your payment");
        softAssert.assertEquals(getIncludesTipAmount(),tipValue,"doesn't much Tip Value");
        ExtentReportLogStatus.logInfo("Displaying Includes value : <b>"+getIncludesTipAmount()+ " Tips </b>");
    }

    public void PayByCardAmounts(){
        SoftAssert softAssert = new SoftAssert();
        YourPayment  = Double.valueOf(yourBillAmount().replaceAll("AED", ""))+Double.valueOf(tipValue);
        softAssert.assertEquals(YourPayment,getTextWalletPayByCardAmount(),"doesn't much Your payment");
        ExtentReportLogStatus.logInfo("Displaying Pay By AED : <b>"+getTextWalletPayByCardAmount()+ "</b>");

    }


}
