package PageObjects;


import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.util.Assert;

public class CheckOutPage_PizzaHut_POM {

WebDriver driver;
	
	public CheckOutPage_PizzaHut_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//locators
	
	@FindBy(id="checkout__name")
	WebElement name;
	@FindBy(id="checkout__phone")
	WebElement mobile;
	@FindBy(id="checkout__email")
	WebElement email;
	@FindBy(id="checkout__deliveryAddress.interior")
	WebElement addr;
	
	@FindBy(className="mt-4")
	WebElement online_payment_radiobtn;
	
	@FindBy(css="label.flex:nth-child(2) > i:nth-child(2)")
	WebElement cash_payment_radiobtn;

	@FindBy(id="marketingOptIn")
	WebElement Iagree_chkbox;
	
	
	@FindBy(xpath="//div[contains(@class,'sc-fzqMdD')]")
	WebElement apply_coupon;
	
	@FindBy(xpath="//div[contains(@class,'sc-fzoant')]")
	WebElement apply_coupon_popup;
	@FindBy(xpath="//div[contains(@class,'sc-fznMnq')]")
	WebElement Couponbtn;

	@FindBy(name="voucherId")
	WebElement Coupon_code;
	@FindBy(css="[type='submit']")
	WebElement Apply_btn;
	
	@FindBy(css=".sc-fznJRM")
	WebElement err_msg;

	@FindBy(css=".icon-remove-3")
	WebElement close_popup;
	

	public void checkout_details(String Name,String mobileNo,String emailid,String address) throws InterruptedException {

		name.sendKeys(Name);
		mobile.sendKeys(mobileNo);
		email.sendKeys(emailid);
		addr.sendKeys(address);
	}
	
	public void validate_online_payment_radiobtn() {
		
		if(online_payment_radiobtn.isEnabled())
		{
			System.out.println("Online payment method is selected by default");
		}
	}
	
	public void click_on_cash_payment_radiobtn(){
		
		cash_payment_radiobtn.click();
	}
	
	public void validate_Iagree_checkbox() {
		
		if(Iagree_chkbox.isSelected())
		{
			System.out.println("I agree checkbox is selected by default");
		}
	}
	
	public void click_on_ApplyGiftCard_link() throws InterruptedException {
		
		apply_coupon.click();
	}
	
	public void validate_voucher_popup() throws InterruptedException {
		
		apply_coupon_popup.isDisplayed();
		System.out.println("Voucher popup displayed");
		Couponbtn.click();
		
	}
	
	public void enter_voucher_code(String VoucherCode) throws InterruptedException {
		
		Coupon_code.sendKeys(VoucherCode);
		Apply_btn.click();
	}
	
	public void validate_Error_msg() {
		
		String ExpectedText = "Sorry, we don’t currently support that coupon code.";
		String ActualText=	err_msg.getText();
		if(ExpectedText.equals(ActualText))
		{
			System.out.println("Following error msg displayed "+ActualText);
		}
	}
	
	public void close_voucher_popup() throws InterruptedException {
		
		close_popup.click();
		System.out.println(driver.getCurrentUrl());
		String deal_url =driver.getCurrentUrl();
    	if(deal_url.contains("deals")) 
    	{
    		System.out.println("Navigated back to Deals Page.");
    	}
		
	}
	
	
}




