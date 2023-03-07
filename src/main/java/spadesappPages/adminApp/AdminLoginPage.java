package spadesappPages.adminApp;

import org.openqa.selenium.By;

import java.io.IOException;

import static com.automate.pages.screen.PageActionHelper.*;


public class AdminLoginPage {
    private static final By adminLoginPageTitleDisplay = By.xpath("//div[@class='styles_cardTitle__2jYRE']");
    private static final By emailAddress_labelDisplay = By.xpath("//div[@class='styles_email__1x4q_']");
    private static final By inputEmail = By.xpath("//input[@class='styles_emailInput__1kC6h']");
    private static final By loginButton = By.className("styles_buttonContainer__3fGV0");
    private static final By getEmailId = By.className("otp_emailHighlight__ZxdKw");
    private static final By verificationCodeInput1 = By.xpath("//input[contains(@aria-label, 'Digit 1')]");
    private static final By verificationCodeInput2 = By.xpath("//input[contains(@aria-label, 'Digit 2')]");
    private static final By verificationCodeInput3 = By.xpath("//input[contains(@aria-label, 'Digit 3')]");
    private static final By verificationCodeInput4 = By.xpath("//input[contains(@aria-label, 'Digit 4')]");
    private static final By transactionPage = By.xpath("//span[text()='Transaction']");


    public static boolean  isAdminLoginPageTitleDisplayed(){
        return isElementNotEnabled(adminLoginPageTitleDisplay);

    }
    public static boolean  isEmailAddressDisplayed(){
        return isElementNotEnabled(emailAddress_labelDisplay);
    }

    public static void setEmailAddress(String emailId) throws IOException {
        enterValue(inputEmail,emailId,"Entered Admin App Login Email Id");
    }

    public static void clickLoginButton() throws IOException {
        waitAndClick(loginButton,"Admin app Landing Page Login button Click");
    }

    public static String getUserEmailId() throws IOException {
       return getTextValue(getEmailId);
    }

    private static void setVerificationCodeInput1(String value) throws IOException {
        enterValue(verificationCodeInput1,value," Admin App Login Email VerificationCode 0");
    }
    private static void setVerificationCodeInput2(String value) throws IOException {
        enterValue(verificationCodeInput2,value," Admin App Login Email VerificationCode 0");
    }
    private static void setVerificationCodeInput3(String value) throws IOException {
        enterValue(verificationCodeInput3,value," Admin App Login Email VerificationCode 0" );
    }
    private static void setVerificationCodeInput4(String value) throws IOException {
        enterValue(verificationCodeInput4,value," Admin App Login Email VerificationCode 0" );
    }

    public static void enterVerificationCode() throws IOException {
        setVerificationCodeInput1("0");
        setVerificationCodeInput2("0");
        setVerificationCodeInput3("0");
        setVerificationCodeInput4("0");
    }

    public static boolean  isTransactionPageDisplayed(){
        return isElementNotEnabled(transactionPage);
    }
}
