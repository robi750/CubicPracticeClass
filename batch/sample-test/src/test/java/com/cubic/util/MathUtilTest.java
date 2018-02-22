package com.cubic.util;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.cubic.test.Account;
import com.cubic.test.Billing;

public class MathUtilTest {

	private MathUtil util = new MathUtil();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");

	}

	@Before
	public void setUp() throws Exception {

		System.out.println("setUp");

	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");

	}

	@Category({ Account.class })
	@Test
	public void testAdd() {
		System.out.println("testAdd");
		int result = util.add(20, 30);
		assertEquals(50, result);

	}

	@Test
	public void testMul() {
		System.out.println("testMul");
		int result = util.mul(5, 3);
		assertEquals(15, result);

	}
	@Category({ Billing.class })
	@Test
	public void testAddNegative() {
		System.out.println("testAddNegative");
		int result = util.add(-20, -30);
		assertEquals(-50, result);
		result = util.add(-20, 30);
		assertEquals(10, result);
		result = util.add(20, -30);
		assertEquals(-10, result);

	}

	@Category({ Account.class, Billing.class })
	@Test
	public void testSub() {
		System.out.println("testSub");
		int result = util.sub(50, 30);
		assertEquals(20, result);

	}

	@Category({ Account.class, Billing.class })
	@Test
	public void testDiv() {
		System.out.println("testDiv");
		int result = util.div(20, 10);
		assertEquals(2, result);
	}

	// expected = RuntimeException.class
	@Test(expected = ArithmeticException.class) // this will expect exception and throw insted of failing testcase
	public void testDivByZero() {
		util.div(20, 0);
	}

	@Test(timeout = 4000)
	public void testDivTimeout() {
		addTimeOut(3000);
		int result = util.div(20, 10);
		assertEquals(2, result);
	}

	private void addTimeOut(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	

}
