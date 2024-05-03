package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DetailPage_PizzaHut_POM {

WebDriver driver;
	
	public DetailPage_PizzaHut_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//locators

	@FindBy(linkText="Sides")
	private WebElement Sides_menu_bar;

	@FindBy(linkText="Drinks")
	WebElement drinks_menu;
	
	//action on locators
	public void validate_user_in_deal_page() throws InterruptedException {
		Thread.sleep(5000);
		String deal_url =driver.getCurrentUrl();
    	if(deal_url.contains("deals")) 
    	{
    		System.out.println("url contains deals");
    	}
	}
	
	public OrderPage_PizzaHut_POM clicks_on_Sides_menu_bar_option() {
		Sides_menu_bar.click();
		return new OrderPage_PizzaHut_POM(driver);
	}
	
	public OrderPage_PizzaHut_POM click_drink_menu_bar_option() throws InterruptedException {
		drinks_menu.click();
		return new OrderPage_PizzaHut_POM(driver);
	}
	
}