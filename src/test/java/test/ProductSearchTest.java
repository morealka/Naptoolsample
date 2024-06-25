package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.NaptolHomePage;

public class ProductSearchTest extends BaseTest{
	
	@BeforeMethod
	public void openApplication() {
		driver=Browser.launchApplication();
	}
		@Test
		public void verifyIfuserabletoSearchProduct() {
			naptolHomePage=new NaptolHomePage(driver);
			naptolHomePage.enterProducttosearch("Mixer");
			naptolHomePage.clickonSearchButton();
			Assert.assertTrue(driver.getTitle().contains("Mixer"));
			Assert.assertTrue(naptolHomePage.getNumberofProductDisplayed()>0);
		}
		
		@Test
		public void VerifyafterclickonLoginPopupShouldDisplay() {
			naptolHomePage=new NaptolHomePage(driver);
			naptolHomePage.clickonLoginorRegister();
			Assert.assertTrue(naptolHomePage.PopupisDisplayed());

		}
		@Test
		public void VerifyafterclickonTrackOrderpageshouldBeREDIRECT() {
		    naptolHomePage=new NaptolHomePage(driver);
			naptolHomePage.clickonTrackorder();
			Assert.assertTrue(naptolHomePage.TrackorderPageisDisplayed());
			}
		
		@Test
		public void VerifyshoppingCategoriesShouldDisplay() {
		    naptolHomePage=new NaptolHomePage(driver);
			naptolHomePage.viewshoppingcategories(driver);
			Assert.assertTrue(naptolHomePage.ListItemDisplayed());

		}
		
}
