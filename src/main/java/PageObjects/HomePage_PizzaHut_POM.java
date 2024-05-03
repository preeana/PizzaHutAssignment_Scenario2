package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage_PizzaHut_POM {

	WebDriver driver;
	
	public HomePage_PizzaHut_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//locators
	@FindBy(xpath="//div[contains(@class, 'relative')]")
	private WebElement PopUp;
	@FindBy(xpath="//input[@placeholder='Enter your location for delivery']")
	private WebElement enterLocation;
	@FindBy(className="pt-40")
	WebElement order_popup;
	@FindBy(xpath="//input[@placeholder='Enter your location for delivery']")
	private WebElement select_first_dropdown_option;
	
	//actions on locators
	
	public Boolean popupDisplayed() {
		
		Boolean popup = PopUp.isDisplayed();		
		return popup;
	}
	
	public void enterLocation(String Location) throws InterruptedException {
		
		enterLocation.sendKeys(Location);
		Thread.sleep(5000);
		enterLocation.sendKeys(Keys.ENTER);
	}
	
}




