package SignUp;

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


import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

import static com.thoughtworks.selenium.SeleneseTestCase.assertNotEquals;

public class SignUpTest {
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
    public void SignUpWithDoNotFillSignUpScreen1()throws Exception
    {
        SignUpPage signup=new SignUpPage(driver);

        try
        {
            signup.click_SignUpbutton();
            signup.Sleep(5000);
            String CurrentScreen = driver.currentActivity();
            signup.Sleep(3000);
           signup.click_NextButton();
            String ActualScreen = driver.currentActivity();

            Assert.assertEquals(CurrentScreen, ActualScreen);
            System.out.print("Passed SignUp With Do Not Fill SignUp Screen1");
        }
        catch (Exception E)
        {
            System.out.print("Failed SignUp With Do Not Fill SignUp Screen1");
        }
    }


        @Test(priority = 1)
        public void SignUpWithDoNotFillFirstName()throws Exception
        {
            SignUpPage signup=new SignUpPage(driver);

            try
            {


                String CurrentScreen = driver.currentActivity();
                signup.Sleep(3000);
                signup.SignUpWithScreen1("","p","");

                String ActualScreen = driver.currentActivity();

                Assert.assertEquals(CurrentScreen, ActualScreen);
                System.out.print("Passed SignUpWithDoNotFillFirstName");
            }
            catch (Exception E)
            {
                System.out.print("Failed SignUpWithDoNotFillFirstName");
            }
        }

        @Test(priority = 2)
        public void SignUpWithDoNotFillLastName()throws Exception
        {
            SignUpPage signup=new SignUpPage(driver);

            try
            {


                String CurrentScreen = driver.currentActivity();
                signup.Sleep(3000);
                signup.SignUpWithScreen1("v","","");

                String ActualScreen = driver.currentActivity();

                Assert.assertEquals(CurrentScreen, ActualScreen);
                System.out.print("Passed SignUpWithDoNotFillLastName");
            }
            catch (Exception E)
            {
                System.out.print("Failed SignUpWithDoNotFillLastName");
            }
        }
    @Test(priority = 3)
    public void SignUpWithFillAllSignUpScreen1() throws Exception {

 SignUpPage signup = new SignUpPage(driver);
        try {

            signup.SignUpWithScreen1("v", "p", "");
            signup.Sleep(3000);

            System.out.print("Passed SignUpWithFillAllSignUpScreen1");
        } catch (Exception E) {
            System.out.print("Failed SignUpWithFillAllSignUpScreen1");
        }
    }

    @Test(priority = 4)
    public void SignUpWithDoNotFillSignUpScreen2() throws Exception {
        SignUpPage signup = new SignUpPage(driver);


            String CurretScreen = driver.currentActivity();
        System.out.print( CurretScreen+"\n");
            signup.SignUpWithScreen2("", "", "", "", "", "");
            signup.Sleep(3000);

            assertNotEquals(CurretScreen, ".view.activity.ActivationActivity");
            System.out.print("Passed SignUpWithDoNotFillSignUpScreen2");

    }
    @Test(priority = 5)
    public void SignUpWithOnlyFillUsername() throws Exception {
        SignUpPage signup = new SignUpPage(driver);


            String CurretScreen = driver.currentActivity();
        System.out.print( CurretScreen+"\n");
            signup.SignUpWithScreen2("vipn205", "", "", "", "", "");
            signup.Sleep(3000);

            assertNotEquals(CurretScreen, ".view.activity.ActivationActivity");
            System.out.print("Passed SignUpWithOnlyFillUsername");

    }
    @Test(priority = 6)
    public void SignUpWithOnlyFillPassword() throws Exception {
        SignUpPage signup = new SignUpPage(driver);


            String CurretScreen = driver.currentActivity();
        System.out.print( CurretScreen+"\n");
            signup.SignUpWithScreen2("", "123456", "", "", "", "");
            signup.Sleep(3000);

            assertNotEquals(CurretScreen, ".view.activity.ActivationActivity");
            System.out.print("Passed SignUpWithOnlyFillPassword");

    }
    @Test(priority = 7)
    public void SignUpWithOnlyFillPasswordRe() throws Exception {
        SignUpPage signup = new SignUpPage(driver);


            String CurretScreen = driver.currentActivity();
        System.out.print( CurretScreen+"\n");
            signup.SignUpWithScreen2("", "", "123456", "", "", "");
            signup.Sleep(3000);

            assertNotEquals(CurretScreen, ".view.activity.ActivationActivity");
            System.out.print("Passed SignUpWithOnlyFillPasswordRe");

    }
    @Test(priority = 8)
    public void SignUpWithOnlyFillEmail() throws Exception {
        SignUpPage signup = new SignUpPage(driver);


            String CurretScreen = driver.currentActivity();
        System.out.print( CurretScreen+"\n");
            signup.SignUpWithScreen2("", "", "", "abc124@gmail.com", "", "");
            signup.Sleep(5000);

            assertNotEquals(CurretScreen, ".view.activity.ActivationActivity");
            System.out.print("Passed SignUpWithOnlyFillEmail");

    }
    @Test(priority = 9)
    public void SignUpWithOnlyFillEmailRe() throws Exception {
        SignUpPage signup = new SignUpPage(driver);


            String CurretScreen = driver.currentActivity();
        System.out.print( CurretScreen+"\n");
            signup.SignUpWithScreen2("", "", "", "", "abc124@gmail.com", "");
            signup.Sleep(5000);

            assertNotEquals(CurretScreen, ".view.activity.ActivationActivity");
            System.out.print("Passed SignUpWithOnlyFillEmailRe");

    }
    @Test(priority = 10)
    public void SignUpWithOnlyFillPhoneNumber() throws Exception {
        SignUpPage signup = new SignUpPage(driver);


            String CurretScreen = driver.currentActivity();
        System.out.print( CurretScreen+"\n");
            signup.SignUpWithScreen2("", "", "", "", "", "0987111111");
            signup.Sleep(5000);

            assertNotEquals(CurretScreen, ".view.activity.ActivationActivity");
            System.out.print("Passed SignUpWithOnlyFillEmailRe");

    }


