package com.raghu.selenium.MavenWebDriverGoogleSearch;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class TestSuiteBase {
	protected WebDriver driver;
	protected SearchPage searchPage;

	@Parameters({ "platform","browser","version", "url" })
    @BeforeClass(alwaysRun=true)
    public void setup(String platform, String browser, String
      version, String url) throws MalformedURLException
	{
		driver = getDriverInstance(platform, browser, version, url);
		searchPage = PageFactory.initElements(driver, SearchPage.class);
    }
	
	public static WebDriver getDriverInstance(String platform, String browser, String version, String url)
			throws MalformedURLException {
		//String nodeURL = "http://192.168.1.12:5556/wd/hub";
		//String nodeURL = "http://192.168.1.12:4444/wd/hub";
		String nodeURL = "http://localhost:4444/wd/hub";
		WebDriver driver = null;
		DesiredCapabilities caps = new DesiredCapabilities();
		
		// Platforms
		if (platform.equalsIgnoreCase("Windows")) {
			caps.setPlatform(Platform.WINDOWS);
		}
		if (platform.equalsIgnoreCase("MAC")) {
			caps.setPlatform(Platform.MAC);
		}
		// Browsers
		if (browser.equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
		}
		// Version
		caps.setVersion(version);
		driver = new RemoteWebDriver(new URL(nodeURL), caps);
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Open the Application
		driver.get(url);
		return driver;
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}