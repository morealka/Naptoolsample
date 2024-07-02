package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.NaptolHomePage;
import utility.Reports;

@Listeners(test.Listeners.class)

public class ProductSearchTest extends BaseTest {

	@BeforeTest
	public void configureReporting() {
		reports = Reports.configureReports();
	}

	@BeforeMethod
	public void openApplication() {
		driver = Browser.launchApplication();
	}

	@Test
	public void verifyIfuserabletoSearchProduct() {
		test = reports.createTest("verifyIfuserabletoSearchProduct");
		naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProducttoSearch("Mixer");
		naptolHomePage.clickonSearchButton();
		Assert.assertTrue(driver.getTitle().contains("Mixer"));
		Assert.assertTrue(naptolHomePage.getNumberofProductDisplayed() > 0);
	}

	@Test
	public void verifyAfterclickonLoginPopupShouldDisplay() {
		test = reports.createTest("verifyAfterclickonLoginPopupShouldDisplay");
		naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.clickonLoginorRegister();
		Assert.assertTrue(naptolHomePage.popupisDisplayed());

	}

	@Test
	public void verifyAfterclickonTrackOrderpageshouldBeREDIRECT() {
		test = reports.createTest("verifyAfterclickonTrackOrderpageshouldBeREDIRECT");
		naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.clickonTrackorder();
		Assert.assertTrue(naptolHomePage.trackorderPageisDisplayed());
	}

	@Test
	public void verifyShoppingCategoriesShouldDisplay() {
		test = reports.createTest("verifyShoppingCategoriesShouldDisplay");
		naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.viewShoppingCategories(driver);
		Assert.assertTrue(naptolHomePage.listItemDisplayed());

	}

	@AfterMethod
	public void addReportStatus(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
		} else {
			test.log(Status.SKIP, result.getName());
		}
	}

	@AfterTest
	public void publishReport() {
		reports.flush();

	}

}
