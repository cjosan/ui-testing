package pom;

import java.util.Arrays;

public enum CompanySize {
	SIZE_0_4 ("0-4 employees"),
	SIZE_5_50 ("5-50 employees"),
	SIZE_51_350("51-350 employees"),
	SIZE_351_1000("351-1000 employees"),
	SIZE_1001_3000("1001-3000 employees"),
	SIZE_3001_5000("3001-5000 employees"),
	SIZE_5000_AND_MORE(">5000 employees");

	private String value;

	CompanySize(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static CompanySize fromText(String text) {
		return Arrays
				.stream(CompanySize.values())
				.filter(c -> c.value.equalsIgnoreCase(text))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No enum value found for " + text));
	}
}
