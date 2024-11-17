package progetto.mp.net;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import progetto.mp.net.utils.MockNetContent;

public class EndPointTests {

	@Test
	public void testReturnFather() {
		Router r1 = new Router(1, new ArrayList<>());
		Endpoint e1 = new Endpoint(11, r1, new MockNetContent());
		assertEquals(e1.getFather().get(), r1);
	}

	@Test
	public void testReturnFather2() {
		Endpoint e1 = new Endpoint(1);
		assertEquals(e1.getFather().isPresent(), false);
	}

	@Test
	public void testLocateIpv4() {
		Endpoint e1 = new Endpoint(1);
		e1.locateIpv4(1);
		assertTrue(e1.locateIpv4(1));
	}

	@Test
	public void testFatherChanges() {
		Endpoint e1 = new Endpoint(11);
		Router r1 = new Router(1, new ArrayList<>());
		r1.addNode(e1);
		assertEquals(e1.getFather().get(), r1);
	}

	@Test
	public void testFatherChanges2() {
		Endpoint e1 = new Endpoint(11);
		Router r1 = new Router(1, new ArrayList<>());
		r1.addNode(e1);
		r1.removeNode(e1);
		assertEquals(e1.getFather().isPresent(), false);
	}

}
