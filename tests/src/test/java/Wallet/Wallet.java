package Wallet;

/**
 * Created by sysadmin on 10/12/17.
 */

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Wallet {
    AndroidDriver driver;

    public Wallet(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    // Click Option 3 chấm
    @AndroidFindBy(xpath = "//android.support.v7.widget.LinearLayoutCompat[@index='3']")
    public WebElement moreOptions;

    // Click My Wallet
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ví của tôi']")
    public WebElement titleOptions;

    @AndroidFindBy(id = "com.amely.socialapp:id/txtTitleActionbar")
    public WebElement titleWallet;

    @AndroidFindBy(id = "com.amely.socialapp:id/txtWalletBalance")
    public WebElement txtWalletBalance;

    @AndroidFindBy(id = "com.amely.socialapp:id/txtWalletMin")
    public WebElement txtMinBalance;


    @AndroidFindBy(id = "com.amely.socialapp:id/txtWalletMax")

    public WebElement txtMaxBalance;

    //Deposit add
    @AndroidFindBy(id = "com.amely.socialapp:id/lineWalletAdd")

    public WebElement btnWallAdd;

    // com.amely.socialapp:id/lineWalletWithdrawal
    @AndroidFindBy(id = "com.amely.socialapp:id/lineWalletWithdrawal")

    public WebElement btnWalletWithdrawal;


    //Wallet Add Screen
    @AndroidFindBy(id = "com.amely.socialapp:id/edtWalletAmount")
    public WebElement edtWalletAmount;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Paypal account']")
    public WebElement btnPaypal;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ATM card']")
    public WebElement btnATM;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Credit card']")
    public WebElement btnCreadit;

    @AndroidFindBy(id = "com.amely.socialapp:id/ms_stepNextButton")
    public WebElement btnNext;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='BAB']")
    public WebElement btnBAB;

    @AndroidFindBy(id = "com.amely.socialapp:id/edtWithdrawalEmail")
    public WebElement edtWithdrawalEmail;

    @AndroidFindBy( id= "com.amely.socialapp:id/edtWithdrawalPaypallNote")
    public WebElement edtWithdrawalPaypallNote;

@AndroidFindBy( id= "com.amely.socialapp:id/txtWithdrawalAmount")
    public WebElement txtWithdrawalAmount;

@AndroidFindBy( id= "com.amely.socialapp:id/ms_stepCompleteButton")
    public WebElement txtstepompleComplete;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bank Account']")
    public WebElement txtBankAccount;



    /********************/
    //BankAccount
    @AndroidFindBy( id= "com.amely.socialapp:id/edtWithdrawalBankId")
    public WebElement edtWithdrawalBankId;

    @AndroidFindBy( id= "com.amely.socialapp:id/edtWithdrawalBankAccountName")
    public WebElement edtWithdrawalBankAccountName;

    @AndroidFindBy( id= "com.amely.socialapp:id/edtWithdrawalBankName")
    public WebElement edtWithdrawalBankName;

    @AndroidFindBy( id= "com.amely.socialapp:id/edtWithdrawalBankBranchName")
    public WebElement edtWithdrawalBankBranchName;

    @AndroidFindBy( id= "com.amely.socialapp:id/edtWithdrawalBankNote")
    public WebElement edtWithdrawalBankNote;












    /***************************************************************************/

    // Title wallet
    public void click_moreOptions() {
        moreOptions.click();
    }

    public void click_titleOptipns() {
        titleOptions.click();
    }

    public String getTitleWallet() {
        return titleWallet.getText();
    }

    public String getMinTitleWallet() {
        return titleWallet.getText();
    }


    public String getMaxTitleWallet() {
        return titleWallet.getText();
    }
    public void click_btnWallAdd(){btnWallAdd.click();}  public void click_btnWalletWithdrawal(){btnWalletWithdrawal.click();}

    //Wallet Add Screen

    public void send_WalletAmount(String Amount)
    {
        edtWalletAmount.clear();
        edtWalletAmount.sendKeys(Amount);

    }




    public void GotoWallet() {

        this.click_moreOptions();
        this.click_titleOptipns();

    }
    public void GotoWalletDeposit() {

    this.click_btnWallAdd();

    }

    public void click_btnNext()
    {
        btnNext.click();
    }

    public void click_BankAccount(){txtBankAccount.click();}




    /***********************************************/
    public int Sleep( int time)throws InterruptedException
    {
        Thread.sleep(time);
        return time;
    }

    // Bỏ các kí tự để parse từ String to float
    public float getWalletBalance()
    {
        String balance = txtWalletBalance.getText();
        String replace = balance.replace(" ₫", "");
        String replace1=replace.replace(",","");
        System.out.print(replace1);
        return  Float.parseFloat(replace1);


    }


    public void clickPaypal() {btnPaypal.click();}public void clickATM() {btnATM.click();}public void clickCreadit() {btnCreadit.click();}

    // Lấy chuỗi MinWallet rồi parse thành float
    public float getMinWalletBalance()
    {
        String balance = txtMinBalance.getText();
        String replace = balance.replace(" ₫", "");
        String replace1=replace.replace(",","");

        return  Float.parseFloat(replace1);


    }
    // Lấy chuối Amount parse ra Float để tính toán
    public float getWalletAmount()
    {

        return  Float.parseFloat( edtWalletAmount.getText());


    }

    public float getWalletTotal()
    {
        String balance = txtWalletBalance.getText();
        String replace = balance.replace(" ₫", "");
        String replace1=replace.replace(",","");
        return  Float.parseFloat(replace1);
    }
  public float getMaxWalletBalance()
    {
        String balance = txtMaxBalance.getText();
        String replace = balance.replace(" ₫", "");
        String replace1=replace.replace(",","");
        return  Float.parseFloat(replace1);

    }
    public float getValueLessThanMin()
    {
        return (getMinWalletBalance()/2);
    }
    public float getValueBiggerThanMax()
    {
        return (getMaxWalletBalance()+getMinWalletBalance());
    }

    public float getValueBetweenMinMax()
    {
        return (getMaxWalletBalance()-getMinWalletBalance());
    }

    public boolean CompareMinMaxAmount()
    {
        boolean success ;
        if(this.getWalletAmount()-this.getMinWalletBalance()>=0&&this.getWalletAmount()-this.getMaxWalletBalance()<=0)

        {
            success = true;

        }

        else {
            success = false;
        }

                    return success;
    }




    /****************************/
    // Withdrawal Paypal

    public void send_WithdrawalEmail(String WithdrawalEmail) {
        edtWithdrawalEmail.clear();
        edtWithdrawalEmail.sendKeys(WithdrawalEmail);



    }
    public void send_WithdrawalPaypallNote(String WithdrawalPaypallNote) {
        edtWithdrawalPaypallNote.clear();
        edtWithdrawalPaypallNote.sendKeys(WithdrawalPaypallNote);

    }

    public float getWithdrawalAmount()
    {
        String balance = txtWithdrawalAmount.getText();
        String replace = balance.replace(" ₫", "");
        String replace1=replace.replace(",","");
        return  Float.parseFloat(replace1);
    }

    public void sendInfoWithdrawalPaypalPayment(String Email, String Note)
    {
       send_WithdrawalEmail(Email);
       send_WithdrawalPaypallNote(Note);

    }

    public void click_stepComplete()
    {
        txtstepompleComplete.click();
    }



    /****************************/
    //Bankaccount

    public void Send_BankId(String bankid){edtWithdrawalBankId.sendKeys(bankid);}
    public void Send_BankAccount(String bankaccount){edtWithdrawalBankAccountName.sendKeys(bankaccount);}

    public void Send_BankName(String bankname){edtWithdrawalBankName.sendKeys(bankname);}
    public void Send_BankBranchName(String bankbranchname){edtWithdrawalBankBranchName.sendKeys(bankbranchname);}
    public void Send_BankNotes(String banknote){edtWithdrawalBankNote.sendKeys(banknote);}

public void senInfoWithDramaBankAccount(String bankid, String bankaccount,String bankname, String bankbarnchname, String banknotes) throws Exception
{
    this.Send_BankId(bankid);
    this.Send_BankAccount(bankaccount);
    Sleep(2000);
    this.Send_BankName(bankname);
    Sleep(2000);
    this.Send_BankBranchName(bankbarnchname);
    this.Send_BankNotes(banknotes);
}


/*************************************/
}
