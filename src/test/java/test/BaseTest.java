package test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import pom.Proceedtocheckout;
import pom.AddtocartPage;
import pom.NaptolHomePage;
import pom.ProductResultPage;

public class BaseTest {
	
	public static WebDriver driver;
	public NaptolHomePage naptolHomePage;
	public ProductResultPage productResultPage;
	public AddtocartPage addtocart;
    public Proceedtocheckout proceedtocheckout;
	
	public void switchToChildBrowser() {
		
		Set<String> handles =driver.getWindowHandles();
		Iterator<String> i=handles.iterator();
		
		 while(i.hasNext())
		   {
		   	driver.switchTo().window(i.next());
		   	
		    }
		

		
	}
		
	}