   @Test(priority = 11)
    public void SignUpWithDulicateUsername()throws Exception
    {
        SignUpPage signup=new SignUpPage(driver);

        try
        {

            String CurretScreen = driver.currentActivity();
            signup.Sleep(3000);
            signup.SignUpWithScreen2("vipn123","123456","123456","987111111@gmail.com","987111111@gmail.com","+84987111112");
            signup.Sleep(3000);
            String ActualScreen = driver.currentActivity();

            System.out.print(ActualScreen);
            assertNotEquals(CurretScreen, ".view.activity.ActivationActivity");
            System.out.print("Passed SignUpWithDulicateUsername");
        }
        catch (Exception E)
        {
            System.out.print("Failed SignUpWithDulicateUsername");
        }
    }



    @Test(priority = 12)
    //  Username must be more than 5 && No special character
    public void SignUpWithLimitCharaterUsername()throws Exception
    {
        SignUpPage signup=new SignUpPage(driver);

        try
        {

            String CurretScreen = driver.currentActivity();
            signup.Sleep(3000);
            signup.SignUpWithScreen2("123","123456","123456","987111111@gmail.com","987111111@gmail.com","+84987111112");
            signup.Sleep(3000);
            String ActualScreen = driver.currentActivity();

            System.out.print(ActualScreen);
            assertNotEquals(CurretScreen, ".view.activity.ActivationActivity");
            System.out.print("Passed SignUpWithLimitCharaterUsername");
        }
        catch (Exception E)
        {
            System.out.print("Failed SignUpWithLimitCharaterUsername");
        }
    }
    @Test(priority = 13)
    // Username must be more than 5 && No special character
    public void SignUpWithUserNameHasSpecialCharacter()throws Exception {
        SignUpPage signup = new SignUpPage(driver);

        try {

            String CurretScreen = driver.currentActivity();
            signup.Sleep(3000);
            signup.SignUpWithScreen2("123@456", "123456", "123456", "987111111@gmail.com", "987111111@gmail.com", "+84987111112");
            signup.Sleep(3000);
            String ActualScreen = driver.currentActivity();

            System.out.print(ActualScreen);
            assertNotEquals(CurretScreen, ".view.activity.ActivationActivity");
            System.out.print("Passed SignUpWithUserNameHasSpecialCharacter");
        } catch (Exception E) {
            System.out.print("Failed SignUpWithUserNameHasSpecialCharacter");
        }
    }
    @Test(priority = 14)
    // Username must be more than 5 && No special character
    public void SignUpWithLimitPassword()throws Exception
    {
        SignUpPage signup=new SignUpPage(driver);

        try
        {

            String CurretScreen = driver.currentActivity();
            signup.Sleep(3000);
            signup.SignUpWithScreen2(signup.randomString(6),"1234","1234","987111111@gmail.com","987111111@gmail.com","+84987111112");
            signup.Sleep(3000);
            String ActualScreen = driver.currentActivity();

            System.out.print(ActualScreen);
            assertNotEquals(CurretScreen, ".view.activity.ActivationActivity");
            System.out.print("Passed SignUpWithLimitPassword");
        }
        catch (Exception E)
        {
            System.out.print("Failed SignUpWithLimitPassword");
        }
    }




