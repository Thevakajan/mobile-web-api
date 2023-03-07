package com.automate.pages.screen;



import com.automate.driver.DriverManager;
import com.automate.enums.WaitStrategy;
import com.automate.factories.WaitFactory;
import com.automate.reports.ExtentReportLogStatus;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;



public class PageActionHelper {

    static WaitFactory waitFactory = new WaitFactory();
    public static final Logger LOG = Logger.getLogger(PageActionHelper.class);

    public static boolean isElementNotEnabled(By by) {
        try{

            waitFactory.waiTillVisible( by,20);

            return DriverManager.getDriver().findElement(by).isDisplayed();
        }
        catch (NoSuchElementException e){
            return true;
        }
    }

    public static void waitAndClick(By by,String elementName) throws IOException {

        try {
            //wait strategy
            WaitFactory.explicitlyWaitForElementLocatedBy(WaitStrategy.CLICKABLE, by);
            DriverManager.getDriver().findElement(by).click();
            LOG.info("Clicked on " + elementName);
            ExtentReportLogStatus.logInfo("Clicked on " + elementName);
        } catch (Exception e) {
            ExtentReportLogStatus.logFail("Exception occurred when clicking on - " + elementName, e);
        }
    }

    public static void enterValue(By by,String value,String elementName) throws IOException {

        try {
            //wait strategy
            WaitFactory.explicitlyWaitForElementLocatedBy(WaitStrategy.VISIBLE, by);
            DriverManager.getDriver().findElement(by).sendKeys(value);
            LOG.info("Entered value - <b>" + value + "</b> in the field " + elementName);
            ExtentReportLogStatus.logInfo("Entered value - <b>" + value + "</b> in the field " + elementName);
        } catch (Exception e) {
            ExtentReportLogStatus.logFail("Exception occurred when clicking on - " + elementName, e);
        }
    }



    public static String getText(By by,String elementName) {
        WaitFactory.explicitlyWaitForElementLocatedBy(WaitStrategy.VISIBLE, by);
         ExtentReportLogStatus.logInfo(" <b>" + elementName + " ");
        return DriverManager.getDriver().findElement(by).getText();
    }

    public static String getTextValue(By by) {
        WaitFactory.explicitlyWaitForElementLocatedBy(WaitStrategy.VISIBLE, by);
        return DriverManager.getDriver().findElement(by).getText();
    }

    public static String[] getTextValueAmout(By by) {
        return WaitFactory.explicitlyWaitForElementLocatedBy(WaitStrategy.VISIBLE, by).getText().split(" ",4);


    }

//    public static String NewlistGetText(By by,String elementName){
//        List<WebElement> listElement = DriverManager.getDriver().findElements(by);
//        for(int i =0;i<listElement.size();i++) {
//            String elementText = listElement.get(i).getText();
//            ExtentReportLogStatus.logInfo(" <b>" + elementName + ""+ elementText+ "</b>  ");
//        }
//
//        return elementName;
//    }

    public String getTitleOfThePage() {
        return DriverManager.getDriver().getTitle();
    }


  public static String listGetText(By by,String elementName){
      List<WebElement> listElement = DriverManager.getDriver().findElements(by);
      for(int i =0;i<listElement.size();i++) {
          String elementText = listElement.get(i).getText();
          ExtentReportLogStatus.logInfo(" <b>" + elementName + ""+ elementText+ "</b>  ");
      }
      return elementName;
  }


        public static String newlistGetText(By by) {
            WaitFactory.explicitlyWaitForElementLocatedBy(WaitStrategy.VISIBLE, by);
            return DriverManager.getDriver().findElement(by).getText();
        }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollInToElement(By by){
        WebElement element = DriverManager.getDriver().findElement(by);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
