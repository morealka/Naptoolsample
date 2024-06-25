package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaptolHomePage {
	
	@FindBy (xpath="//a[@id='login-panel-link']") private WebElement loginorRegister;
	@FindBy (xpath="//a[text()='Track Order']") private WebElement trackorder;
	@FindBy (xpath="//div[@class='cate_head']") private WebElement shoppingCategories;
	@FindBy (xpath="//input[@id='header_search_text']") private WebElement searchField;
	@FindBy (xpath="(//div[@class=\"search\"]//a)[2]") private WebElement search;
	@FindBy (xpath="(//a[@id='cart-panel-link'])[2]") private WebElement cart;
	@FindBy (xpath="//div[@id='mainMenuContent']//ul//li[1]//a//span") private WebElement listItem;
	@FindBy (xpath="//div[@class='grid_Square ']") private List<WebElement> productList;
	@FindBy (xpath="//section[@id='registerSignBox']") private WebElement Popup;
	@FindBy (xpath="//p[@class='staticDisc']") private WebElement trackoderpage;
	@FindBy (xpath="(//div[@id='mainMenuContent']//nav//ul//li)[4]") private WebElement listofItem;



	
	
	public NaptolHomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);	
		}
	public void clickonLoginorRegister() {
		loginorRegister.click();
	}
	
	public void clickonTrackorder() {
		trackorder.click();
	}
	public boolean TrackorderPageisDisplayed() {
		return trackoderpage.isDisplayed();
	}
	
	public void viewshoppingcategories(WebDriver driver) {
		Actions actions=new Actions(driver);
		actions.moveToElement(shoppingCategories);
		actions.perform();
	}
	public boolean ListItemDisplayed() {
		return listofItem.isDisplayed();
	}
	
	public void enterProducttosearch(String product) {
		 searchField.sendKeys(product);
	}
	
	public void clickonSearchButton() {
		search.click();
	}
	public void ClearProduct(String product) {
		 searchField.clear();
	}
	
	public void clickOnCart() {
		cart.click();
	}
	
	public boolean itemDisplayed() {
		return listItem.isDisplayed();
	}
	
	public int getNumberofProductDisplayed() {
		return productList.size();
	}
	public boolean PopupisDisplayed() {
		return Popup.isDisplayed();
	}
	}
	


