package progetto.mp.net;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;


import progetto.mp.net.utils.ContentObserver;

public class NodeTests {
	@Test
	public void addObserverTest() {
		Endpoint e1 = new Endpoint(1);
		NetObserver ob1 = new ContentObserver(e1);
		e1.addObserver(ob1);
		assertThat(e1.getObservers().contains(ob1));
	}
	
	@Test
	public void removeObserverTest() {
		Endpoint e1 = new Endpoint(1);
		NetObserver ob1 = new ContentObserver(e1);
		e1.addObserver(ob1);
		e1.removeObserver(ob1);
		assertThat(e1.getObservers().isEmpty());
	}
	
	@Test
	public void testEquals() {
		Node n1 = new Endpoint(1);
		Node n2 = new Endpoint(1);
		assertEquals(n1, n2);
	}

	@Test
	public void testEquals2() {
		Node n1 = new Endpoint(1);
		Node n2 = new Endpoint(2);
		assertNotEquals(n1, n2);
	}

	@Test
	public void testHashCode() {
		Node n1 = new Endpoint(1);
		Node n2 = new Endpoint(1);
		assertEquals(n1.hashCode(), n2.hashCode());
	}

	@Test
	public void testHashCode2() {
		Node n1 = new Endpoint(1);
		Node n2 = new Endpoint(2);
		assertNotEquals(n1.hashCode(), n2.hashCode());
	}
}
