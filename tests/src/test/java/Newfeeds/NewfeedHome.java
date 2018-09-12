package Newfeeds;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by sysadmin on 10/20/17.
 */
public class NewfeedHome
{
    AndroidDriver driver;

    public NewfeedHome(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }
//Allow Amely to access photos,media and files on your devices
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
        public WebElement permission_allow_button;


    // button like
    @AndroidFindBy( id= "com.amely.socialapp:id/btnRowNewFeedLike")
    public WebElement btnRowNewFeedLike;

// số lương like
    @AndroidFindBy( id= "com.amely.socialapp:id/txtRowNewFeedLike")
    public WebElement txtRowNewFeedLike;

// button comment
    @AndroidFindBy( id= "com.amely.socialapp:id/btnRowNewFeedComment")
    public WebElement btnRowNewFeedComment;

    // / Số lượng comment
    @AndroidFindBy( id= "com.amely.socialapp:id/txtRowNewFeedComment")
    public WebElement txtRowNewFeedComment;

    //  comment status
    @AndroidFindBy(id= "com.amely.socialapp:id/edtFeedComment")
    public WebElement edtFeedComment;


//  button comment
    @AndroidFindBy(id= "com.amely.socialapp:id/btnComment")
    public WebElement btnComment;

    //  nội dung comment
    @AndroidFindBy(id= "com.amely.socialapp:id/txtCommentContent")
    public WebElement txtCommentContent;

// button 3 chấm newfeed
    @AndroidFindBy( id= "ewfeedscom.amely.socialapp:id/btnRowNewFeedMenu")
    public WebElement btnRowNewFeedMenu;



    /** Content Status in New Feed**/
    // button Add new feed
    @AndroidFindBy( id= "com.amely.socialapp:id/btnNewFeedFloatButton")
    public WebElement btnNewFeddAdd;

     // Khung post status
    @AndroidFindBy( id= "com.amely.socialapp:id/edtContent")
    public WebElement edtContent;



// button post status
    @AndroidFindBy( id= "om.amely.socialapp:id/imgTitleActionbarPost")
    public WebElement btnPost;

    // button Tag friend
    @AndroidFindBy( id= "com.amely.socialapp:id/btnFeedPostTag")
    public WebElement btnFeedPostTag;

 // Auto suggest Tag Friend
    @AndroidFindBy( id= "com.amely.socialapp:id/autoedtPostFeedTag")
    public WebElement autoedtPostFeedTag;

    // button Location
    @AndroidFindBy( id= "com.amely.socialapp:id/btnFeedPostPlace")
    public WebElement btnFeedPostPlace;


    // Choose location
    @AndroidFindBy( id= "com.google.android.gms:id/select_marker_location")
    public WebElement select_marker_location;

    // Search Location
    @AndroidFindBy(id="com.google.android.gms:id/search_bar")
    public WebElement locationSearch;

// Enter Location
    @AndroidFindBy(id="com.google.android.gms:id/edit_text")
    public WebElement locationEdit;

    //Choose the first list sugguest
    @AndroidFindBy(id = "com.google.android.gms:id/place_autocomplete_prediction_primary_text")
    public WebElement locationAddress;

 //Choose the first list sugguest
    @AndroidFindBy(id = "com.google.android.gms:id/confirm_button")
    public WebElement locationConfirm;

    // button private
    @AndroidFindBy( id= "com.amely.socialapp:id/imgPrivacy")
    public WebElement imgPrivacy;

    // button Go to Gallery
    @AndroidFindBy(xpath = "//android.widget.ImageView[@bounds='[95,1094][779,1123]']")
    public WebElement imgLibrary;

    // button Go to direct camera
     @AndroidFindBy(xpath = "//android.widget.ImageView[@bounds='[95,1158][779,1187]']")
         public WebElement jmgDirectCamera;

    // Public Private
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mọi người']")
    public WebElement privatePublic;

// Public Private
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bạn bè']")
    public WebElement privateFriend;

// Public Private
    @AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[95,1158][779,1187]']")
    public WebElement privateOnlyMe;
/* The end of Content Status in New Feed*/

/**Like, Comment,Edit new feeds **/

//Button for go to comment screen
    public void clickbtnRowNewFeedLike()throws Exception
    {
        btnRowNewFeedLike.click();
        Thread.sleep(2000);
    }

    public void clickbtnRowNewFeedComment()throws Exception
    {
        btnRowNewFeedComment.click();
    }

