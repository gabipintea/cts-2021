package gabriel.pintea.g1094.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import gabriel.pintea.g1094.classes.Product;
import gabriel.pintea.g1094.tests.categories.RightTests;

public class TestProductReq3 {

	static Product prod;
	static String prodName;
	static float prodPrice;
	static ArrayList<Integer> prodSoldItems;
	static int[] items = new int[] { 2, 5, 20, 30, 100, 125, 140, 140 };
	static int limit;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {		
		prodName = "Smartphone";
		prodPrice = 1000;
		limit = 100;
		prodSoldItems = new ArrayList<>();
		for(int item : items) {
			prodSoldItems.add(item);
		}
		try {
			prod = new Product(prodName, prodPrice);			
		} catch (Exception e) {
			System.out.println("Exception found " + e.getClass());
		}
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		prod.setSales(prodSoldItems);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Category(RightTests.class)
	@Test
	public void testGetPercentOfBadWeeksRightValues() {
		int expectedPercent = 50;
		assertEquals("Testing the percent of bad weeks with right values", expectedPercent, prod.getPercentOfBadWeeks(limit));
	}
	
	@Category(RightTests.class)
	@Test
	public void testGetWeeksIndexWithMaxSalesRightValues() {
		ArrayList<Integer> noWeeksWithMaxSales = prod.getWeeksIndexWithMaxSales();
		int firstIndex = noWeeksWithMaxSales.get(0);
		assertEquals("Testing the weeks index with max sales with right values", 6, firstIndex);
	}

}
