package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static utils.PropertiesUtil.getProperty;

public class GooglePage {

	private static final Logger logger = LoggerFactory.getLogger(GooglePage.class);

	private WebDriver driver;

	@FindBy(name = "q")
	private WebElement searchInput;

	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void openPage() {
		logger.info("Opening Google Page " + getProperty("googleUrl"));
		driver.get(getProperty("googleUrl"));
	}

	public void googleSearch(String query) {
		logger.info("Google search for " + query);
		searchInput.sendKeys(query);
		searchInput.submit();
	}

	public void openSearchResult(String page) {
		logger.info("Opening search result page " + page);
		String pageXpath = "//a[@href='" + page + "']";
		WebElement result = driver.findElement(By.xpath(pageXpath));
		result.click();
	}

	public void searchAndOpenResult(String query, String page) {
		googleSearch(query);
		openSearchResult(page);
	}
}
