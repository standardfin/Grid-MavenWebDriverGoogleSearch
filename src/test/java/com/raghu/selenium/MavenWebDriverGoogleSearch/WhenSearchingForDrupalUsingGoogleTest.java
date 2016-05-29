package com.raghu.selenium.MavenWebDriverGoogleSearch;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */
public class WhenSearchingForDrupalUsingGoogleTest extends TestSuiteBase
{
	  private String baseUrl;
	  private WebDriver driver;
	  private String nodeURL;

	  
	  
//	  @BeforeClass(alwaysRun=true)
//	  public void openBrowser() throws MalformedURLException {
//		    baseUrl = "http://www.google.com";
////		   // nodeURL = "http://192.168.1.12:5555/wd/hub";
/////*		    DesiredCapabilities caps = DesiredCapabilities.firefox();
////		    caps.setBrowserName("firefox");	*/	    
////		    DesiredCapabilities caps = DesiredCapabilities.chrome();
////		    caps.setBrowserName("chrome");
////		    caps.setPlatform(Platform.WINDOWS);
////		    driver = new RemoteWebDriver(new URL(nodeURL), caps);
////		    driver.manage().window().maximize();
////		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////		    driver.get(baseUrl);
//	  }
	  
	  @AfterClass
	public void saveScreenshotAndCloseBrowser() throws IOException {
	    //driver.quit();
	  }
	  
	@Test
	  public void pageTitleAfterSearchShouldBeginWithDrupal() throws IOException, InterruptedException {
		//SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
		searchPage.enterSearchKeyWord("Drupal!");
		searchPage.search();
		/*(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver d) {
	          return d.getTitle().toLowerCase().startsWith("drupal!");
	        }
	      });*/
		Thread.sleep(5000);
		
		//System.out.println("Page title is: " + driver.getTitle());
	  }
}
