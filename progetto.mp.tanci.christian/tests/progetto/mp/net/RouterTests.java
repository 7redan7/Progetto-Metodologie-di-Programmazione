package progetto.mp.net;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;

public class RouterTests {
	
	@Test
	public void locateIpv4FromRouter() {
		Router r1 = new Router(1, new ArrayList<>());
		r1.addNode(new Endpoint(11));
		r1.addNode(new Endpoint(12));
		r1.addNode(new Endpoint(13));
		assertTrue(r1.locateIpv4(13));
	}
	
	@Test
	public void locateIpv4FromRouter2() {
		Router r1 = new Router(1, new ArrayList<>());
		r1.addNode(new Endpoint(11));
		r1.addNode(new Endpoint(12));
		r1.addNode(new Router(13,new ArrayList<>()));
		assertTrue(r1.locateIpv4(13));
	}
	
	@Test
	public void locateIpv4FromRouterTwoLevel() {
		Router r1 = new Router(1, new ArrayList<>());
		Router r2 = new Router(19, new ArrayList<>());
		r1.addNode(new Endpoint(13));
		r1.addNode(new Endpoint(14));
		r1.addNode(new Endpoint(15));
		r1.addNode(r2);
		r2.addNode(new Endpoint(191));
		r2.addNode(new Endpoint(192));
		assertTrue(r1.locateIpv4(192));
	}

}
