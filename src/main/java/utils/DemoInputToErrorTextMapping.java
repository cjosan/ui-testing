package utils;

import static utils.ErrorMessages.*;

public enum DemoInputToErrorTextMapping {

	FIRST_NAME(REQUIRED_FIELD),
	LAST_NAME(REQUIRED_FIELD),
	EMAIL_MISSING(REQUIRED_FIELD),
	EMAIL_WORNG_FORMAT(EMAIL_WRONG_FORMAT),
	PHONE(""),
	COMPANY_NAME(REQUIRED_FIELD),
	COMPANY_SIZE(REQUIRED_DROPDOWN),
	COUNTRY(REQUIRED_DROPDOWN),
	REQUEST_TYPE(""),
	MESSAGE(REQUIRED_FIELD),
	HEAR_ABOUT(REQUIRED_DROPDOWN),
	ALL_FIELDS(ErrorMessages.ALL_FIELDS);

	private String errorText;

	DemoInputToErrorTextMapping(String errorText) {
		this.errorText = errorText;
	}

	public String getErrorText() {
		return errorText;
	}
}
