package com.test.accounts;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by saikrisv on 16/10/15.
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(Smoke.class)
@Suite.SuiteClasses({
        AccountsDemoTest.class
})
public class RunSuite {
}
