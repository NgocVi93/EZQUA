package Event;

/**
 * Created by sysadmin on 11/9/17.
 */
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EventPage
{

    public EventPage(AndroidDriver driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@bounds='[620,118][780,185]']")
    public WebElement tabEvent;


     @AndroidFindBy(id = "com.amely.socialapp:id:id/fabEventMemberAdd")
    public WebElement btnEventAdd;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@bounds='[157,132][237,205]']")
    public WebElement tabWedding;

    @AndroidFindBy(id = "com.amely.socialapp:id:id/edtCreateEventGroupName")
    public WebElement eventGroupName;

 @AndroidFindBy(id = "com.amely.socialapp:id:id/checkUserIsGiftGroup")
    public WebElement checkUserIsGiftGroup;


@AndroidFindBy(id = "com.amely.socialapp:id:id/imgCreateEventAddUser")
    public WebElement AddUser;
@AndroidFindBy(xpath = "//android.widget.ImageView[@text='vipn203']")
    public WebElement ChooseUser;

//Sau khi Choose User thi click Ok
    @AndroidFindBy(id = "com.amely.socialapp:id:id/btnCreateEventDialogGuestOk")
    public WebElement OK;

    @AndroidFindBy(id = "com.amely.socialapp:id:id/edtCreateEventDescription")
    public WebElement eventDescription;

 @AndroidFindBy(id = "com.amely.socialapp:id:id/edtCreateEventOptionStartTime")
    public WebElement startTime;
 @AndroidFindBy(id = "com.amely.socialapp:id:id/edtCreateEventOptionEndTime")
    public WebElement endTime;


@AndroidFindBy(id = "com.amely.socialapp:id:id/edtCreateEventOptionStartDay")
    public WebElement startDay;
 @AndroidFindBy(id = "com.amely.socialapp:id:id/edtCreateEventOptionEndDay")
    public WebElement endDay;
 @AndroidFindBy(id = "com.amely.socialapp:id:id/edtCreateEventOptionPlace")
    public WebElement eventPlace;

 @AndroidFindBy(id = "com.amely.socialapp:id:id/edtCreateEventOptionGuest")
    public WebElement eventGuest;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@bounds='[94,266][773,309]")
    public WebElement guest;


@AndroidFindBy(id = "com.amely.socialapp:id:id/switchCreateEvent")
    public WebElement openEvent;




    public void ClickTabEvent(){tabEvent.click();}
    public void ClickEventAdd(){btnEventAdd.click();}
    public void ClickWedding(){tabWedding.click();}
    public void ClickCheckUserIsGiftGroup(){checkUserIsGiftGroup.click();}
    public void FillEventGroupName(String name){eventGroupName.sendKeys(name);}
    public void ClickAddUserToEvent(){AddUser.click();}
    public void AddUserToEvent(){ChooseUser.click();}
    public void ClickOK(){OK.click();}
    public void ClickStartTime(){startTime.click();}
    public void ClickEndTime(){endTime.click();}
    public void ClickStartDay(){startDay.click();}
    public void ClickEndDay(){endDay.click();}
    public void FillEventPlace(String eventplace){eventPlace.sendKeys(eventplace);}
    public void AddGuestToEvent(){guest.click();}
    public void ClickToOpenEvent(){openEvent.click();
    }



    public void FillInforEvent(String eventName, String valueGift, String valueAddMember, String eventPlace) throws Exception
    {
        FillEventGroupName(eventName);

        // true la co check Kho qua chung
        CheckGiftGroup(valueGift);
        CheckAddMember(valueAddMember);
        FillEventPlace(eventPlace);


    }


    public void CheckGiftGroup( String value)throws Exception
    {
           if(value=="true")
           {
               ClickCheckUserIsGiftGroup();


           }

    }

    public void CheckAddMember( String value)throws Exception
    {
        if(value=="true")
        {
            ClickAddUserToEvent();
            this.AddUserToEvent();
            this.ClickOK();
        }

    }



    public void WannaAddMember() throws Exception
    {


    }

}
