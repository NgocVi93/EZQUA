package Ezqua.ProfilePage;

/**
 * Created by sysadmin on 10/18/17.
 */
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Profile {
    AndroidDriver driver;
    public Profile(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }
/** Message **/
    @AndroidFindBy(id="com.amely.socialapp:id/txtMainTitleActionbar")
    public WebElement txtMainTitleActionbar;

 @AndroidFindBy(id="com.amely.socialapp:id/edtChat")
    public WebElement edtChat;

@AndroidFindBy(id="com.amely.socialapp:id/btnSend")
    public WebElement btnSend;

@AndroidFindBy(id="com.amely.socialapp:id/btnEmoji")
    public WebElement btnEmoji;

@AndroidFindBy(xpath="//android.widget.TextView[@bounds='[532,398][580,446]']")
    public WebElement Emoji1;
@AndroidFindBy(xpath="//android.widget.TextView[@bounds='[585,398][633,446]']")
    public WebElement Emoji2;


    public String getTxtMainTitleActionbar()
    {
        return txtMainTitleActionbar.getText();

    }

    public void clickbtnSend(){btnSend.click();}



    public void Chat_SendOnlyText(String story)
    {
        edtChat.clear();
        edtChat.sendKeys(story);
        clickbtnSend();

    }


    public void clickbtnEmoji()
    {
        btnEmoji.click();
    }
    public void Chat_SendOnlyEmoji()
    {
        for(int i=0;i<4;i++)
        {
            Emoji1.click();
            Emoji2.click();
        }
        clickbtnSend();
    }

/**End Messsage**/

/** Group **/

@AndroidFindBy(xpath="//android.widget.LinearLayout[@bounds='[266,1149][533,1216]']")
public WebElement tabGroup;
@AndroidFindBy(id="com.amely.socialapp:id/fabContactGroupCreate")
public WebElement btnAddNewGroup;



/**End Group **/









}
