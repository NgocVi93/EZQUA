package formForTest;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import java.security.SecureRandom;
import java.util.List;
import java.util.concurrent.TimeUnit;


import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;

import static com.thoughtworks.selenium.SeleneseTestCase.assertNotEquals;

/**
 * Created by sysadmin on 7/26/17.
 */
public class TestSendEmoji {
    AndroidDriver driver;


    String fileName = "app-debug.apk";
    File Ezqua = new File("src/main/resources/"+fileName);


    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app",Ezqua);



        // khai báo deviceName
        cap.setCapability("platformName", "ANDROID");
        // khai báo deviceName
        cap.setCapability("deviceName", "192.168.57.101:5555");
        cap.setCapability("AppPackage", "com.amely.socialapp");
        cap.setCapability("AppActivity", "com.amely.socialapp.view.activity.SplashScreenActivity");

        cap.setCapability("appWaitActivity", "com.amely.socialapp.view.activity.LoginActivity',com.amely.socialapp.view.activity.LoginActivity");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
    }

    @Test(priority =1)
    public void CheckCaseSendText() throws InterruptedException {


       driver.findElementById("com.amely.socialapp:id/tvRegister").click();
        driver.findElementById("com.amely.socialapp:id/edtRegFristname").clear();

        driver.findElementById("com.amely.socialapp:id/edtRegFristname").sendKeys("sdasdas");

        driver.findElementById("com.amely.socialapp:id/edtRegLastname").clear();

        driver.findElementById("com.amely.socialapp:id/edtRegLastname").sendKeys("sdasdas");





        driver.findElementById("com.amely.socialapp:id/edtRegBirthday").sendKeys("a");

        driver.findElementById("android:id/button1").click();


        driver.findElementById("com.amely.socialapp:id/ms_stepNextButton").click();

        /*driver.findElementById("").sendKeys();
        driver.findElementById("").clear();

        driver.findElementById("com.amely.socialapp:id/ms_stepNextButton").click();
        driver.findElementById("").clear();

        driver.findElementById("").click();
        driver.findElementById("").clear();*/

    }

        public void SendEmoji () throws InterruptedException {
            {


                int x = driver.findElement(MobileBy.id("com.amely.socialapp:id/emojicon_icon")).getLocation().getX();
                int y = driver.findElement(MobileBy.id("com.amely.socialapp:id/emojicon_icon")).getLocation().getY();

                MultiTouchAction multiTouch = new MultiTouchAction(driver);
                TouchAction action1 = new TouchAction(driver);
                TouchAction action2 = new TouchAction(driver);

                action1.press(x + 5, y + 5).waitAction(100).release(); //3.5sec for sure, 2 pixels inside el
                action2.press(x + 300, y + 600).waitAction(1000).release(); //3.5sec for sure, 4 pixels inside el

                multiTouch.add(action1).add(action2).perform();

            }
        }


    static final String AB = "aáâăạãảeéèếêẹẻẽẾẾÈẼẺÊẾỆiíìỉĩịIÍÌỈĨỊòóoọỏõôốồộổỗ u ú ù ụ ủ ũ U Ú Ù Ụ Ũ Ủ ư ứ ừ ự ữ Ư Ứ Ừ Ự Ử Ữ  y ý ỳ ỵ ỷ ỹ Y Ý Ỳ Ỵ Ỷ Ỹ ";
    static SecureRandom rnd = new SecureRandom();

    String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }
    @AfterTest
    public void afterTest() {
        // thoát sau khi chạy hết test case
        driver.quit();

    }
}
