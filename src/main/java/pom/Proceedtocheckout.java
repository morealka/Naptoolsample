package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Proceedtocheckout {
	
	@FindBy (xpath="(//a[@class='red_button2'])[1]") private WebElement proceed;
	@FindBy (xpath="//input[@id='gc-registration-basic-panel-mobile']") private WebElement mobilenumber;
	@FindBy (xpath="//input[@id='gc-registration-basic-panel-submit']") private WebElement submit;
	@FindBy (xpath="//input[@id='gc-registration-otp-panel-otp']") private WebElement naptoolotp;
	@FindBy (xpath="//input[@id='gc-registration-otp-panel-submit']") private WebElement submitbutton;


	
	public Proceedtocheckout(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public void clickonProceedtoCheckOut() {
		proceed.click();
	}
	
	public String enterMobileNumber(String number) {
		mobilenumber.sendKeys(number);
		return number;
		
	}
	public void clickonSubmitButton() {
		submit.click();
	}
	public String enterOtp(String otp) {
		naptoolotp.sendKeys(otp);
		return otp;
	}
	public void clickonSubmitButtonAfterOtp() {
		submitbutton.click();
	}
	
}
