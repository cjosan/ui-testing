package utils;

import static utils.PropertiesUtil.getProperty;

public interface ErrorMessages {

	String REQUIRED_FIELD = getProperty("requiredFieldError");
	String REQUIRED_DROPDOWN = getProperty("requiredDropdownError");
	String ALL_FIELDS = getProperty("allFieldsError");
	String EMAIL_WRONG_FORMAT = getProperty("emailWrongFormat");

}
