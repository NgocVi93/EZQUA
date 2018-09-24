package PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ExchangesGift {
    AndroidDriver driver;
    public ExchangesGift(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }
   // @AndroidFindBy(xpath = "\"//android.view.View[@bound='[273,240][541,390]']\"")
   @AndroidFindBy(xpath = "\"//android.widget.ImageView[@bound='[210,393][939,473]']\"")
    public WebElement tabExchangeGift;


    @AndroidFindBy(xpath = "//android.widget.TextView[@id='fabOfferProposalCreateOffer']")
    public WebElement fabCreateOffer;




    //Hình thức trao đổi -
    @AndroidFindBy(xpath = "//android.widget.TextView[@id='id/spinnerCreateOfferTag']")
    public WebElement spinnerCreateOfferTag;

    // Đối tượng trao đổi
    @AndroidFindBy(xpath = "//android.widget.TextView[@id='id/spinnerCreateOfferType']")
    public WebElement spinnerCreateOfferType;

    // Thời gian hiệu lực
    @AndroidFindBy(xpath = "//android.widget.TextView[@id='id/spinnerCreateOfferTime']")
    public WebElement spinnerCreateOfferTime;




    @AndroidFindBy(xpath = "//android.widget.TextView[@id='id/imgCreateOfferChooseGift']")
    public WebElement imgCreateOfferChooseGift;

 @AndroidFindBy(xpath = "//android.widget.TextView[@id='id/edtCreateOfferNote']")
    public WebElement edtCreateOfferNote;

// CLick button tao Offer
    public void ClicktabExchangeGift()
    {
        tabExchangeGift.click();
    }
    public void ClickbuttonCreateOfffer()
    {
        fabCreateOffer.click();
    }

// Click Hinh thuc trao đoi
    public void ClickTypeOfOffer()
    {
        spinnerCreateOfferTag.click();
    }
// Chon hinh thuc trao doi thong thuong

    public void ChooseNormalType()
    {
        WebElement abc=driver.findElementById("spinnerCreateOfferTag");
        WebElement childElement1 = abc.findElement(By
                .xpath("//android.view.View[@index='1']"));
        childElement1.click();

    }
     public void CreateOffferFreeType()
     {

         WebElement abc=driver.findElementById("spinnerCreateOfferTag");
         WebElement childElement1 = abc.findElement(By
                 .xpath("//android.view.View[@index='2']"));
         childElement1.click();

     }
 public void CreateOffferRandomType()
     {

         WebElement abc=driver.findElementById("spinnerCreateOfferTag");
         WebElement childElement1 = abc.findElement(By
                 .xpath("//android.view.View[@index='3']"));
         childElement1.click();

     }

}
