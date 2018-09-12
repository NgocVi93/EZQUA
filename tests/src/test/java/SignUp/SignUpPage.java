package SignUp;

/**
 * Created by sysadmin on 10/9/17.
 */


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



import java.security.SecureRandom;

public class SignUpPage {
    AndroidDriver driver;

    public SignUpPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }
    //Register

    @AndroidFindBy(id="com.amely.socialapp:id/tvRegister")
    public WebElement button_Register;

    @AndroidFindBy(id="com.amely.socialapp:id/ms_stepNextButton")
    public WebElement button_Next;

    @AndroidFindBy(id="com.amely.socialapp:id/ms_stepCompleteButton")
    public WebElement button_Complete;



    @AndroidFindBy(id="com.amely.socialapp:id/edtRegFristname")
    public WebElement firstname;

    @AndroidFindBy(id="com.amely.socialapp:id/edtRegLastname")
    public WebElement lastname;

    @AndroidFindBy(id="com.amely.socialapp:id/edtRegBirthday")
    public WebElement birthday;
 @AndroidFindBy(id="android:id/date_picker_header_year")
    public WebElement pickeryear;

    @AndroidFindBy(xpath = "\"//android.view.View[@bound='[710,1048][824,1168]']\"")
    public WebElement birthday_day;

    @AndroidFindBy(id="com.amely.socialapp:id/checkboxRegPrivacy")
    public WebElement RegPrivacy;

    @AndroidFindBy(id="android:id/button1")
    public WebElement birthday_OK;

    @AndroidFindBy(id="com.amely.socialapp:id/edtRegUsername")
    public WebElement username;

    @AndroidFindBy(id="com.amely.socialapp:id/edtRegPassword")
    public WebElement password;

    @AndroidFindBy(id="com.amely.socialapp:id/edtRegRePassword")
    public WebElement password_re;

    @AndroidFindBy(id="com.amely.socialapp:id/edtRegEmail")
    public WebElement email;
    @AndroidFindBy(id="com.amely.socialapp:id/edtRegReEmail")
    public WebElement email_re;

    @AndroidFindBy(id="com.amely.socialapp:id/edtRegPhone")
    public WebElement phoneNumber;

  @AndroidFindBy(id="com.amely.socialapp:id/checkboxPolicy")
    public WebElement Policy;



    //ForgotPass
    @AndroidFindBy(id="com.amely.socialapp:id/tvForgotPass")
    public WebElement button_ForgotPass;


    public void click_SignUpbutton()
    {
        button_Register.click();
    }
    public void click_NextButton()
    {
        button_Next.click();
    }
    public void send_FirstName(String FirstName)
    {
        firstname.sendKeys(FirstName);
    }

    public void clear_FirstName()
    {firstname.clear();}

    public void send_LastName(String LastName)
    {
        lastname.sendKeys(LastName);
    }
    public void clear_LastName()
    {lastname.clear();}
    public void click_Birthday()
    {
        birthday.click();
    }
    public void send_birthday(String Birthday)
    {
        birthday.sendKeys(Birthday);
    }

    public void choose_birthday()
    {
     birthday_day.click();
    }

    public void click_birthday_OK()
    {
        birthday_OK.click();
    }

    public void click_CheckboxRegPrivacy()
    {
        RegPrivacy.click();
    }

    public  void send_UserName(String UserName)
    {
        username.sendKeys(UserName);
    }
    public  void clear_UserName(){username.clear();}
    public void send_Password(String Password)
    {
        password.sendKeys(Password);
    }
    public  void clear_Password(){password.clear();}
    public void send_PasswordRe(String PasswordRe)
    {
        password_re.sendKeys(PasswordRe);
    }
    public  void clear_PasswordRe(){password_re.clear();}
    public void send_Email(String Email)
    {
        email.sendKeys(Email);
    }
    public  void clear_Email(){email.clear();}
    public  void clear_EmailRe(){email_re.clear();}
    public void send_EmailRe(String EmailRe)
    {
        email_re.sendKeys(EmailRe);
    }
    public void send_PhoneNumber(String PhoneNumber)
    {
        phoneNumber.sendKeys(PhoneNumber);
    }
    public  void clear_PhoneNumber(){phoneNumber.clear();}
    public void click_CompleteButton()
    {
        button_Complete.click();
    }

    public void click_CheckboxPolicy() {
        Policy.click();
    }

     public int Sleep( int time)throws InterruptedException
    {
        Thread.sleep(time);
        return time;
    }

    //Random string
    final String AB = "abcdeghiklmnopqrstuvsy";

    SecureRandom rnd = new SecureRandom();

    public String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    // Random numbers
    String number="123456799125412368740";
  public   String randomNumber(int len)
    {
        StringBuilder sb = new StringBuilder(  );for( int i = 0; i < len; i++ )
        sb.append( number.charAt( rnd.nextInt(number.length()) ) );
        return sb.toString();

    }


    //Màn hình SignUp1
    public void SignUpWithScreen1(String firstname,String lastname,String birthday) throws Exception
    {


        this.clear_FirstName();
       // Sleep(2000);
        this.send_FirstName(firstname);
        //Sleep(2000);
        this.clear_LastName();
        this.send_LastName(lastname);
        this.send_birthday(birthday);
       // Sleep(3000);
        this.click_birthday_OK();
      //  Sleep(2000);

        this.click_NextButton();
        click_CheckboxRegPrivacy();

    }


    //Màn hình SignUp2
    public void SignUpWithScreen2(String username,String password,String password_re,String email,String email_re,String phonenumber) throws Exception
    {
        this.clear_UserName();


        this.send_UserName(username);


        this.clear_Password();

        this.send_Password(password);

        this.clear_PasswordRe();

        this.send_PasswordRe(password_re);

        this.clear_Email();

        this.send_Email(email);

        this.clear_EmailRe();
         this.send_EmailRe(email_re);

        this.clear_PhoneNumber();

        this.send_PhoneNumber(phonenumber);

        this.click_CheckboxPolicy();
        this.click_CompleteButton();
        Sleep(5000);


    }







}
