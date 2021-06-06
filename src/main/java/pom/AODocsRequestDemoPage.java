package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.openqa.selenium.By.xpath;

public class AODocsRequestDemoPage {

	private static final Logger logger = LoggerFactory.getLogger(AODocsRequestDemoPage.class);

	private WebDriver driver;

	@FindBy(name = "firstname")
	private WebElement firstName;

	private By firstNameLabel = xpath("//div[contains(@data-reactid, 'firstname')]/ul/li/label");

	@FindBy(name = "lastname")
	private WebElement lastName;

	private By lastNameLabel = xpath("//div[contains(@data-reactid, 'lastname')]/ul/li/label");

	@FindBy(name = "email")
	private WebElement email;

	private By emailLabel = xpath("//div[contains(@data-reactid, 'email')]/ul/li/label");

	@FindBy(name = "phone")
	private WebElement phoneNumber;

	private By phoneLabel = xpath("//div[contains(@data-reactid, 'phone')]/ul/li/label");

	@FindBy(name = "company")
	private WebElement companyName;

	private By companyNameLabel = xpath("//div[contains(@data-reactid, 'company')]/ul/li/label");

	private Select companySize;

	private By companySizeLabel = xpath("//div[contains(@data-reactid, 'company_size__c')]/ul/li/label");

	@FindBy(name = "country")
	private Select country;

	private By countryLabel = xpath("//div[contains(@data-reactid, 'country')]/ul/li/label");

	private Select requestType;

	private By requestTypeLabel = xpath("//div[contains(@data-reactid, 'request_type')]/ul/li/label");

	@FindBy(name = "your_request__c")
	private WebElement message;

	private By messageLabel = xpath("//div[contains(@data-reactid, 'your_request__c')]/ul/li/label");

	@FindBy(name = "how_did_you_hear_about_us_")
	private WebElement hearAboutUs;

	private By hearAboutUsLabel = xpath("//div[contains(@data-reactid, 'how_did_you_hear_about_us_')]/ul/li/label");

	private By allFieldsError = xpath("//div[@class='hs_error_rollup']");

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitButton;

	public AODocsRequestDemoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		companySize = new Select(driver.findElement(By.name("company_size__c")));
		requestType = new Select(driver.findElement(By.name("request_type")));
	}

	public void submitForm(String firstName, String lastName, String email, CompanySize companySize) {
		logger.info("Submitting form: firstName:{} lastName:{} email:{} companySize:{}",
				firstName, lastName, email, companySize.getValue());
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.email.sendKeys(email);
		selectCompanySize(companySize);
		submitButton.submit();
	}

	private void selectCompanySize(CompanySize size) {
		companySize.selectByVisibleText(size.getValue());
	}

	public boolean existsSubmitFormError() {
		return isElementPresent(allFieldsError);
	}

	public boolean existsFirstNameLabel() {
		return isElementPresent(firstNameLabel);
	}

	public boolean existsLastNameLabel() {
		return isElementPresent(lastNameLabel);
	}

	public boolean existsEmailLabel() {
		return isElementPresent(emailLabel);
	}

	public boolean existsPhoneLabel() {
		return isElementPresent(phoneLabel);
	}

	public boolean existsCompanyNameLabel() {
		return isElementPresent(companyNameLabel);
	}

	public boolean existsCompanySizeLabel() {
		return isElementPresent(companySizeLabel);
	}

	public boolean existsCountryLabel() {
		return isElementPresent(countryLabel);
	}

	public boolean existsRequestTypeLabel() {
		return isElementPresent(requestTypeLabel);
	}

	public boolean existsMessageLabel() {
		return isElementPresent(messageLabel);
	}

	public boolean existsHearAboutUsLabel() {
		return isElementPresent(hearAboutUsLabel);
	}

	private boolean isElementPresent(By element) {
		return !driver.findElements(element).isEmpty();
	}

	public String getFirstNameLabel() {
		return getText(firstNameLabel);
	}

	public String getLastNameLabel() {
		return getText(lastNameLabel);
	}

	public String getEmailLabel() {
		return getText(emailLabel);
	}

	public String getPhoneLabel() {
		return getText(phoneLabel);
	}

	public String getCompanyNameLabel() {
		return getText(companyNameLabel);
	}

	public String getCompanySizeLabel() {
		return getText(companySizeLabel);
	}

	public String getCountryLabel() {
		return getText(countryLabel);
	}

	public String getRequestTypeLabel() {
		return getText(requestTypeLabel);
	}

	public String getMessageLabel() {
		return getText(messageLabel);
	}

	public String getHearAboutUsLabel() {
		return getText(hearAboutUsLabel);
	}

	public String getAllFieldsError() {
		return getText(allFieldsError);
	}

	private String getText(By element) {
		return driver.findElement(element).getText();
	}
}
