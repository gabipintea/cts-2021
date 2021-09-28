package gabriel.pintea.g1094.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import gabriel.pintea.g1094.singleton.Server;

public class TestCaseServerSingleton {
	static Server srv1, srv2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		srv1 = Server.getServer();
		srv2 = Server.getServer();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUniqueInstance() {
		assertEquals(srv1, srv2);
	}
	
	@Test
	public void testConnectMaxedOut() {
		for(int i=0; i < srv1.getMaxConnections(); i++) {
			srv1.connect();
		}
		assertFalse(srv1.connect());		
	}
	
	@Test
	public void testDisconnectMaxedOut() {
		for(int i=0; i < srv1.getMaxConnections(); i++) {
			srv1.disconnect();
		}
		assertFalse(srv1.disconnect());		
	}

}
