package Event;

/**
 * Created by sysadmin on 11/9/17.
 */
import Login.LoginPage;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

public class EventTest {
    AndroidDriver driver;
    EventPage eventPage;
    LoginPage loginPage;
    @BeforeTest
    public void beforeTest() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();

        String fileName = "app-debug.apk";
        File Ezqua = new File("src/main/resources/" + fileName);
        cap.setCapability("app", Ezqua);


        // khai báo deviceName
        cap.setCapability("platformName", "ANDROID");
        // khai báo deviceName
        cap.setCapability("deviceName", "192.168.57.101:5555");
        cap.setCapability("AppPakage", "com.amely.socialapp");
        cap.setCapability("AppActivity", "com.amely.socialapp.view.activity.SplashScreenActivity");

        cap.setCapability("appWaitActivity", "com.amely.socialapp.view.activity.LoginActivity',com.amely.socialapp.view.activity.LoginActivity");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);

    }

    @Test(priority = 0)
    public void Login() throws Exception
    {
        loginPage = new LoginPage(driver);


        loginPage.Login("vipn123", "vipn123");
        Thread.sleep(3000);

    }
    @Test(priority = 1)

    public void CreateEvent() throws Exception
    {
        eventPage=new EventPage(driver);

        eventPage.ClickTabEvent();
        eventPage.ClickEventAdd();


    }

    @AfterTest
    public void afterTest() {
        // thoát sau khi chạy hết test case
        driver.quit();


    }




}
