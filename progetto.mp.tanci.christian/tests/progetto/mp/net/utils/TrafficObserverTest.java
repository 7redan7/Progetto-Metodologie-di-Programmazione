package progetto.mp.net.utils;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import progetto.mp.net.Endpoint;
import progetto.mp.net.Router;

public class TrafficObserverTest {

	@Test
	public void addNodeTest() {
		Router r1 = new Router(1, new ArrayList<>());
		RouterExpansionObserver obs1 = new RouterExpansionObserver(r1);
		r1.addObserver(obs1);
		r1.addNode(new Endpoint(12,null,null));
		r1.addNode(new Endpoint(13,null,null));
		assertEquals(obs1.getNodeCounter(),2);
	}
	
	@Test
	public void removeNodeThatDoesNotExistsTest() {
		Router r1 = new Router(1, new ArrayList<>());
		RouterExpansionObserver obs1 = new RouterExpansionObserver(r1);
		r1.addObserver(obs1);
		r1.addNode(new Endpoint(12,null,null));
		r1.removeNode(new Endpoint(13,null,null));
		assertEquals(obs1.getNodeCounter(),1);
	}

}
