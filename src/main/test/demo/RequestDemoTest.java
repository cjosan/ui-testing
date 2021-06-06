package demo;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pom.AODocsHomePage;
import pom.AODocsRequestDemoPage;
import pom.CompanySize;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static utils.DemoInputToErrorTextMapping.*;
import static utils.PropertiesUtil.getProperty;


public class RequestDemoTest extends BaseTest {

	@Test
	public void requestDemo() {

		AODocsHomePage aoDocsHomePage = new AODocsHomePage(driver);
		aoDocsHomePage.openPageFromGoogleSearch();
		AODocsRequestDemoPage requestDemoPage = aoDocsHomePage.requestDemo();

		requestDemoPage.submitForm(
				getProperty("firstName"),
				getProperty("lastName"),
				getProperty("email").equals("${random}")
						? UUID.randomUUID().toString()
						: getProperty("email"),
				CompanySize.fromText(getProperty("companySize"))
		);

		logger.info("Validating error labels are displayed and error text");

		assertTrue(requestDemoPage.existsSubmitFormError(), "Validate submit form error is present");
		assertEquals(ALL_FIELDS.getErrorText(), requestDemoPage.getAllFieldsError(), "All fields");

		assertFalse(requestDemoPage.existsFirstNameLabel(), "Validate firstName error is present");

		assertTrue(requestDemoPage.existsLastNameLabel(), "Validate lastName error is present");
		assertEquals(LAST_NAME.getErrorText(), requestDemoPage.getLastNameLabel(), "Last Name field");

		assertTrue(requestDemoPage.existsEmailLabel(), "Validate email error is present");
		assertEquals(EMAIL_WORNG_FORMAT.getErrorText(), requestDemoPage.getEmailLabel(), "Email field");

		assertFalse(requestDemoPage.existsPhoneLabel(), "Validate phone error is present");

		assertTrue(requestDemoPage.existsCompanyNameLabel(), "Validate companyName error is present");
		assertEquals(COMPANY_NAME.getErrorText(), requestDemoPage.getCompanyNameLabel(), "Company Name field");

		assertFalse(requestDemoPage.existsCompanySizeLabel(), "Validate companySize error is present");

		assertTrue(requestDemoPage.existsCountryLabel(), "Validate country error is present");
		assertEquals(COUNTRY.getErrorText(), requestDemoPage.getCountryLabel(), "Country field");

		assertFalse(requestDemoPage.existsRequestTypeLabel(), "Validate request type error is present");

		assertTrue(requestDemoPage.existsMessageLabel(), "Validate message error is present");
		assertEquals(MESSAGE.getErrorText(), requestDemoPage.getMessageLabel(), "Message field");

		assertTrue(requestDemoPage.existsHearAboutUsLabel(), "Validate hear about us error is present");
		assertEquals(HEAR_ABOUT.getErrorText(), requestDemoPage.getHearAboutUsLabel(), "Hear About field");
	}

}
