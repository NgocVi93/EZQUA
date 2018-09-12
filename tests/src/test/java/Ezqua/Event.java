package Ezqua;

/**
 * Created by sysadmin on 8/24/17.
 */
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import static com.thoughtworks.selenium.SeleneseTestCase.assertNotEquals;

public class Event {
    static AndroidDriver driver;
     public int Sleep( int time)throws InterruptedException
    {
        Thread.sleep(time);
        return time;
    }
    static public void scrollDown() throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.7);
        int endy = (int) (size.height * 0.2);
        int startx = size.height / 2;
        driver.swipe(startx, starty, startx, endy, 800);

    }
    @Test(priority =1)
    public void SignIn() throws InterruptedException {
        // Sleep(2000);
        String currentScreen = driver.currentActivity();


        // Nhập user name
        driver.findElementById("ezqua.dfm.com.prototype:id/txtUsername").clear();
        driver.findElementById("ezqua.dfm.com.prototype:id/txtUsername").sendKeys("vipn123");
        Sleep(2000);
        // Nhập mật khẩu
        driver.findElementById("ezqua.dfm.com.prototype:id/txtPassword").clear();
        driver.findElementById("ezqua.dfm.com.prototype:id/txtPassword").sendKeys("vipn123");

        // Nhấn nút sign in
        driver.findElementById("ezqua.dfm.com.prototype:id/btnLogin").click();


        Sleep(5000);
        String screenSignIn = driver.currentActivity();
        assertNotEquals(currentScreen, screenSignIn);
        WebDriverWait wait = new WebDriverWait(driver, 30);


        System.out.print("Pass test case: Nhập đúng SignIn \n");

        //Click allow access photo, media and f
        driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();

        //Allow access take pictures
        driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        Sleep(2000);
    }
    @Test(priority =2)
    public void ViewInforEVent() throws InterruptedException
    {

        driver.findElementById("ezqua.dfm.com.prototype:id/btnDrawer").click();
        Sleep(2000);
        driver.findElementById("ezqua.dfm.com.prototype:id/main_btnPersonal").click();

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
}
