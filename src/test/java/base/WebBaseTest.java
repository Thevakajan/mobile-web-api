package base;

import com.automate.driver.DriverManager;
import com.automate.driver.WebDriverSetup;
import com.automate.factories.WebDriverFactory;
import com.automate.utils.configloader.JsonUtils;
import com.automate.utils.screenrecording.ScreenRecordingService;
import org.openqa.selenium.Platform;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class WebBaseTest {

    public SoftAssert softAssert = new SoftAssert();

    @Parameters({"platformName","Platform","browser"})
    @BeforeMethod
    protected void webSetUp(String mobilePlatformName,Platform platform, String browser) throws IOException {
        WebDriverFactory.initializeWebDriver(mobilePlatformName,platform,browser);
        DriverManager.getDriver().get(JsonUtils.getValue("url"));


    }


    @AfterMethod
    protected void tearDown(ITestResult result) throws IOException {
        ScreenRecordingService.stopRecording(result.getName());
        WebDriverSetup.quitDriver();
    }
}
