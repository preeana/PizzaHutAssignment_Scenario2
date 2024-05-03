package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.CheckOutPage_PizzaHut_POM;
import PageObjects.DetailPage_PizzaHut_POM;
import PageObjects.HomePage_PizzaHut_POM;
import PageObjects.OrderPage_PizzaHut_POM;
import base.Base;


public class HomePage_PizzaHut_test extends Base{
	    public WebDriver driver;
	    
	    @BeforeMethod
	    public void setup() throws IOException, InterruptedException {
	   	 
	   	 driver = initializeBrowser();
	   	 driver = launchPizzaHut();
	   	}
	       
	    @AfterMethod
	    public void tearDown() {
	   	 
	   	 driver.quit();
	    }
	    
	    @Test(priority=1)
	    public void purchaseOrder() throws InterruptedException {
	    	HomePage_PizzaHut_POM hp = new HomePage_PizzaHut_POM(driver);
	    	
	    	Boolean popup = hp.popupDisplayed();
	    	Assert.assertTrue(true);
	    	
	    	String Location = prop.getProperty("Location");
	    	hp.enterLocation(Location);
	    	
 	
	    	// handling dynamic popup which appears on specific time duration
	    	
	    	try {
				   driver.findElement(By.className("pt-40")).click();
				   System.out.println("Dynamic Pop-up appeared");
				} catch (NoSuchElementException e) {
					System.out.println("Dynamic Pop-up didnot appeare");
				}
	    	
	    	DetailPage_PizzaHut_POM dp = new DetailPage_PizzaHut_POM(driver);
	    	dp.validate_user_in_deal_page();
	    	dp.clicks_on_Sides_menu_bar_option();
	    	
	    	OrderPage_PizzaHut_POM op = new OrderPage_PizzaHut_POM(driver);
	    	op.order_sides();
	    	op.sides_added_to_basket();
	    	op.validate_total_price_count();
	    	
	    
	    	dp.click_drink_menu_bar_option();
	    	op.order_drinks();
	    	op.validate_total_price_more_than_200();
	    	op.Clicks_on_Checkout_button();
	    	
	    	CheckOutPage_PizzaHut_POM cp= new CheckOutPage_PizzaHut_POM(driver);
	    	
	    	String Name=prop.getProperty("name");
	    	String mobileNo=prop.getProperty("mobile");
	    	String emailid=prop.getProperty("email");
	    	String address=prop.getProperty("addr");
	    	cp.checkout_details(Name,mobileNo,emailid,address);
	    	
	    	cp.validate_online_payment_radiobtn();
	    	cp.click_on_cash_payment_radiobtn();
	    	cp.validate_Iagree_checkbox();
	   
	    	cp.click_on_ApplyGiftCard_link();
	    	cp.validate_voucher_popup();

	    	String VoucherCode=prop.getProperty("VoucherCode");
	    	cp.enter_voucher_code(VoucherCode);
	    	cp.validate_Error_msg();
	    	cp.close_voucher_popup();
	    }  
	    
	    
}

