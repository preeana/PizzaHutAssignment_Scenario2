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

public class OrderPage_PizzaHut_POM {

WebDriver driver;
	
	public OrderPage_PizzaHut_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	//locators
	@FindBy(xpath="//div[contains(@class,'basket-item-product-title')]")
	WebElement check_basket;

	@FindBy(xpath="//div[contains(@class,'basket-checkout')]")
	WebElement validate_chkamt;
	

	@FindBy(className="amountdue")
	WebElement checkout_val;
	
	@FindBy(css="span.absolute:nth-child(2) > span:nth-child(1)")
	WebElement checkout_btn;		
	
	
	public void order_sides() throws InterruptedException {
		
		String[] sides_list = {"Exotica Veggie Garlic BreadNEW"};
		List<WebElement> products= driver.findElements(By.xpath("//div[contains(@class,'list-item__name')]"));
		int j=0;
		for(int i=0;i<products.size();i++)
		{
			String prod_name=products.get(i).getText().trim();	
			List sides_ordered = Arrays.asList(sides_list);	
			if(sides_ordered.contains(prod_name))
			{
				j++;
				driver.findElements(By.xpath("//span[text()='Add']")).get(i).click();
				if(j==1)
				{
					break;
				}
			 }
		 }
	 }
	
	public void sides_added_to_basket() throws InterruptedException {
		
			String expected_sides="Exotica Veggie Garlic Bread";
			String actual_sides=check_basket.getText();
			if (expected_sides.equals(actual_sides.trim()))
			{
				System.out.println(actual_sides + " sides added");
			}
	}
	
	public void validate_total_price_count() throws InterruptedException {
		
		String total_price_count=validate_chkamt.getText();
		if(total_price_count.contains("₹"))
		{
			System.out.println("price displayed");
		}
		else
		{
			System.out.println("Since item added is below 200 no amount is displayed on checkout button");
		}
	}

	public void order_drinks() throws InterruptedException {

	String[] drinks_list = {"Pepsi - 475ml","Pepsi Zero Sugar - 300ml"};	
	List<WebElement> drinks= driver.findElements(By.xpath("//div[contains(@class,'list-item__name')]"));
	for(int i=0;i<drinks.size();i++)
	{
		String drinks_name=drinks.get(i).getText().trim();
		List drinks_ordered = Arrays.asList(drinks_list);	
		int j=0;
		if(drinks_ordered.contains(drinks_name))
		{
			j++;
			driver.findElements(By.xpath("//span[text()='Add']")).get(i).click();
			if(j==2)
			{
				break;
			}
		 }
	  }
	}

	public void validate_total_price_more_than_200(){
	
		String[] new_total_amt=checkout_val.getText().split("₹");
		Double actual_new__total_amt=Double.parseDouble(new_total_amt[1].trim());
		if(actual_new__total_amt > 200)
		{
			System.out.println(actual_new__total_amt+ " total price is now more than 200");
		}
	}

	public CheckOutPage_PizzaHut_POM Clicks_on_Checkout_button() throws InterruptedException {

	checkout_btn.click();
	return new CheckOutPage_PizzaHut_POM(driver);
	}
}


	
	
