package Ezqua;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


import static com.thoughtworks.selenium.SeleneseTestCase.assertNotEquals;
import static org.testng.Assert.assertEquals;

/**
 * Created by sysadmin on 7/31/17.
 */
public class Message {
    AndroidDriver driver;


    String fileName = "app-debug.apk";
    File Ezqua = new File("src/main/resources/" + fileName);
    @BeforeTest
    public void beforeTest() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        //Máy ảo
        //   cap.setCapability("appActivity", "ezqua.dfm.com.view.prototype.activity.LoginActivity");
        //    cap.setCapability("appWaitActivity", "ezqua.dfm.com.view.prototype.activity.LoginActivity', ezqua.dfm.com.view.prototype.activity.LoginActivity");

        cap.setCapability("app", Ezqua);
        /*// Máy Vĩ

       //   cap.setCapability("appActivity", "ezqua.dfm.com.view.prototype.activity.LoginActivity");
          cap.setCapability("appWaitActivity", "ezqua.dfm.com.view.prototype.activity.LoginActivity',ezqua.dfm.com.view.prototype.activity.LoginActivity");
        // khai báo platform
              cap.setCapability(CapabilityType.VERSION, "5.0.0");
       //  khai báo deviceName
             cap.setCapability("deviceName", "192.168.56.101:5555");
*/

        //Máy SamSung

        // khai báo deviceName
        cap.setCapability("platformName", "ANDROID");
        // khai báo deviceName
        cap.setCapability("deviceName", "Real Device");
        cap.setCapability("AppPakage", "ezqua.dfm.com.prototype");
        // cap.setCapability("AppActivity", "ezqua.dfm.com.prototype.view.activity.SplashScreenActivity");

