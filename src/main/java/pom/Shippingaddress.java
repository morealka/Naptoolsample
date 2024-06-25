package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Shippingaddress {
	
	@FindBy (xpath="//select[@name='fktitle_id']") private WebElement titLe;
	@FindBy (xpath="//input[@id='firstName']") private WebElement firstname;
	@FindBy (xpath="//input[@id='lastName']") private WebElement lastname;
	@FindBy (xpath="//textarea[@id='address']") private WebElement address;
	@FindBy (xpath="//input[@name='landmark']") private WebElement landmark;
	@FindBy (xpath="//input[@id='pincode']") private WebElement pincode;
	@FindBy  (xpath="//select[@id='state']") private WebElement state;
	@FindBy  (xpath="//select[@id='city']") private WebElement city;
	@FindBy  (xpath="//input[@id='mobile']") private WebElement mobilenoinaddress;
	@FindBy  (xpath="//input[@id='landline']") private WebElement landline;
	@FindBy  (xpath="//a[@class='button_2']") private WebElement shiptothisadress;
	public Shippingaddress(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void selectTitle() {
		Select se=new Select(titLe);
		se.selectByIndex(3);
	}
	public void enterFirstname(String name) {
		firstname.sendKeys(name);
	}
	 public void enterLastname(String Name) {
		 lastname.sendKeys(Name);
	 }
	 
	 public void enterAddress(String add) {
		 address.sendKeys(add);
	 }
	 public void enterLandMark(String mark) {
		 landmark.sendKeys(mark);
	 }
	 public void enterPincode(String Pin) {
		 pincode.sendKeys(Pin);
	 }
	 
	 public void selectState() {
		 state.click();
		 Select select=new Select(state);
		 select.selectByVisibleText("MAHARASHTRA");
	 }
	 
	 public void selectCity() {
		 city.click();
		 Select select=new Select(city);
		 select.selectByVisibleText("BULDANA");
	 }
	 
	 public void enterMobileNoinShippingAddrees(String no) {
		 mobilenoinaddress.sendKeys(no);
	 }
	 
	 public void enterLandLine(String Landline) {
		 landline.sendKeys(Landline);
	}
			
	 public void ClickonshipptothisAddress() {
		 shiptothisadress.click();
				 
	 }




	




	


}
