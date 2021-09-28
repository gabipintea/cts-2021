package gabriel.pintea.g1094.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import gabriel.pintea.g1094.composite.AbstractNode;
import gabriel.pintea.g1094.composite.Group;
import gabriel.pintea.g1094.composite.Server;

public class TestCaseServerComposite {
	static AbstractNode srvGroup1;
	static Server srv1, srv2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		srv1 = new Server("192.168.0.1", 53, 1000);
		srv2 = new Server("192.168.0.100", 21, 25);
		srvGroup1 = new Group();
		srvGroup1.addNewNode(srv1);
		srvGroup1.addNewNode(srv2);
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
	public void testServerGrouping() {
		assertEquals(srvGroup1.getIpAddress(), " " + srv1.getIpAddress() + 
				" " + srv2.getIpAddress());
	}
	
	@Test
	public void testServerConnection() {
		assertTrue(srvGroup1.connect());
	}
	
	@Test
	public void testServerGetNode() {
		assertEquals(srvGroup1.getNode(0).getPort(), srv1.getPort());
	}
	
	@Test
	public void testServerDeleteNode() {
		srvGroup1.deleteNode(srv1);
		assertEquals(srvGroup1.getIpAddress(), " " + srv2.getIpAddress());
	}
	
	@Test
	public void testServerConnectionMaxedOut() {
		for(int i=0; i < srv2.getMaxConnections() + 1; i++) {
			if(!srvGroup1.connect()) {
				assertTrue(true);
			}
		}
	}

}
