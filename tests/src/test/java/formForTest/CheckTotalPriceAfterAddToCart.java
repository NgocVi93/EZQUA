// Kiểm tra tổng tiền sau khi Thêm Vào Giỏ Hàng
package formForTest;
import static junit.framework.Assert.failNotSame;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import com.sun.jna.platform.win32.OaIdl;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;


import org.openqa.selenium.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.management.monitor.Monitor;
import javax.xml.bind.Element;
import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CheckTotalPriceAfterAddToCart {

    AndroidDriver driver;



    String fileName = "app-debug.apk";
    File Ezqua = new File("src/main/resources/" + fileName);


    @BeforeTest
    public void beforeTest() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        //Máy ảo
        //   cap.setCapability("appActivity", "com.amely.socialapp.activity.LoginActivity");
        //    cap.setCapability("appWaitActivity", "com.amely.socialapp.activity.LoginActivity', com.amely.socialapp.activity.LoginActivity");

        cap.setCapability("app", Ezqua);
        // khai báo platform
        //      cap.setCapability(CapabilityType.VERSION, "5.0.0");
        // khai báo deviceName
        //     cap.setCapability("deviceName", "192.168.56.101:5555");


        //Máy thật dùng

        // khai báo deviceName
        cap.setCapability("platformName", "ANDROID");
        // khai báo deviceName
        cap.setCapability("deviceName", "Real Device");
        cap.setCapability("AppPakage", "com.amely.socialapp");
        // cap.setCapability("AppActivity", "com.amely.socialapp.view.activity.SplashScreenActivity");

        cap.setCapability("appWaitActivity", "com.amely.socialapp.view.activity.LoginActivity',com.amely.socialapp.view.activity.LoginActivity");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);

            }


    public void scrollDown() {
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.7);
        int endy = (int) (size.height * 0.2);
        int startx = size.height / 2;
        driver.swipe(startx, starty, startx, endy, 800);
    }

    @Test(priority =1)
    public void DemoScroll () throws InterruptedException {

        //Nhập user name
        driver.findElementById("com.amely.socialapp:id/txtUsername").sendKeys("vipham");

        // Nhập mật khẩu
        driver.findElementById("com.amely.socialapp:id/txtPassword").sendKeys("");

        // Nhấn nút sign in
        driver.findElementById("com.amely.socialapp:id/btnLogin").click();

        //Click allow access photo, media and f
      driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();

        //Allow access take pictures
       driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();

        driver.findElementById("com.amely.socialapp:id/btnDrawer").click();


        driver.findElementById("com.amely.socialapp:id/main_btnEcom").click();

        driver.findElementById("com.amely.socialapp:id/tab_voucher").click();



        driver.findElementById("com.amely.socialapp:id/imgRowVoucher").click();
        driver.findElementById("com.amely.socialapp:id/btnVoucherAddCart").click();

        Thread.sleep(3000);
        scrollDown();

        driver.findElementById("com.amely.socialapp:id/imgRowVoucher").click();
        driver.findElementById("com.amely.socialapp:id/btnVoucherAddCart").click();


        Thread.sleep(3000);
        scrollDown();
        scrollDown();
        driver.findElementById("com.amely.socialapp:id/imgRowVoucher").click();
        driver.findElementById("com.amely.socialapp:id/btnVoucherAddCart").click();

        Thread.sleep(3000);
        scrollDown();
        scrollDown();
        driver.findElementById("com.amely.socialapp:id/imgRowVoucher").click();
        driver.findElementById("com.amely.socialapp:id/btnVoucherAddCart").click();


        driver.findElementById("com.amely.socialapp:id/btnMainTitleCart").click();


        Thread.sleep(3000);


       List<MobileElement> ListRowprice = driver.findElementsById("com.amely.socialapp:id/txtRowPrice");

        List<MobileElement> ListRowCartAmount= driver.findElementsById("com.amely.socialapp:id/edtRowCartAmount");

 //Float totalPrice=Ezqua.getPriceTotalCarts(Cart);


      /* float  finalResult=0;
        float a=0;
        float a1=0;
        for (int i = 0; i < ListRowprice.size(); i++)

        {

            //  String s = ListFrameLayout.get(i).getText();

            String replace = ListRowprice.get(i).getText().replace(" đ","");

            String replaceFinish=replace.replace(",","");


            a=Float.parseFloat(replaceFinish);



            //  System.out.println(finalResult);

            for (int j = 0; j < ListRowCartAmount.size(); j++)

            {

                String s1 = ListRowCartAmount.get(j).getText();

                a1=Float.parseFloat(s1);

            }

            finalResult+=a*a1;
            System.out.println(a1+"\n");

            System.out.print("Amount= " +a1+   "Price= " +a +   "Total = Amount *Price ="+finalResult +"\n");


        }*/


   }


  public void abc(String s,String v)
    {
        s="250,000";
        v="150,000";
        Float sum=Float.parseFloat(s)+Float.parseFloat(v);
    System.out.println("ket qua phep cong"+sum);
    }
    @AfterTest
    public void afterTest() {
        // thoát sau khi chạy hết test case
        driver.quit();

    }


     /*
    @Test(priority =6)
    public void addFriends() throws InterruptedException {
        String currentScreen = driver.currentActivity();

        driver.navigate().back();
        driver.findElementById("com.amely.socialapp:id/fabContactPersonAdd").click();
    //    driver.findElementByClassName("android.widget.EditText").sendKeys("0987476321");
      //  driver.findElementByClassName("android.widget.Button").click();
        driver.lockDevice();
        //TouchAction touch=new TouchAction(driver);
       // touch.press(10,20);

    WebElement element;

        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();

        scrollObject.put("direction", "down");
       // scrollObject.put("element", ((RemoteWebElement) element).getId("2558"));
        js.executeScript("mobile: scroll", scrollObject);


    }
*/
}