    @Test(priority = 15)

    public void SignUpWithNotMatchPassword()throws Exception
    {
        SignUpPage signup=new SignUpPage(driver);

        try
        {

            String CurretScreen = driver.currentActivity();
            signup.Sleep(3000);
            signup.SignUpWithScreen2(signup.randomString(6),"123456","1234567","987111111@gmail.com","987111111@gmail.com","+84987111112");
            signup.Sleep(3000);
            String ActualScreen = driver.currentActivity();

            System.out.print(ActualScreen);
            assertNotEquals(CurretScreen, ".view.activity.ActivationActivity");
            System.out.print("Passed SignUpWithNotMatchPassword");
        }
        catch (Exception E)
        {
            System.out.print("Failed SignUpWithNotMatchPassword");
        }
    }



    @Test(priority = 16)

    public void SignUpWithIncorrectEmail()throws Exception
    {
        SignUpPage signup=new SignUpPage(driver);

        try
        {

            String CurretScreen = driver.currentActivity();
            signup.Sleep(3000);
            signup.SignUpWithScreen2(signup.randomString(6),"123456","123456","987111111","987111111@gmail.com","+84987111112");
            signup.Sleep(3000);
            String ActualScreen = driver.currentActivity();

            System.out.print(ActualScreen+"\n");
            assertNotEquals(CurretScreen, ".view.activity.ActivationActivity");
            System.out.print("Passed SignUpWithIncorrectEmail"+"\n");
        }
        catch (Exception E)
        {
            System.out.print("Failed SignUpWithIncorrectEmail"+"\n");
        }
    }
 @Test(priority = 17)

    public void SignUpWithNotMatchEmail()throws Exception
    {
        SignUpPage signup=new SignUpPage(driver);

        try
        {

            String CurretScreen = driver.currentActivity();
            signup.Sleep(3000);
            signup.SignUpWithScreen2(signup.randomString(6),"123456","123456","9871111112@gmail.com","987111111@gmail.com","+84987111112");
            signup.Sleep(3000);
            String ActualScreen = driver.currentActivity();

            System.out.print(ActualScreen+"\n");
            assertNotEquals(CurretScreen, ".view.activity.ActivationActivity");
            System.out.print("Passed SignUpWithNotMatchEmail"+"\n");
        }
        catch (Exception E)
        {
            System.out.print("Failed SignUpWithNotMatchEmail"+"\n");
        }
    }
    @Test(priority = 18)

    public void SignUpWithIncorrectPhonenumber()throws Exception
    {
        SignUpPage signup=new SignUpPage(driver);

        try
        {

            String CurretScreen = driver.currentActivity();
            signup.Sleep(3000);
            signup.SignUpWithScreen2(signup.randomString(6),"123456","123456","987111113@gmail.com","987111113@gmail.com","+####****");
            signup.Sleep(3000);
            String ActualScreen = driver.currentActivity();

            System.out.print(ActualScreen+"\n");
            assertNotEquals(CurretScreen, ".view.activity.ActivationActivity");
            System.out.print("Passed SignUpWithIncorrectPhonenumber"+"\n");
        }
        catch (Exception E)
        {
            System.out.print("Failed SignUpWithIncorrectPhonenumber"+"\n");
        }
    }

    @Test(priority = 19)

    public void SignUpWithCorrectAllOffField()throws Exception
    {
        SignUpPage signup=new SignUpPage(driver);
        String randomEmail=signup.randomString(7)+"@gmail.com";

        try
        {

            String CurretScreen = driver.currentActivity();
            signup.Sleep(3000);
            signup.SignUpWithScreen2(signup.randomString(6),"123456","123456",randomEmail,randomEmail,"+84987111115");
            String CurrentScreen = driver.currentActivity();
            driver.findElementById("com.amely.socialapp:id/edtActivationVerification").sendKeys("123");
            driver.findElementById("com.amely.socialapp:id/btnActivationVerify").click();
            signup.Sleep(2000);

            System.out.print(CurrentScreen);
            Assert.assertEquals(CurrentScreen, ".view.activity.ActivationActivity");
            signup.Sleep(2000);
            System.out.print("Passed SignUpWithCorrectAllOffField"+"\n");
        }
        catch (Exception E)
        {
            System.out.print("Failed SignUpWithCorrectAllOffField"+"\n");
        }
    }


    @AfterTest
    public void afterTest() {
        // thoát sau khi chạy hết test case
        driver.quit();


    }
}
