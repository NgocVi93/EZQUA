package PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

  public  class AllElement {

    public AllElement(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    /*Permision*/
      @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
      public WebElement btnpermisionallow;



    /**Personal**/
    @AndroidFindBy(xpath = "//android.widget.TextView[@id='btnMainTitleSearch']")
    public WebElement btnMainTitleSearch;

    @AndroidFindBy(xpath = "//android.widget.TextView[@id='id/id_menu_3_dot']")
    public WebElement id_menu_3_dot;

// floating action button
    @AndroidFindBy(xpath = "//android.widget.TextView[@id='id/fabContactPersonAdd']")
    public WebElement fabContactPersonAdd;

    //Danh ba
    @AndroidFindBy(xpath = "\"//android.view.View[@bound='[2,240][360,390]']\"")
    public WebElement tabContact;

    //Tin nhan
    @AndroidFindBy(xpath = "\"//android.view.View[@bound='[362,240][721,390]']\"")
    public WebElement tabMessage;

    // Thong bao
    @AndroidFindBy(xpath = "\"//android.view.View[@bound='[723,240][1080,390]']\"")
    public WebElement tabNotifi;


    // Ca nhan
    @AndroidFindBy(xpath = "\"//android.view.View[@bound='[0,1770][360,1920]']\"")
    public WebElement tabPersonal;

    // Group
    @AndroidFindBy(xpath = "\"//android.view.View[@bound='[360,1770][720,1920]']\"")
    public WebElement tabGroup;

    // OA
    @AndroidFindBy(xpath = "\"//android.view.View[@bound='[720,1770][1080,1920]']\"")
    public WebElement tabOA;





/** Xa Hoi**/
    // Update
    @AndroidFindBy(xpath = "\"//android.view.View[@bound='[3,240][271,390]']\"")
    public WebElement tabUpdate;


    // Trao doi
    @AndroidFindBy(xpath = "\"//android.view.View[@bound='[273,240][541,390]']\"")
    public WebElement tabExchanges;

    // Cua toi
    @AndroidFindBy(xpath = "\"//android.view.View[@bound='[0,1770][360,1920]']\"")
    public WebElement tabMine;

    // Cho duyet
    @AndroidFindBy(xpath = "\"//android.view.View[@bound='[360,1770][720,1920]]']\"")
    public WebElement tabInProcess;

    // Tim kiem
    @AndroidFindBy(xpath = "\"//android.view.View[@bound='[720,1770][1080,1920]']\"")
    public WebElement tabYour;




    // Xung quanh
    @AndroidFindBy(xpath = "\"//android.view.View[@bound='[543,240][812,390]']\"")
    public WebElement tabNearBy;

    // Su kien
    @AndroidFindBy(xpath = "\"//android.view.View[@bound='[814,240][1080,390]']\"")
    public WebElement tabEvent;


    public void Click_BtnSearch()
    {
        btnMainTitleSearch.click();
    }

    public void Click_BtnPermisionAllow()
    {
        btnpermisionallow.click();
    }

}
