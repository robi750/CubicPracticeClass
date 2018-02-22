package com.cubic.util;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.cubic.test.Account;
import com.cubic.test.Billing;

public class NameUtilTest {

	private NameUtil util = new NameUtil();

	@Category({ Account.class })
	@Test
	public void testGetFormattedName() {
		String result = util.getFormattedName("Jim", "Smith");
		// assertEquals("JimSmith", result);
		assertThat(result, allOf(containsString("Smith"), startsWith("Jim")));
		assertThat(result, allOf(startsWith("Jim"), endsWith("Smith")));
		// assertThat(result, both(startsWith("Jim").and(endsWith("smith"))));

	}

	@Category({ Billing.class })
	@Test
	public void testGetFormattedNameNullFirstName() {
		String result = util.getFormattedName(null, "Smith");
		// assertEquals("Smith", result);
		assertThat(result, anyOf(containsString("Smith"), startsWith("Jim")));

	}

	@Test
	public void testGetFormattedNameNullLastName() {
		String result = util.getFormattedName("Jim", null);
		// assertEquals("Jim", result);
		assertThat(result, allOf(containsString("Jim"), startsWith("Jim")));

	}

	@Category({ Account.class, Billing.class })
	@Test
	public void testGetFormattedNameNullParameters() {
		String result = util.getFormattedName(null, null);
		assertEquals("", result);
	}
}
