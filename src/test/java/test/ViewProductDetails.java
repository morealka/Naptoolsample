package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.NaptolHomePage;
import pom.ProductResultPage;

public class ViewProductDetails extends BaseTest{
	
	@BeforeMethod
	public void openApplication() {
		driver =Browser.launchApplication();
	}
	
	@Test
	public void verifyIfUserIsViewProductDetailsFromQuickView() {
	    naptolHomePage = new NaptolHomePage(driver);
	    naptolHomePage.enterProducttosearch("mixer");
	    naptolHomePage.clickonSearchButton();
	    productResultPage = new ProductResultPage(driver);
	    String productName = productResultPage.getProductTitle(1);
	    String productPrice = productResultPage.getProductPrice(1);
	    productResultPage.moveToDesiredProduct(driver, 1);
	    productResultPage.clickOnQuickView(1);
	    Assert.assertEquals(productResultPage.getProductNameOnQuickView(),productName );
	    Assert.assertEquals(productResultPage.getProductPriceOnQuickView(), productPrice);

	}
	
	@Test
	public void verifyProductOpenonNewTab() {
		    naptolHomePage = new NaptolHomePage(driver);
		    naptolHomePage.enterProducttosearch("Mixer");
		    naptolHomePage.clickonSearchButton();
		    
		    productResultPage = new ProductResultPage(driver);
		    productResultPage.clickonDesiredproduct(1);

		    String DesiredproductName = productResultPage.getProductTitle(1);
		    String DesireproductPrice = productResultPage.getProductPrice(1);
		    switchToChildBrowser();

		    System.out.println(DesiredproductName);
		    System.out.println(DesireproductPrice);
		    Assert.assertEquals(productResultPage.getDesiredProductNameonProductsPage(),DesiredproductName );
		    Assert.assertEquals(productResultPage.getDesiredProductPriceonProdcutPage(), DesireproductPrice);
		}   
		
	}



