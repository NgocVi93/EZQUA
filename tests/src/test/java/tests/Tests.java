package tests;

/**
 * Created by sysadmin on 10/9/17.
 */
import Login.LoginPage;
import PageFactory.AllElement;
import PageFactory.ExchangesGift;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

import static com.thoughtworks.selenium.SeleneseTestCase.assertNotEquals;

public class Tests {
    AndroidDriver driver;

    String fileName = "app-debug.apk";
    File Amely = new File("src/main/resources/" + fileName);


    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", Amely);


        // khai báo deviceName
        cap.setCapability("platformName", "ANDROID");
        // khai báo deviceName
        cap.setCapability("deviceName", "192.168.57.101:5555");
        cap.setCapability("AppPackage", "com.amely.socialapp");
        cap.setCapability("AppActivity", "com.amely.socialapp.view.activity.SplashScreenActivity");

        cap.setCapability("appWaitActivity", "com.amely.socialapp.view.activity.LoginActivity',com.amely.socialapp.view.activity.LoginActivity");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
    }


    @Test(priority = 0)
    public void CreateOfffer() throws Exception {
        ExchangesGift   exchanges = new ExchangesGift(driver);
        LoginPage login =new LoginPage(driver);
        AllElement allelement=new AllElement(driver);
        login.Login("vipham","Amely123");
        Thread.sleep(10000);
        for( int i=0;i<4;i++) {
            allelement.Click_BtnPermisionAllow();
        }
        Thread.sleep(5000);
      exchanges.ClicktabExchangeGift();
      exchanges.ClickbuttonCreateOfffer();
      exchanges.ClickTypeOfOffer();
      exchanges.ChooseNormalType();

      Thread.sleep(1000);

    }
}