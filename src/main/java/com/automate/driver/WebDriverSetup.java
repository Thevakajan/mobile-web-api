package com.automate.driver;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.TimeUnit;



public final class WebDriverSetup {

    public static final String URL = "https://lincymario_56USId:pgrHxdiCb2ZQ5yM79MCa@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createWebDriver(String browser){
        try {
            if(browser.equalsIgnoreCase("Chrome")) {
                WebDriverManager.chromedriver().setup();
                DriverManager.setAndWebDriver(new ChromeDriver());
                System.out.println("Browser: Chrome");
                System.out.println("Chrome Browser setup by Thread "+Thread.currentThread().getId());

            }else {
                WebDriverManager.safaridriver().setup();
                DriverManager.setAndWebDriver(new SafariDriver());
                System.out.println("Browser: Safari");
                System.out.println("Safari Browser setup by Thread "+Thread.currentThread().getId());
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
        DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverManager.getDriver().manage().window().maximize();
        return DriverManager.getDriver();
    }

    public static WebDriver setupBrowser(Platform platform, String browser) throws MalformedURLException {


        DesiredCapabilities capability = new DesiredCapabilities ();
        capability.setCapability ("platform", platform);
        capability.setCapability ("network", true);//to enable network logs
        capability.setCapability ("visual", true);//to enable screenshots
        capability.setCapability ("video", true);//to enable video
        capability.setCapability ("console", true);//to enable console logs
        capability.setCapability ("build", "Cross Browser Tests");

        if (browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            capability.setCapability("browser", "Chrome");
        } else if (browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            capability.setCapability("browser", "Firefox");
        }

            DriverManager.setAndWebDriver((new RemoteWebDriver(new URL(URL), capability)));

        return  DriverManager.getDriver();
    }





    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
