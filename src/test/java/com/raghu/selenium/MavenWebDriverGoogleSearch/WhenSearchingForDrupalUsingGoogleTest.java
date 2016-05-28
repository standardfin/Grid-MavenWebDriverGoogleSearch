package com.raghu.selenium.MavenWebDriverGoogleSearch;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */
public class WhenSearchingForDrupalUsingGoogleTest  
{
	  private String baseUrl;
	  private WebDriver driver;
	  private ScreenshotHelper screenshotHelper;
	  private String nodeURL;

	  
	  @BeforeClass
	  public void openBrowser() throws MalformedURLException {
		    baseUrl = "http://www.google.com";
		    nodeURL = "http://192.168.1.12:5555/wd/hub";
		    DesiredCapabilities caps = DesiredCapabilities.firefox();
		    caps.setBrowserName("firefox");
		    caps.setPlatform(Platform.WINDOWS);
		    System.setProperty("webdriver.chrome.driver", "src\\resources\\chromedriver.exe");
		    //driver = new ChromeDriver();
		    driver = new RemoteWebDriver(new URL(nodeURL), caps);
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.get(baseUrl);
		    screenshotHelper = new ScreenshotHelper();
	  }
	  
	  @AfterMethod
	public void saveScreenshotAndCloseBrowser() throws IOException {
	    screenshotHelper.saveScreenshot("screenshot.png");
	    driver.quit();
	  }
	  
	  @SuppressWarnings("deprecation")
	@Test
	  public void pageTitleAfterSearchShouldBeginWithDrupal() throws IOException {
		SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
		searchPage.enterSearchKeyWord("Drupal!");
		searchPage.search();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver d) {
	          return d.getTitle().toLowerCase().startsWith("drupal!");
	        }
	      });
		
		System.out.println("Page title is: " + driver.getTitle());
	  }
	  
	  private class ScreenshotHelper {
	    public void saveScreenshot(String screenshotFileName) throws IOException {
	      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	      FileUtils.copyFile(screenshot, new File(screenshotFileName));
	    }
	  }
}
