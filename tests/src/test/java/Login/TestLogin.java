package Login;

/**
 * Created by sysadmin on 10/9/17.
 */
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import static com.thoughtworks.selenium.SeleneseTestCase.assertNotEquals;

import static com.thoughtworks.selenium.SeleneseTestCase.assertEquals;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

    public class TestLogin {
    AndroidDriver driver;

    String fileName = "app-debug.apk";
    File Ezqua = new File("src/main/resources/" + fileName);


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

   @Test(priority = 0)
public void LoginWithAccountNull()throws Exception
    {

        LoginPage login=new LoginPage(driver);
       String CurrentScreen=driver.currentActivity();

        login.Login("","");

        String ActualScreen=driver.currentActivity();
        login.Sleep(3000);
        Assert.assertEquals(CurrentScreen,ActualScreen);

    }

   /* @Test(priority = 1)
    public void LoginWithOnlyFillAccount()throws Exception
    {
                LoginPage login=new LoginPage(driver);
        try
        {
            String CurrentScreen = driver.currentActivity();
            login.Sleep(5000);
            login.Login("vipn123", "");
            login.Sleep(3000);

            String ActualScreen = driver.currentActivity();
            login.Sleep(3000);
            Assert.assertEquals(CurrentScreen, ActualScreen);
            System.out.print("Passed LoginWithOnlyFillAccount");
        }
        catch (Exception E)
            {
                System.out.print("Failed LoginWithOnlyFillAccount");
            }

    }

    @Test(priority = 2)
    public void LoginWithOnlyFillPassword()throws Exception
    {
                LoginPage login=new LoginPage(driver);
        try
        {
            String CurrentScreen = driver.currentActivity();
            login.Sleep(5000);
            login.Login("", "vipn123");
            login.Sleep(3000);

            String ActualScreen = driver.currentActivity();
            login.Sleep(3000);
            Assert.assertEquals(CurrentScreen, ActualScreen);
            System.out.print("Passed LoginWithOnlyFillPassword");
        }
        catch (Exception E)
            {
                System.out.print("Failed LoginWithOnlyFillPassword");
            }

    }

    @Test(priority = 3)
    public void LoginWithIncorrectPassword()throws Exception
    {
        LoginPage login=new LoginPage(driver);
        try
        {
            String CurrentScreen = driver.currentActivity();
            login.Sleep(5000);
            login.Login("vipn123", "123456");
            login.Sleep(3000);

            String ActualScreen = driver.currentActivity();
            login.Sleep(3000);
            Assert.assertEquals(CurrentScreen, ActualScreen);
            System.out.print("Passed LoginWithIncorrectPassword");
        }
        catch (Exception E)
        {
            System.out.print("Failed LoginWithIncorrectPassword");
        }

    }
    @Test(priority = 4)
    public void LoginWithCorrectAccountAndPassword()throws Exception
    {
        LoginPage login=new LoginPage(driver);
        try
        {
            String CurrentScreen = driver.currentActivity();
            login.Sleep(5000);
            login.Login("vipn123", "vipn123");
            login.Sleep(3000);

            String ActualScreen = driver.currentActivity();
            login.Sleep(3000);

            assertNotEquals(CurrentScreen,ActualScreen);
            System.out.print("Passed LoginWithCorrectAccountAndPassword");
        }
        catch (Exception E)
        {
            System.out.print("Failed LoginWithCorrectAccountAndPassword");
        }

    }
    @Test(priority = 5)

    public void LoginWithEmail()throws Exception
    {
        LoginPage login=new LoginPage(driver);
        try
        {
            // Nếu chạy để test 1 function này thì comment login.Logout
            login.Logout();
            String CurrentScreen = driver.currentActivity();
            login.Sleep(5000);
            login.Login("chiphandsome0104@gmail.com", "vipn123");
            login.Sleep(3000);

            String ActualScreen = driver.currentActivity();
            login.Sleep(3000);
            assertNotEquals(CurrentScreen,ActualScreen);
            System.out.print("Passed LoginWithEmail");
        }
        catch (Exception E)
        {
            System.out.print("Failed LoginWithEmail");
        }

    }

    @Test(priority = 6)

    public void LoginWithPhoneNumner()throws Exception
    {
        LoginPage login=new LoginPage(driver);
        try
        {
            // Nếu chạy để test 1 function này thì comment login.Logout
            login.Logout();
            String CurrentScreen = driver.currentActivity();
            login.Sleep(5000);
            login.Login("0987456123", "vipn123");
            login.Sleep(3000);

            String ActualScreen = driver.currentActivity(); 
            login.Sleep(3000);
            assertNotEquals(CurrentScreen,ActualScreen);
            System.out.print("Passed LoginWithPhoneNumner");
        }
        catch (Exception E)
        {
            System.out.print("Failed LoginWithPhoneNumner");
        }

    }
*/




    @AfterTest
    public void afterTest() {
        // thoát sau khi chạy hết test case
        driver.quit();

    }
}
