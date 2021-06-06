package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static utils.PropertiesUtil.getProperty;

public class AODocsHomePage {

	private static final Logger logger = LoggerFactory.getLogger(AODocsHomePage.class);

	private WebDriver driver;

	@FindBy(xpath = "//a[contains(@href, 'request_demo')]")
	private WebElement requestDemo;

	public AODocsHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AODocsRequestDemoPage requestDemo() {
		logger.info("Navigating to Request Demo page");
		requestDemo.click();
		return new AODocsRequestDemoPage(driver);
	}

	public void openPageFromGoogleSearch() {
		GooglePage googlePage = new GooglePage(driver);
		googlePage.openPage();
		googlePage.searchAndOpenResult(getProperty("aodocsQuery"), getProperty("aodocsUrl"));
	}
}
