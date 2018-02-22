package com.cubic.util;

public class NameUtil {

	public String getFormattedName(final String firstName, final String lastName) {
		String result = "";

		if (firstName != null) {
			result = firstName + "";
		}
		if (lastName != null) {
			result = result + lastName;
		}
		return result.trim();
	}

}
