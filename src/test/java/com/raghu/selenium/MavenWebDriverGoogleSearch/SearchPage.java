package com.raghu.selenium.MavenWebDriverGoogleSearch;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class SearchPage {
	final WebDriver driver;
/*	@FindBy(how = How.NAME, using = "login")
	private WebElement loginEdit;
	@FindBy(how = How.NAME, using = "pass")
	private WebElement passwordEdit;
*/
	
	@FindBy(how = How.NAME, using = "q")
	private WebElement searchField;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterSearchKeyWord(String keyword){
		searchField.sendKeys(keyword);
	}
	
	public void search(){
		searchField.sendKeys(Keys.ENTER);
	}
}

