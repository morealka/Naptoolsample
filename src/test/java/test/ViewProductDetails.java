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
import pom.ProductResultPage;
import utility.Reports;

@Listeners(test.Listeners.class)
public class ViewProductDetails extends BaseTest {

	@BeforeTest
	public void configureReporting() {
		reports = Reports.configureReports();
	}

	@BeforeMethod
	public void openApplication() {
		driver = Browser.launchApplication();
	}

	@Test
	public void verifyIfUserAbleToViewProductDetailsFromQuickView() {
		test = reports.createTest("verifyIfUserAbleToViewProductDetailsFromQuickView");
		naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProducttoSearch("mixer");
		naptolHomePage.clickonSearchButton();
		productResultPage = new ProductResultPage(driver);
		String productName = productResultPage.getProductTitle(1);
		String productPrice = productResultPage.getProductPrice(1);
		productResultPage.moveToDesiredProduct(driver, 1);
		productResultPage.clickOnQuickView(1);
		Assert.assertEquals(productResultPage.getProductName(), productName);
		Assert.assertEquals(productResultPage.getProductPrice(1), productPrice);

	}

	@Test
	public void verifyProductOpenonNewPage() {
		test = reports.createTest("verifyProductOpenonNewPage");
		naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProducttoSearch("Mixer");
		naptolHomePage.clickonSearchButton();

		productResultPage = new ProductResultPage(driver);
		productResultPage.clickonDesiredproduct(1);

		String productName = productResultPage.getProductTitle(1);
		String productPrice = productResultPage.getProductPrice(1);
		switchToChildBrowser();

		System.out.println(productName);
		System.out.println(productPrice);
		Assert.assertEquals(productResultPage.getProductName(), productName);
		Assert.assertEquals(productResultPage.getProductPrice(2), productPrice);
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
