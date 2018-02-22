package com.cubic.test;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@IncludeCategory({ Account.class })
@Suite.SuiteClasses({ AllTest.class })
public class AccountTest {

}