    public void clickbtnNewFeedFloatButton() throws Exception
    {
        btnNewFeddAdd.click();
    }


    public void clickbtnRowNewFeedMenu()
    {
        btnRowNewFeedMenu.click();
    }

    public String getNewFeedLike()
    {
        return txtRowNewFeedLike.getText();
    }

    public String getNewFeedCommand()
    {
        return txtRowNewFeedComment.getText();
    }

    public void sendCommand( String edtFeedCommenr)
    {
        edtFeedComment.sendKeys(edtFeedCommenr);
    }

    //Button Send comment
    public void clickbtnComment()
    {
        btnComment.click();
    }
    public void gettxtCommentContent()
    {
        txtCommentContent.getText();
    }

    public void SendComment(String comment)
    {
        edtFeedComment.sendKeys(comment);

    }





/** The end of Like, Comment,Edit new feeds**/

/** Content Status in New Feed**/


public void permission_allow_button() throws Exception
{
    permission_allow_button.click();
}
    // Send Content New Post in newfeeds

    public void CreateNewFeedWithPrivacyFriend(String content)  throws Exception
    {
        imgPrivacy.click();
        ChooseImage();
      //  privateFriend.click();
        edtContent.sendKeys(content);
        SendTagFriend();
        Thread.sleep(3000);
        //SendLocation();
        ClickbtnPost();
    }

   public void CreateNewFeedWithPrivacyOnlyMe(String content)  throws Exception
    {
        imgPrivacy.click();
        privateOnlyMe.click();
        edtContent.sendKeys(content);
        SendTagFriend();
        Thread.sleep(3000);
        SendLocation();
        ClickbtnPost();
    }

    public void CreateNewFeedWithPrivacyPublic(String content)  throws Exception
    {
        imgPrivacy.click();

        privatePublic.click();
        edtContent.sendKeys(content);
        SendTagFriend();
        Thread.sleep(3000);
        SendLocation();
        ClickbtnPost();
    }

    public void SendTagFriend() throws Exception
    {
        btnFeedPostTag.click();
        SendSusggestTagFriend("vipn");
        Robot robot =new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }
    public void SendLocation() throws Exception
    {  Thread.sleep(5000);

        ClickbtnFeedPostPlace();

        ClickSLocationSearch();

        Thread.sleep(3000);
        SendLocationEdit("Da Nang");
        Thread.sleep(3000);
        ClickLocationAddress();
        ClickLocationConfirm();
        ClickbtnPost();
        Thread.sleep(2000);
    }


        public void ChooseImage() throws Exception
        {
            imgLibrary.click();
            driver.findElementByXPath("//android.widget.ImageView[@bounds='[3,121][264,387]']").click();
            driver.findElementByXPath("//android.widget.ImageView[@bounds='[725,43][789,107]']").click();


        }

    // click post action
    public void ClickbtnPost()
    {
        btnPost.click();
    }

    // Button Post New Feed
    public void ClickbtnFeedPostTag()
    {
        btnFeedPostTag.click();
    }

    // Button Place
    public void ClickbtnFeedPostPlace()
    {
        btnFeedPostPlace.click();
    }

    //Sussgest lisst friend
    public void SendSusggestTagFriend( String friend)
    {
        autoedtPostFeedTag.sendKeys(friend);
    }

    public void Click_select_marker_location( )
    {
        select_marker_location.click();
    }

    //Search Location
    public void ClickSLocationSearch( )
    {
        locationSearch.click();
    }


    //Send suggest location
    public void SendLocationEdit( String location )
    {
        locationEdit.sendKeys(location);
    }


    //Click button Location Address
    public void ClickLocationAddress()
    {
        locationAddress.click();
    }

    // Click Privacy
    public void ClickLocationConfirm()
    {
        locationConfirm.click();
    }

    // Click Privacy Friend
    public void ClickpPivatefriend()
    {
        privateFriend.click();
    }

    // Click Privacy Only Me
    public void ClickPrivacyOnlyMe()
    {
        privateOnlyMe.click();
    }
    // Click Privacy Public
    public void ClickPrivacyPublic()
    {
        privatePublic.click();
    }

    /** end the content NewFeed **/

    public int CountLike()
    {
        String a=txtRowNewFeedLike.getText();
        return  Integer.parseInt(a);
    }
    public int CountComment()
    {
        return  Integer.parseInt(getNewFeedCommand());

    }
public String a( )
    {

        return btnRowNewFeedLike.getCssValue("Background-color");

    }


}
