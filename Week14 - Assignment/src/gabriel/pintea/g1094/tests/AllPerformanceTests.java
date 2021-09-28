package gabriel.pintea.g1094.tests;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import gabriel.pintea.g1094.tests.categories.PerformanceTests;

@RunWith(Categories.class)
@IncludeCategory({ PerformanceTests.class })
@SuiteClasses({ TestProductReq1.class, TestProductReq2.class, TestProductReq3.class })
public class AllPerformanceTests {

}
