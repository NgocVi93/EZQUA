package Login;

/**
 * Created by sysadmin on 10/12/17.
 */
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class ElementMenu {
    AndroidDriver driver;

    public ElementMenu(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    //
    @AndroidFindBy(id="ezqua.dfm.com.prototype:id/btnDrawer")
    public WebElement btnDrawer;

    @AndroidFindBy(id="ezqua.dfm.com.prototype:id/main_btnPersonal")
    public WebElement btnPersonal;

    @AndroidFindBy(id="ezqua.dfm.com.prototype:id/main_btnSocial")
    public WebElement btnSocial;

    @AndroidFindBy(id="ezqua.dfm.com.prototype:id/main_btnEcom")
    public WebElement btnEcom;

    @AndroidFindBy(id="ezqua.dfm.com.prototype:id/main_btnInven")
    public WebElement btnInven;

    @AndroidFindBy(id="ezqua.dfm.com.prototype:id/main_btnSetting")
    public WebElement btnSetting;

    public void click_btnDrawer()
    {
        btnDrawer.click();
    }

    public void click_btnPersonal()
    {
        btnPersonal.click();
    }

    public void click_btnSocial()
    {
        btnSocial.click();
    }

    public void click_btnEcom()
    {
        btnEcom.click();
    }

    public void click_btnInven()
    {
        btnInven.click();
    }

    public void click_btnSetting()
    {
        btnSetting.click();
    }


    public void gotoInventory()
    {
        this.click_btnDrawer();
        this.click_btnInven();

    }
}
