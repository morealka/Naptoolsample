package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.AddtocartPage;
import pom.NaptolHomePage;
import pom.ProductResultPage;

public class CartTest extends BaseTest {
	
	@BeforeMethod
	public void openApplication() {
		driver=Browser.launchApplication();
	}
		@Test
		
		public void verifyAddTocartByAddingProductfromQickView() {
			naptolHomePage=new NaptolHomePage(driver);
			naptolHomePage.enterProducttosearch("Mixer");
			naptolHomePage.clickonSearchButton();
			
			productResultPage=new ProductResultPage(driver);   //for Qick View
			productResultPage.moveToDesiredProduct(driver, 0);
			productResultPage.clickOnQuickView(0);
			
		    addtocart=new AddtocartPage(driver);
			addtocart.clickheretobuy();
			addtocart.clcikoncontinueshopping();
			naptolHomePage.EnterProducttosearch(null);
			
			naptolHomePage.enterProducttosearch("cooker");
			naptolHomePage.clickonSearchButton();
			
			productResultPage.moveToDesiredProduct(driver, 0);
			productResultPage.clickOnQuickView(0);
			addtocart.clickheretobuy();
			
			String ExpectedName = addtocart.getProductNameinCart(0);
			double ExpectedPrice= addtocart.getProductPrice(1);
			double ExpectedShippingPrice= addtocart.getProductShippingPrice(1);
			System.out.println(ExpectedName+" "+ExpectedPrice+" "+ExpectedShippingPrice);
			
			Assert.assertEquals(addtocart.getNumberofProductsInCart(), 2);
			Assert.assertEquals(addtocart.getProductNameinCart(0), ExpectedName);
			Assert.assertEquals(addtocart.getProductPrice(1), ExpectedPrice);
			Assert.assertEquals(addtocart.getProductShippingPrice(1), ExpectedShippingPrice);
		}
		
		@Test
		
		public void verifyAddTocartByAddingProductbyClickonProduct()  {
			naptolHomePage =new NaptolHomePage(driver);
			naptolHomePage.enterProducttosearch("Mixer");
			naptolHomePage.clickonSearchButton();

			productResultPage = new ProductResultPage(driver);
			productResultPage.selectDesiredProduct(0);

			switchToChildBrowser();

			addtocart =new AddtocartPage(driver);
			addtocart.clickheretobuy();
			addtocart.clcikoncontinueshopping();
			
			naptolHomePage.enterProducttosearch("cooker");
			naptolHomePage.clickonSearchButton();
			productResultPage = new ProductResultPage(driver);
			productResultPage.selectDesiredProduct(0);
			switchToChildBrowser();

			addtocart.clickheretobuy();
			String ExpectedName = addtocart.getProductNameinCart(1);
			double ExpectedPrice = addtocart.getProductPrice(2);
			double ExpectedShippingPrice = addtocart.getProductShippingPrice(2);
			System.out.println(ExpectedName+" "+ExpectedPrice+" "+ExpectedShippingPrice);

            Assert.assertEquals(addtocart.getNumberofProductsInCart(), 2);
            Assert.assertEquals(addtocart.getProductNameinCart(1), ExpectedName);
			Assert.assertEquals(addtocart.getProductPrice(2), ExpectedPrice);
			Assert.assertEquals(addtocart.getProductShippingPrice(2), ExpectedShippingPrice);
		}
		@Test
		
		public void VerifyRemoveFunctionalityfromCart() throws InterruptedException {
		
		naptolHomePage=new NaptolHomePage(driver);
		naptolHomePage.enterProducttosearch("Mixer");
		naptolHomePage.clickonSearchButton();
		productResultPage=new ProductResultPage(driver);
		productResultPage.moveToDesiredProduct(driver, 0);
		productResultPage.clickOnQuickView(0);
		
		AddtocartPage addtocart=new AddtocartPage(driver);
		addtocart.clickheretobuy();
		
		addtocart.RemoveProductfromCart();
		
		Thread.sleep(2000);
		Assert.assertEquals(addtocart.getNumberofProductsInCart(), 0);
		
			
		}
		@Test
		
		public void verifyOrderAmount() {
			naptolHomePage =new NaptolHomePage(driver);
			naptolHomePage.enterProducttosearch("Mixer");
			naptolHomePage.clickonSearchButton();

			productResultPage = new ProductResultPage(driver);
			productResultPage.selectDesiredProduct(0);

			switchToChildBrowser();

		    addtocart=new AddtocartPage(driver);
			addtocart.clickheretobuy();
			double amount=addtocart.getProductOrderAmount(1);
			double price=addtocart.getProductPrice(1);
			double shprice=addtocart.getProductShippingPrice(1);
			System.out.println(amount+""+(price+shprice));
			
			Assert.assertEquals(addtocart.getProductOrderAmount(1), (addtocart.getProductPrice(1)+addtocart.getProductShippingPrice(1)));
		}
		

}
