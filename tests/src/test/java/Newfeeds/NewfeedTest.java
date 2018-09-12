package Newfeeds;

/**
 * Created by sysadmin on 10/20/17.
 */

import Login.LoginPage;
import SignUp.SignUpPage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class NewfeedTest {
    AndroidDriver driver;

    String fileName = "app-debug.apk";
    File Ezqua = new File("src/main/resources/" + fileName);




    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", Ezqua);


        // khai báo deviceName
        cap.setCapability("platformName", "ANDROID");
        // khai báo deviceName
        cap.setCapability("deviceName", "192.168.57.101:5555");

        // Samsung galaxy J7 Prime
       // cap.setCapability("deviceName", "3300a7537024b357");

        cap.setCapability("AppPackage", "com.amely.socialapp");
        cap.setCapability("AppActivity", "com.amely.socialapp.view.activity.SplashScreenActivity");

        cap.setCapability("appWaitActivity", "com.amely.socialapp.view.activity.LoginActivity',com.amely.socialapp.view.activity.LoginActivity");


        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
    }

    @Test(priority = 0)
    public void Login() throws Exception {
        LoginPage login = new LoginPage(driver);


        login.Login("vipn113", "123456");
        Thread.sleep(5000);
    }
   // @Test(invocationCount = 5)  thi se chay 5 lan cai ham LikeStatus
 //  @Test(invocationCount = 4)

 /*  @Test(priority = 1)

    public void AllowPermision() throws Exception
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        NewfeedHome newfeedHome=new NewfeedHome(driver);
        newfeedHome.permission_allow_button();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.packageinstaller:id/permission_allow_button")));
        newfeedHome.permission_allow_button();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.packageinstaller:id/permission_allow_button")));
        newfeedHome.permission_allow_button();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.packageinstaller:id/permission_allow_button")));
        newfeedHome.permission_allow_button();
        Thread.sleep(3000);

    }
*/


   @Test(priority = 2)
    public void LikeStatus()throws Exception
    {
        NewfeedHome newfeedHome=new NewfeedHome(driver);

      //  int beforeLike=newfeedHome.CountLike();
      //  beforeLike=beforeLike+1;
        try
        {
            newfeedHome.clickbtnRowNewFeedLike();
        }
        catch (Exception e)
        {
            System.out.print("Failed");
        }
     //   int afterLike=newfeedHome.CountLike();


       // Assert.assertEquals(beforeLike,afterLike);
        Thread.sleep(2000);
    }
    @Test(priority = 3)
    public void Comment() throws Exception
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        NewfeedHome newfeedHome=new NewfeedHome(driver);
        SignUpPage signUpPage=new SignUpPage(driver);

        String comment=signUpPage.randomString(20);

        newfeedHome.clickbtnRowNewFeedComment();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.amely.socialapp:id/edtFeedComment")));
            newfeedHome.SendComment(comment);
            newfeedHome.clickbtnComment();

        Thread.sleep(2000);
        scrollDown();
        Thread.sleep(2000);
        scrollDown();
        Thread.sleep(2000);
        scrollDown();
         List<MobileElement> listMessage = driver.findElementsById("com.amely.socialapp:id/txtCommentContent");

         int a=listMessage.size();

         for (int i = a-1; i >=a; i--) {

             String afterComment = listMessage.get(1).getText();

             Assert.assertEquals(comment, afterComment);

         }
         driver.navigate().back();
     }
    @Test(priority = 4)
   // @Test(invocationCount = 3)
    public void CreateNewfeedsWithPrivacyFriend() throws Exception
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        NewfeedHome newfeedHome=new NewfeedHome(driver);

        newfeedHome.clickbtnNewFeedFloatButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.amely.socialapp:id/edtContent")));
        newfeedHome.CreateNewFeedWithPrivacyFriend("Post newfeed with privacy: Friend");
        Thread.sleep(5000);
}

 @Test(priority = 5)
    public void CreateNewfeedsWithPrivacyOnlyMe() throws Exception
    {


        NewfeedHome newfeedHome=new NewfeedHome(driver);
        Thread.sleep(2000);
        newfeedHome.clickbtnNewFeedFloatButton();
        Thread.sleep(2000);
        newfeedHome.CreateNewFeedWithPrivacyOnlyMe("Post newfeed with privacy: OnlyMe");
        Thread.sleep(5000);

    }
 @Test(priority = 6)
    public void CreateNewfeedsWithPrivacyPublic() throws Exception
    {


        NewfeedHome newfeedHome=new NewfeedHome(driver);
        Thread.sleep(2000);
        newfeedHome.clickbtnNewFeedFloatButton();
        Thread.sleep(2000);
        newfeedHome.CreateNewFeedWithPrivacyPublic("Post newfeed with privacy: Public");

    }



    public void scrollDown() throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        int starty =  (int) (size.height * 0.7);
        int endy =  (int) (size.height * 0.2);
        int startx = size.height / 2;
        driver.swipe(startx, starty, startx, endy, 500);

    }



    @AfterTest
    public void afterTest() {
        // thoát sau khi chạy hết test case
        driver.quit();


    }
}


