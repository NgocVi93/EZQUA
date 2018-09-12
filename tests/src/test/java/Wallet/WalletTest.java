package Wallet;

import Login.LoginPage;
import SignUp.SignUpPage;
import Login.ElementMenu;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

import static com.thoughtworks.selenium.SeleneseTestCase.assertNotEquals;


/**
 * Created by sysadmin on 10/12/17.
 */
public class WalletTest {
    AndroidDriver driver;

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
        cap.setCapability("AppPackage", "com.amely.socialapp");
        cap.setCapability("AppActivity", "com.amely.socialapp.view.activity.SplashScreenActivity");

        cap.setCapability("appWaitActivity", "com.amely.socialapp.view.activity.LoginActivity',com.amely.socialapp.view.activity.LoginActivity");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);

    }


    @Test(priority = 0)
    public void GoToWAllet() throws Exception
    {
        Wallet wallet=new Wallet(driver);
        ElementMenu menu=new ElementMenu(driver);
        LoginPage login=new LoginPage(driver);


        login.Login("vipn123","vipn123");
        wallet.Sleep(5000);
        menu.gotoInventory();
        wallet.Sleep(2000);
        wallet.GotoWallet();
    }

    @Test(priority = 1)
    public void CompareTitle() throws Exception
    {
        Wallet wallet=new Wallet(driver);

        Assert.assertEquals(wallet.getTitleWallet(),"Ví của tôi");

    }

    @Test(priority = 2)
    public void FillAmountLessThanMin() throws Exception
    {
        Wallet wallet=new Wallet(driver);
        LoginPage login=new LoginPage(driver);


        wallet.click_btnWallAdd();
        wallet.Sleep(3000);
        String CurrentScreen = driver.currentActivity();
        wallet.send_WalletAmount(wallet.getValueLessThanMin()+"");


        //So sánh Amount false với boolean True
        assertNotEquals(wallet.CompareMinMaxAmount(),true);

        // Chọn
        wallet.click_btnNext();
        String ActualScreen = driver.currentActivity();
        wallet.Sleep(3000);

        // So sánh không chuyển trang khác khi chọn qua trang
        Assert.assertEquals(CurrentScreen,ActualScreen);

    }

    @Test(priority = 3)
    public void FillAmountBiggerThanMax() throws Exception
    {
        Wallet wallet=new Wallet(driver);
        LoginPage login=new LoginPage(driver);

        String CurrentScreen = driver.currentActivity();

        wallet.send_WalletAmount(wallet.getValueBiggerThanMax()+"");

        //So sánh Amount false với boolean True
        assertNotEquals(wallet.CompareMinMaxAmount(),true);
        wallet.click_btnNext();
        String ActualScreen = driver.currentActivity();
        wallet.Sleep(3000);

        // So sánh không chuyển trang khác khi chọn qua trang
        Assert.assertEquals(CurrentScreen,ActualScreen);

    }

@Test(priority = 4)
    public void DepositWithATM () throws Exception
    {
        Wallet wallet=new Wallet(driver);
        LoginPage login=new LoginPage(driver);

        String CurrentScreen = driver.currentActivity();

        wallet.send_WalletAmount(wallet.getValueBetweenMinMax()+"");
        //So sánh Amount false với boolean True
        assertNotEquals(wallet.CompareMinMaxAmount(),true);
        wallet.clickATM();
        wallet.click_btnNext();
        String ActualScreen = driver.currentActivity();
        wallet.Sleep(3000);

        // So sánh không chuyển trang khác khi chọn qua trang không
        assertNotEquals(CurrentScreen,ActualScreen);



    }


    @Test(priority = 5)
    public void WithDrawalLessMin()throws Exception
    {
        Wallet wallet=new Wallet(driver);
        LoginPage login=new LoginPage(driver);
driver.navigate().back();

        wallet.click_btnWalletWithdrawal();
        wallet.Sleep(3000);
        String CurrentScreen = driver.currentActivity();
        wallet.send_WalletAmount(wallet.getValueLessThanMin()+"");


        //So sánh Amount false với boolean True
        assertNotEquals(wallet.CompareMinMaxAmount(),true);

        // Chọn
        wallet.click_btnNext();
        String ActualScreen = driver.currentActivity();
        wallet.Sleep(3000);

        // So sánh không chuyển trang khác khi chọn qua trang
        Assert.assertEquals(CurrentScreen,ActualScreen);

    }


    @Test(priority = 6)
    public void WithDrawalLessMax()throws Exception
    {

        Wallet wallet=new Wallet(driver);
        

        String CurrentScreen = driver.currentActivity();

        wallet.send_WalletAmount(wallet.getValueBiggerThanMax()+"");

        //So sánh Amount false với boolean True
        assertNotEquals(wallet.CompareMinMaxAmount(),true);
        wallet.click_btnNext();
        String ActualScreen = driver.currentActivity();
        wallet.Sleep(3000);

        // So sánh không chuyển trang khác khi chọn qua trang
        Assert.assertEquals(CurrentScreen,ActualScreen);
    }
@Test(priority = 7)
    public void WithDrawalUsingPaypal()throws Exception
    {
        SignUpPage signup=new SignUpPage(driver);


        Wallet wallet=new Wallet(driver);
        

        //Back về Wallet lấy Wallet Balance để so sánh sau khi đã rút tiền
        driver.navigate().back();
        float WalletBalance=wallet.getWalletBalance()-1000;
        System.out.print(WalletBalance);



        wallet.click_btnWalletWithdrawal();
        wallet.Sleep(3000);

       // String CurrentScreen = driver.currentActivity();

        // Rút 1000 đồng
        wallet.send_WalletAmount("1000");

        wallet.click_btnNext();
        wallet.sendInfoWithdrawalPaypalPayment("abc@gmail.com",signup.randomString(100));
        wallet.click_stepComplete();

        wallet.Sleep(5000);

        // So sánh Wallet Balance trước và sau khi rút tiền
        Assert.assertEquals(wallet.getWalletTotal(),WalletBalance);
        System.out.print(wallet.getWalletTotal());

    }

@Test(priority = 8)
    public void WithDrawalUsingBankAccount()throws Exception
    {
        SignUpPage signup=new SignUpPage(driver);


        Wallet wallet=new Wallet(driver);
        LoginPage login=new LoginPage(driver);

        //Back về Wallet lấy Wallet Balance để so sánh sau khi đã rút tiền
        wallet.Sleep(3000);
        float WalletBalance=wallet.getWalletBalance()-1000;
        System.out.print(WalletBalance);



        wallet.click_btnWalletWithdrawal();
        wallet.Sleep(3000);



        // Rút 1000 đồng
        wallet.send_WalletAmount("1000");
        wallet.click_BankAccount();

        wallet.click_btnNext();

       // wallet.senInfoWithDramaBankAccount(signup.randomNumber(8),"bank"+signup.randomNumber(7),"Ngân hàng "+signup.randomNumber(5),"Chi nhánh "+signup.randomNumber(5),"Rút tiền với Bank Account");

        wallet.senInfoWithDramaBankAccount(signup.randomNumber(8),signup.randomNumber(8),signup.randomString(3),signup.randomString(3),"Rút tiền từ Tài khoản ngân hàng");
        wallet.click_stepComplete();

        wallet.Sleep(5000);

        // So sánh Wallet Balance trước và sau khi rút tiền
        Assert.assertEquals(wallet.getWalletTotal(),WalletBalance);
        System.out.print(wallet.getWalletTotal());

    }




    @AfterTest
    public void afterTest() {
        // thoát sau khi chạy hết test case
        driver.quit();

    }


}
