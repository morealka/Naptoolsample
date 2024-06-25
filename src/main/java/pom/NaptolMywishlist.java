package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaptolMywishlist {
	
	@FindBy (xpath="//a[text()='My Account']") private WebElement myaccount;
	@FindBy (xpath="//a[text()='My Wish List']") private WebElement mywishlist;
	@FindBy (xpath="(//ul[@class='orderData box effect1 clearfix'])[2]") private WebElement wishlistProduct;
	@FindBy (xpath="//input[@id='pincodeDeliveryId_0']") private WebElement checkpincode;
	@FindBy (xpath="(//a[@class='button_1'])[1]") private WebElement click;
	
	public void naptolwishlist(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void clickonMyaccount() {
		myaccount.click();
	}
	public void ClickonMywishlist() {
		mywishlist.click();
	}
	public void WishListProduct() {
		wishlistProduct.isDisplayed();
	}


}
