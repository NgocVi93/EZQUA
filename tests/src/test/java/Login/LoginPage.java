package Login;

/**
 * Created by sysadmin on 10/9/17.
 */


import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import java.security.SecureRandom;

public class LoginPage {
    public LoginPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }
    @AndroidFindBy(id="com.amely.socialapp:id/txtUsername")
    public WebElement username;

    @AndroidFindBy(id="com.amely.socialapp:id/txtPassword")
    public WebElement password;

    @AndroidFindBy(id="com.amely.socialapp:id/btnLogin")
    public WebElement btnLogin;

    @AndroidFindBy(id="com.amely.socialapp:id/btnDrawer")
    public WebElement btnDrawer;

    @AndroidFindBy(id="com.amely.socialapp:id/tab_setting_security")
    public WebElement tab_setting_security;

    @AndroidFindBy(id="com.amely.socialapp:id/main_btnSetting")
    public WebElement btnSetting;

    @AndroidFindBy(id="com.amely.socialapp:id/lineSettingSecurityLogout")
    public WebElement lineSettingSecurityLogout;


    @AndroidFindBy(id="android:id/button1")
    public WebElement confirmLogout_OK;


    @AndroidFindBy(id="android:id/button2")
    public WebElement confirmLogout_Cancel;



    public void send_Username(String Username)
    {
        username.sendKeys(Username);
    }
    public void clearUserName()
    {
        username.clear();
    }
    public void clearPassword()
    {
        password.clear();
    }

    public void send_Password(String Password)
    {
        password.sendKeys(Password);
    }

    public void click_btnLogin()
    {
        btnLogin.click();
    }
    public int Sleep( int time)throws InterruptedException
    {
        Thread.sleep(time);
        return time;
    }

    public void click_BtnDrawer()
    {
        btnDrawer.click();
    }
public void click_BtnSetting()
    {
        btnSetting.click();
    }
    public void click_tab_setting_security()
    {
        tab_setting_security.click();
    }
public void click_SettingSecurityLogout()
    {
        lineSettingSecurityLogout.click();
    }

public void click_ConfirmLogoutOK()
{
    confirmLogout_OK.click();
}public void click_ConfirmLogoutCancel()
{
    confirmLogout_Cancel.click();
}

    public void Login(String Username, String Password)
    {
        this.clearUserName();
        this.send_Username(Username);
        this.clearPassword();
        this.send_Password(Password);
        this.click_btnLogin();
    }
    public void Logout() throws Exception
    {
        this.click_BtnDrawer();
        Sleep(3000);
        this.click_BtnSetting();
        Sleep(3000);
        this.click_tab_setting_security();
        Sleep(3000);
        this.click_SettingSecurityLogout();
        Sleep(3000);
        this.click_ConfirmLogoutOK();
    }
}
