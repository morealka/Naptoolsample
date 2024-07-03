package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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
import pom.AddtocartPage;
import pom.NaptolHomePage;
import pom.Proceedtocheckout;
import pom.ProductResultPage;
import pom.Shippingaddress;
import utility.Reports;

@Listeners(test.Listeners.class)
public class Checkout extends BaseTest {

	@BeforeTest
	public void configureReporting() {
		reports = Reports.configureReports();
	}

	@BeforeMethod
	public void openApplication() {
		driver = Browser.launchApplication();
	}

	@Test
	public void verifyProceedToCheckout() throws InterruptedException, EncryptedDocumentException, IOException {
		test = reports.createTest("verifyProceedToCheckout");
		naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProducttoSearch("cooker");
		naptolHomePage.clickonSearchButton();

		productResultPage = new ProductResultPage(driver);
		productResultPage.moveToDesiredProduct(driver, 0);
		productResultPage.clickOnQuickView(0);

		addtoCart = new AddtocartPage(driver);
		addtoCart.clickHeretoBuy();
		proceedToCheckout = new Proceedtocheckout(driver);
		proceedToCheckout.clickonProceedtoCheckOut();
		proceedToCheckout.enterMobileNumber("8983850079");
		proceedToCheckout.clickonContinueButton();
		proceedToCheckout.enterOtp("");
		Thread.sleep(20000);
		proceedToCheckout.clickonSubmitButtonAfterOtp();
		Shippingaddress shippingadd = new Shippingaddress(driver);
		shippingadd.selectTitle();
		shippingadd.enterFirstName();
		shippingadd.enterLastName();
		shippingadd.enterAddress();
		shippingadd.enterLandMark();
		shippingadd.enterPincode();
		shippingadd.selectState();
		shippingadd.selectCity();
		shippingadd.enterMobileNoinShippingAddrees();
		shippingadd.enterLandLine();
		shippingadd.clickOnShipptothisAddress();

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	@AfterTest
	public void publishReport() {
		reports.flush();

	}

}
