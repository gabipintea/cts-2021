package gabriel.pintea.g1094.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import gabriel.pintea.g1094.classes.Product;
import gabriel.pintea.g1094.exceptions.WrongItemsException;
import gabriel.pintea.g1094.tests.categories.PerformanceTests;
import gabriel.pintea.g1094.tests.categories.RightTests;

public class TestProductReq2 {
	
	static Product prod;
	static String prodName;
	static float prodPrice;
	static ArrayList<Integer> prodSoldItems;
	static int[] items = new int[] { 2, 5, 20, 30, 100, 125, 140 };
	static int limit;
	static int noItemsAboveLimit;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {		
		prodName = "Smartphone";
		prodPrice = 1000;
		limit = 100;
		noItemsAboveLimit = 0;
		for(int i : items) {
			if(i >= limit) {
				noItemsAboveLimit++;
			}
		}
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
	public void testProductAddWeekRightValues() {
		int week = 25;
		prod.addWeek(week);
		assertEquals("Testing adding a week", week, prod.getSoldItems(prodSoldItems.size()));
	}
	
	@Category(RightTests.class)
	@Test
	public void testProductGetSoldItemsRightValues() {
		assertEquals("Testing getting the right value", items[0], prod.getSoldItems(0));
	}
	
	@Category(RightTests.class)
	@Test
	public void testProductGetNoWeeksAboveLimitRightValues() {
		assertEquals("Testing the no of weeks above limit", noItemsAboveLimit, prod.getNoWeeksAboveLimit(limit) );
	}
	
	@Category(PerformanceTests.class)
	@Test
	public void testProductGetNoWeeksAboveLimitPerformance() throws WrongItemsException {
		
		ArrayList<Integer> weeks = new ArrayList<>();
		int noItems = 1000;
		Random random = new Random();
		for(int i = 0; i < noItems; i++) {
			weeks.add(random.nextInt(1000));
		}
		
		prod.setSales(weeks);
		
		
		long tStart = System.currentTimeMillis();
		int noWeeksAboveLimit = prod.getNoWeeksAboveLimit(limit);
		long tFinal = System.currentTimeMillis();
		
		long delta = tFinal - tStart;
		long performanceLimit = 3;
		if(delta <= performanceLimit) {
			assertTrue(true);
		}
		else {
			fail("Poor performance");
		}
	}
	

}
