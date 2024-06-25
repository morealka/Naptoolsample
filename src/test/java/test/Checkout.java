package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.AddtocartPage;
import pom.NaptolHomePage;
import pom.Proceedtocheckout;
import pom.ProductResultPage;
import pom.Shippingaddress;

public class Checkout extends BaseTest {
	
	
	@BeforeMethod
	public void openApplication() {
		driver=Browser.launchApplication();
	}
		@Test
		
		public void verifyProceedToCheckout() throws InterruptedException {
			naptolHomePage=new NaptolHomePage(driver);
			naptolHomePage.enterProducttosearch("Mixer");
			naptolHomePage.clickonSearchButton();
			
			productResultPage=new ProductResultPage(driver);   
			productResultPage.moveToDesiredProduct(driver, 0);
			productResultPage.clickOnQuickView(0);
			
		    addtocart=new AddtocartPage(driver);
			addtocart.clickheretobuy();
			proceedtocheckout =new Proceedtocheckout(driver);
			proceedtocheckout.clickonProceedtoCheckOut();
			proceedtocheckout.enterMobileNumber("8983850079");
			proceedtocheckout.clickonSubmitButton();
			proceedtocheckout.enterOtp("");
			Thread.sleep(60000);
			proceedtocheckout.clickonSubmitButtonAfterOtp();
			Shippingaddress shippingadd=new Shippingaddress(driver);
			shippingadd.selectTitle();
			shippingadd.enterFirstname("Alka");
			shippingadd.enterLastname("More");
			shippingadd.enterAddress("ABC Nagar");
			shippingadd.enterLandMark("DMART");
			shippingadd.enterPincode("443001");
			shippingadd.selectState();
			shippingadd.selectCity();
			shippingadd.enterMobileNoinShippingAddrees("8983850079");
			shippingadd.enterLandLine("12345");
		}		
}
			
	