package com.raghu.selenium.MavenWebDriverGoogleSearch;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class WhenSearchingForDrupalUsingGoogleTest extends TestSuiteBase {
	private String baseUrl;
	private WebDriver driver;
	private String nodeURL;

	// @BeforeClass(alwaysRun=true)
	// public void openBrowser() throws MalformedURLException {
	// baseUrl = "http://www.google.com";
	//// // nodeURL = "http://192.168.1.12:5555/wd/hub";
	///// * DesiredCapabilities caps = DesiredCapabilities.firefox();
	//// caps.setBrowserName("firefox"); */
	//// DesiredCapabilities caps = DesiredCapabilities.chrome();
	//// caps.setBrowserName("chrome");
	//// caps.setPlatform(Platform.WINDOWS);
	//// driver = new RemoteWebDriver(new URL(nodeURL), caps);
	//// driver.manage().window().maximize();
	//// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//// driver.get(baseUrl);
	// }

	@AfterClass
	public void saveScreenshotAndCloseBrowser() throws IOException {
		// driver.quit();
	}

	@Test
	public void pageTitleAfterSearchShouldBeginWithDrupal()
			throws IOException, InterruptedException {
		// SearchPage searchPage = PageFactory.initElements(driver,
		// SearchPage.class);
		searchPage.enterSearchKeyWord("Drupal!");
		searchPage.search();
		/*
		 * (new WebDriverWait(driver, 10)).until(new
		 * ExpectedCondition<Boolean>() { public Boolean apply(WebDriver d) {
		 * return d.getTitle().toLowerCase().startsWith("drupal!"); } });
		 */
		Thread.sleep(5000);

		// System.out.println("Page title is: " + driver.getTitle());
	}
}
