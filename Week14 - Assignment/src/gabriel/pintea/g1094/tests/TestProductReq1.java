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
import gabriel.pintea.g1094.exceptions.WrongItemsException;
import gabriel.pintea.g1094.exceptions.WrongNameException;
import gabriel.pintea.g1094.exceptions.WrongPriceException;
import gabriel.pintea.g1094.tests.categories.ExistenceTests;
import gabriel.pintea.g1094.tests.categories.RightTests;

public class TestProductReq1 {
	static String prodName, lowNoName;
	static float prodPrice, negPrice;
	static ArrayList<Integer> prodWeeklySoldItems, largeNoProdWeeklySoldItems;
	static int[] items = new int[] { 2, 5, 20, 30 };

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		prodName  = "Smartphone";
		prodPrice = 10;
		lowNoName = "Na";
		negPrice = -2;		
		prodWeeklySoldItems = new ArrayList<>();		
		largeNoProdWeeklySoldItems = new ArrayList<>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		for(int item : items) {
			prodWeeklySoldItems.add(item);
		}
		
		for(Integer n = 0; n < 1000 + 1; n++) {
			largeNoProdWeeklySoldItems.add(n);
		}
	}

	@After
	public void tearDown() throws Exception {
		prodWeeklySoldItems.clear();
		largeNoProdWeeklySoldItems.clear();
	}

	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Category(RightTests.class)
	@Test
	public void testProductConstructorTwoArgsRightValues() {
		try {
			Product prod = new Product(prodName, prodPrice);
			System.out.println(prod.toString());		
			assertEquals("Testing with proper name", prodName, prod.getName());
			assertEquals("Testing with proper price", prodPrice, prod.getPrice(), 0);
		} catch (Exception e) {
			fail("We got an exception when that was not expected");			
		}				
	}
	
	@Category(RightTests.class)
	@Test
	public void testProductConstructorThreeArgsRightValues() {
		try {
			Product prod = new Product(prodName, prodPrice, prodWeeklySoldItems);
			System.out.println(prod.toString());
			
			assertEquals("Testing with proper name", prodName, prod.getName());
			assertEquals("Testing with proper price", prodPrice, prod.getPrice(), 0);
			assertEquals("Testing with proper number of items", items[3], prod.getSoldItems(3));			
		} catch (Exception e) {
			fail("We got an exception when that was not expected");
		}		
	}
	
	@Test(expected = WrongNameException.class)
	public void testProductConstructorTwoArgsNameErrorCondition() throws WrongNameException, WrongPriceException {
		Product prod = new Product(lowNoName, prodPrice);
	}
	
	@Test(expected = WrongPriceException.class)
	public void testProductConstructorTwoArgsPriceErrorCondition() throws WrongPriceException, WrongNameException {
		Product prod = new Product(prodName, negPrice);
	}
	
	@Test(expected = WrongNameException.class)
	public void testProductConstructorThreeArgsNameErrorCondition() throws WrongNameException, WrongPriceException, WrongItemsException {
		Product prod = new Product(lowNoName, prodPrice, prodWeeklySoldItems);
	}
	
	@Test(expected = WrongItemsException.class)
	public void testProductConstructorThreeArgsItemsErrorCondition() throws WrongPriceException, WrongNameException, WrongItemsException {
		Product prod = new Product(prodName, prodPrice, largeNoProdWeeklySoldItems);
	}
	
	@Test
	public void testProductConstructorThreeArgsItemsReference() throws WrongItemsException, WrongNameException, WrongPriceException {
		
		Product prod = new Product(prodName, prodPrice, prodWeeklySoldItems);
		
		prodWeeklySoldItems.set(0, 5);

		int[] soldItems = new int[prodWeeklySoldItems.size()];
		for (int i = 0; i < prodWeeklySoldItems.size(); i++) {
			soldItems[i] = prod.getSoldItems(i);
		}
		
		assertArrayEquals("Shallow copy", soldItems, items);
	}
	
	@Category(ExistenceTests.class)
	@Test(expected = WrongItemsException.class)
	public void testProductConstructorThreeArgsExistenceNullReferenceForItems() throws WrongItemsException, WrongNameException, WrongPriceException {
		Product prod = new Product(prodName, prodPrice, null);
	}
	
	@Test
	public void testProductSetSalesReference() throws WrongItemsException, WrongNameException, WrongPriceException {
		
		Product prod = new Product(prodName, prodPrice);
		prod.setSales(prodWeeklySoldItems);
		
		prodWeeklySoldItems.set(0, 5);

		int[] soldItems = new int[prodWeeklySoldItems.size()];
		for (int i = 0; i < prodWeeklySoldItems.size(); i++) {
			soldItems[i] = prod.getSoldItems(i);
		}
		
		assertArrayEquals("Shallow copy", soldItems, items);
	}
	
	@Test(expected = WrongItemsException.class)
	public void testProductSetSalesExistenceNullReferenceForItems() throws WrongNameException, WrongPriceException, WrongItemsException {
		Product prod = new Product(prodName, prodPrice);
		prod.setSales(null);
	}

}