        cap.setCapability("appWaitActivity", "ezqua.dfm.com.prototype.view.activity.LoginActivity',ezqua.dfm.com.prototype.view.activity.LoginActivity");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
    }

    @Test(priority = 1)
    //  case này mình test trường hợp đăng nhập với account đúng
    public void SignIn() throws InterruptedException {
       // Sleep(2000);
        String currentScreen = driver.currentActivity();


        // Nhập user name

        driver.findElementById("ezqua.dfm.com.prototype:id/txtUsername").clear();
        driver.findElementById("ezqua.dfm.com.prototype:id/txtUsername").sendKeys("vipn123");

        // Nhập mật khẩu
        driver.findElementById("ezqua.dfm.com.prototype:id/txtPassword").clear();
        driver.findElementById("ezqua.dfm.com.prototype:id/txtPassword").sendKeys("vipn123");

        // Nhấn nút sign in
        driver.findElementById("ezqua.dfm.com.prototype:id/btnLogin").click();


        Sleep(5000);
        String screenSignIn = driver.currentActivity();
        assertNotEquals(currentScreen, screenSignIn);
        WebDriverWait wait = new WebDriverWait(driver, 30);



        System.out.print("Pass test case 3. Nhập đúng SignIn \n");

        //Click allow access photo, media and f
        driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();

        //Allow access take pictures
        driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();


    }

    @Test(priority =2)
    public void CheckCaseSendText() throws InterruptedException {

        driver.findElementById("ezqua.dfm.com.prototype:id/btnDrawer").click();
        Sleep(2000);
        driver.findElementById("ezqua.dfm.com.prototype:id/main_btnPersonal").click();


        try {


            Sleep(2000);
            driver.findElementById("ezqua.dfm.com.prototype:id/btnRowContactChat").click();
            driver.findElementById("ezqua.dfm.com.prototype:id/edtChat").sendKeys("hello");
            Sleep(3000);

            driver.findElementById("ezqua.dfm.com.prototype:id/btnSend").click();

            //   driver. navigate().back();

            List<MobileElement> listMessage = driver.findElementsById("ezqua.dfm.com.prototype:id/txtChatMess");

            for (int i = 0; i < listMessage.size(); i++) {
                String s = listMessage.get(i).getText();
                String expected = "hello";



                if (s.equals(expected)) {
                    System.out.println("Passed " + " tai vi tri " + i + "\n");
                } else
                    System.out.println("Failed " + " vi tri " + i + "\n");

            }
        }
        catch (Exception E)
        {
            System.out.println("Failed Case Send Text");
        }

    }

    @Test(priority =3)
    public void CheckCaseSendEmoji() throws InterruptedException
    {


        Sleep(3000);


        try {
            driver.findElementById("ezqua.dfm.com.prototype:id/btnEmoji").click();

            Sleep(3000);
            int x = driver.findElement(MobileBy.id("ezqua.dfm.com.prototype:id/emojicon_icon")).getLocation().getX();
            int y = driver.findElement(MobileBy.id("ezqua.dfm.com.prototype:id/emojicon_icon")).getLocation().getY();

            MultiTouchAction multiTouch = new MultiTouchAction(driver);
            TouchAction action1 = new TouchAction(driver);
            TouchAction action2 = new TouchAction(driver);

            action1.press(x + 5, y + 5).waitAction(100).release(); //3.5sec for sure, 2 pixels inside el
            action2.press(x + 300, y + 600).waitAction(1000).release(); //3.5sec for sure, 4 pixels inside el

            multiTouch.add(action1).add(action2).perform();

            Sleep(3000);

            driver.findElementById("ezqua.dfm.com.prototype:id/btnSend").click();

            System.out.println("Passed Check Case Send Emoji"+"\n");
        }
        catch (Exception a)
        {
            System.out.println("Failed Check Case Send Emoji"+"\n");
        }

    }



    @Test(priority =4)
    public void CheckCaseSendTextAndemoji() throws InterruptedException
    {

    try
{
    driver.findElementById("ezqua.dfm.com.prototype:id/edtChat").sendKeys("Send Text & Emoji");
    Sleep(2000);
    driver.findElementById("ezqua.dfm.com.prototype:id/btnEmoji").click();
    driver.findElementById("ezqua.dfm.com.prototype:id/btnEmoji").click();

    int x = driver.findElement(MobileBy.id("ezqua.dfm.com.prototype:id/emojicon_icon")).getLocation().getX();
    int y = driver.findElement(MobileBy.id("ezqua.dfm.com.prototype:id/emojicon_icon")).getLocation().getY();

    MultiTouchAction multiTouch = new MultiTouchAction(driver);
    TouchAction action1 = new TouchAction(driver);
    TouchAction action2 = new TouchAction(driver);
    action1.press(x + 5, y + 5).waitAction(100).release(); //3.5sec for sure, 2 pixels inside el
    action2.press(x + 300, y + 600).waitAction(1000).release(); //3.5sec for sure, 4 pixels inside el

    multiTouch.add(action1).add(action2).perform();
    Sleep(4000);

    driver.findElementById("ezqua.dfm.com.prototype:id/btnSend").click();
    System.out.print("Passed case Check Case Send Text And emoji"+"\n");
}
    catch ( Exception e)
    {
        System.out.print("Failed case Check Case Send Text And emoji"+"\n");
    }

    }
    //Send image
    @Test(priority = 5)
    public void CheckCaseSendImage() throws InterruptedException
    {
        driver.findElementById("ezqua.dfm.com.prototype:id/btnChatImg").click();
        int x = driver.findElement(MobileBy.id("ezqua.dfm.com.prototype:id/btnChatImg")).getLocation().getX();
        int y = driver.findElement(MobileBy.id("ezqua.dfm.com.prototype:id/btnChatImg")).getLocation().getY();

        MultiTouchAction multiTouch = new MultiTouchAction(driver);
        TouchAction action1 = new TouchAction(driver);
        TouchAction action2 = new TouchAction(driver);
        action1.press(x + 5, y + 5).release(); //3.5sec for sure, 2 pixels inside el
        action2.press(x + 300, y + 600).release(); //3.5sec for sure, 4 pixels inside el

        multiTouch.add(action1).add(action2).perform();
        Sleep(4000);


    }

    @Test(priority = 6)
    public void CheckSenGif() throws InterruptedException
    {
        driver.findElementById("ezqua.dfm.com.prototype:id/btnChatGift").click();
        String title =driver.findElementById("ezqua.dfm.com.prototype:id/txtChatGiftTitleActionbar").getText();
        String expectedTitle="Title";
        if(title.equals(expectedTitle))
        {
            System.out.println("Passed "+"\n");
        }
        else
            System.out.println("Failed "+"\n");
    }

    //Kiểm tra title của trang Shopping
    @Test(priority=7)
    public void  CompareTitleShopping()throws InterruptedException{
        driver. navigate().back();
        driver. navigate().back();

        driver.findElementById("ezqua.dfm.com.prototype:id/btnDrawer").click();
        driver.findElementById("ezqua.dfm.com.prototype:id/main_btnEcom").click();
        String title =driver.findElementById("ezqua.dfm.com.prototype:id/txtMainTitleActionbar").getText();
        String expectedTitle="Mua sắm";
        if(title.equals(expectedTitle))
        {
            System.out.println("Passed with title: " +title+ "\n");
        }
        else
            System.out.println("Failed "+"\n");

    }



    //Mỗi lần scroll sẽ chọn 1 sản phẩm
    @Test(priority=8)
    public void AddVoucherToTitleCart()throws InterruptedException{
        try {
            driver.findElementById("ezqua.dfm.com.prototype:id/tab_voucher").click();

            scrollDown();
            Sleep(2000);
            scrollDown();
            Sleep(2000);

            driver.findElementById("ezqua.dfm.com.prototype:id/imgRowVoucher").click();
            driver.findElementById("ezqua.dfm.com.prototype:id/btnVoucherAddCart").click();

            scrollDown();
            scrollDown();

            driver.findElementById("ezqua.dfm.com.prototype:id/imgRowVoucher").click();
            driver.findElementById("ezqua.dfm.com.prototype:id/btnVoucherAddCart").click();


            System.out.print("Passed case Add Voucher to title Cart");
        }
        catch (Exception e)
        {
            System.out.print("Failed case Add Voucher to title Cart");
        }

    }
    //Thêm vào giỏ hàng 2 sp, Kiểm tra thông báo show 2 sp là ok
    @Test(priority = 9)
    public void CheckTitleCart() throws  InterruptedException
    {
        Sleep(2000);


        String number= driver.findElementById("ezqua.dfm.com.prototype:id/txtMainCartBadge").getText();

        assertEquals(number,"2","Passed");

    }
    @Test(priority = 10)
    public void CompareNumberAfterbuyVoucher() throws InterruptedException {
        String currentScreen = driver.currentActivity();


        driver.findElementById("ezqua.dfm.com.prototype:id/btnMainTitleCart").click();


        List<MobileElement> ListRowprice = driver.findElementsById("ezqua.dfm.com.prototype:id/txtRowPrice");

        for (int i = 0; i < ListRowprice.size(); i++) {
            //  String s = ListFrameLayout.get(i).getText();
            String s = ListRowprice.get(i).getText();
            s = s.substring(0, s.length() - 2).toString();
            System.out.println(ListRowprice.size());

        }

    }
    @Test(priority = 11)
    public void DeleteProductInCart() throws InterruptedException
    {
        try
        {
            driver.findElementById("ezqua.dfm.com.prototype:id/btnRowCartDelete").click();

            System.out.print("Failed case Delete Product In Cart");
        }
        catch (Exception e)
        {
            System.out.print("Failed case Delete Product In Cart");
        }


    }

    @Test(priority = 12)
    public void CompareNumberAfterDeleteVoucher() throws InterruptedException
    {
        String currentScreen = driver.currentActivity();

        List<MobileElement> ListRowprice = driver.findElementsById("ezqua.dfm.com.prototype:id/txtRowPrice");

        for (int i = 0; i < ListRowprice.size(); i++)
        {
            //  String s = ListFrameLayout.get(i).getText();
            String s = ListRowprice.get(i).getText();
            s = s.substring(0, s.length() - 2).toString();
            System.out.println(ListRowprice.size());
        }
        assertEquals(ListRowprice.size(),1,"Passed");

    }

    public void scrollDown() throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.7);
        int endy = (int) (size.height * 0.2);
        int startx = size.height / 2;
        driver.swipe(startx, starty, startx, endy, 800);

    }
    static public int Sleep( int time)throws InterruptedException
    {
        Thread.sleep(time);
        return time;
    }

    @AfterTest
    public void afterTest() {
        // thoát sau khi chạy hết test case
        driver.quit();

    }
}
