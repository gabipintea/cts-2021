package gabriel.pintea.g1094.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import gabriel.pintea.g1094.prototype.DNSServer;
import gabriel.pintea.g1094.prototype.FTPServer;
import gabriel.pintea.g1094.prototype.Server;
import gabriel.pintea.g1094.prototype.ServerFactory;

public class TestCaseServerPrototype {
	
	static Server dnsSrv1, dnsSrv2, ftpSrv1, ftpSrv2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dnsSrv1 = ServerFactory.getServer(53);		
		dnsSrv2 = (DNSServer) dnsSrv1.clone();
		ftpSrv1 = ServerFactory.getServer(21);
		ftpSrv2 = (FTPServer) ftpSrv1.clone();
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
	public void testServerCloning() {		
		assertEquals(dnsSrv1.getIpAddress(), dnsSrv2.getIpAddress());		
	}
	
	@Test
	public void testServerNotEqualInstances() {		
		assertNotEquals(ftpSrv1, ftpSrv2);
	}
	
	@Test
	public void testServerSubclasses() {
		assertTrue(dnsSrv1 instanceof Server && ftpSrv1 instanceof Server);
	}

}
