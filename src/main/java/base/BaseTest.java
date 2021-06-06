package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import selenium.driver.Browser;
import selenium.driver.WebDriverUtility;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static utils.PropertiesUtil.getProperty;

@TestInstance(PER_CLASS)
public class BaseTest {

	protected WebDriver driver;
	protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

	@BeforeEach
	public void setup() {
		driver = WebDriverUtility.getWebDriver(Browser.valueOf(getProperty("driver")));
	}

	@AfterEach
	public void cleanup() {
		WebDriverUtility.closeWebDriver(driver);
	}
}
