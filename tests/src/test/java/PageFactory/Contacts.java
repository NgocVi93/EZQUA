package PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Contacts {

    AndroidDriver driver;
    public Contacts(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(xpath = "//android.widget.TextView[@id='imgContact']")
    public WebElement imgContact;
 @AndroidFindBy(xpath = "//android.widget.TextView[@id='id/fabContactPersonAdd']")
    public WebElement tabContactPersonAdd;

    @AndroidFindBy(xpath = "//android.widget.TextView[@id='btnRowContactChat']")
    public WebElement btnRowContactChat;

    @AndroidFindBy(xpath = "//android.widget.TextView[@id='btnMainTitleSearch']")
    public WebElement btnMainTitleSearch;

    @AndroidFindBy(xpath = "//android.widget.TextView[@id='id/id_menu_3_dot']")
    public WebElement id_menu_3_dot;

    // floating action button
    @AndroidFindBy(xpath = "//android.widget.TextView[@id='id/fabContactPersonAdd']")
    public WebElement fabContactPersonAdd;

    @AndroidFindBy(xpath = "\"//android.view.View[@bound='[2,240][360,390]']\"")
    public WebElement tabContact;

    @AndroidFindBy(xpath = "\"//android.view.View[@bound='[362,240][721,390]']\"")
    public WebElement tabMessage;

    @AndroidFindBy(xpath = "\"//android.view.View[@bound='[723,240][1080,390]']\"")
    public WebElement tabNotifi;

    @AndroidFindBy(xpath = "\"//android.view.View[@bound='[0,1770][360,1920]']\"")
    public WebElement tabPersonal;

    @AndroidFindBy(xpath = "\"//android.view.View[@bound='[360,1770][720,1920]']\"")
    public WebElement tabGroup;

    @AndroidFindBy(xpath = "\"//android.view.View[@bound='[720,1770][1080,1920]']\"")
    public WebElement tabOA;




}
