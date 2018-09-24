package ProfilePage;

import Login.ElementMenu;
import Login.LoginPage;
import SignUp.SignUpPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by sysadmin on 10/18/17.
 */
public class MessageTest {
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
        cap.setCapability("AppPakage", "ezqua.dfm.com.prototype");
        cap.setCapability("AppActivity", "ezqua.dfm.com.prototype.view.activity.SplashScreenActivity");

        cap.setCapability("appWaitActivity", "ezqua.dfm.com.prototype.view.activity.LoginActivity',ezqua.dfm.com.prototype.view.activity.LoginActivity");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
    }

    @Test(priority = 0)
    public void GetTitle()throws Exception
    {
        LoginPage login=new LoginPage(driver);
        Profile profile =new Profile(driver);
        ElementMenu menu=new ElementMenu(driver);
        login.Login("vipn123","vipn123");
        login.Sleep(3000);

        login.click_BtnDrawer();
        menu.click_btnPersonal();


        Assert.assertEquals(profile.getTxtMainTitleActionbar(),"Cá nhân");
    }
    @Test(priority = 1)
    public void ChatWithSendText()throws Exception
    {
            LoginPage login=new LoginPage(driver);
            Profile profile =new Profile(driver);
        SignUpPage signup=new SignUpPage(driver);

        login.Sleep(3000);
        driver.findElementByXPath("//android.widget.ImageView[@bounds='[707,592][787,696]']").click();
        login.Sleep(3000);
        String randomstring=signup.randomString(30);
        profile.Chat_SendOnlyText(randomstring);
        //driver.findElementByXPath("//android.widget.ImageView[@text='eZQUA admin')").click();
        login.Sleep(3000);
       scrollDown();


        List<MobileElement> listMessage = driver.findElementsById("ezqua.dfm.com.prototype:id/txtChatMess");

        for (int i = 0; i < listMessage.size(); i++) {
            String s = listMessage.get(i).getText();
            Assert.assertEquals(randomstring,listMessage.get(13).getText());
/*
            if (s.equals(randomstring)) {
                System.out.println("Passed " + " tai vi tri " + i + "\n");
            } else
                System.out.println("Failed " + " vi tri " + i + "\n");*/

        }

        login.Sleep(3000);
    }
    public void scrollDown() throws Exception {
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.7);
        int endy = (int) (size.height * 0.2);
        int startx = size.height / 2;
        driver.swipe(startx, starty, startx, endy, 800);

    }



    @Test(priority = 2)
    public void ChatWithSendEmoji()throws Exception
    {

        Profile profile =new Profile(driver);
profile.clickbtnEmoji();
        profile.Chat_SendOnlyEmoji();

    }
@Test(priority = 3)
    public void Chat()throws Exception
    {
SignUpPage signup=new SignUpPage(driver);
        Profile profile =new Profile(driver);
        for(int i=0;i<50;i++)
        {
            profile.Chat_SendOnlyText(signup.randomString(30));
        }
    }

    @AfterTest
    public void afterTest() {
        // thoát sau khi chạy hết test case
        driver.quit();

    }

}
