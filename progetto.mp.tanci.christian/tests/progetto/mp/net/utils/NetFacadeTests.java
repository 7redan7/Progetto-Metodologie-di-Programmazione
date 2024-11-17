package progetto.mp.net.utils;

import progetto.mp.net.Endpoint;
import progetto.mp.net.NetContent;
import progetto.mp.net.Node;
import progetto.mp.net.Router;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

public class NetFacadeTests {

	private NetFacade facade;

	@Before
	public void setup() {
		facade = new NetFacade();
	}

	@Test
	public void locateAndReturnTest() {
		Router r1 = new Router(1, new ArrayList<>());
		Router r2 = new Router(19, new ArrayList<>());
		Node e1 = new Endpoint(13);
		Node e2 = new Endpoint(14);
		r1.addNode(e1);
		r1.addNode(e2);
		r1.addNode(r2);
		Node e3 = new Endpoint(191);
		r2.addNode(e3);
		assertEquals(facade.locateAndReturnNode(r2, 191).get(), e3);
	}

	@Test
	public void locateAndReturnWithAbsentNodeTest() {
		Router r1 = new Router(1, new ArrayList<>());
		Router r2 = new Router(19, new ArrayList<>());
		Node e1 = new Endpoint(13);
		Node e2 = new Endpoint(14);
		r1.addNode(e1);
		r1.addNode(e2);
		r1.addNode(r2);
		Node e3 = new Endpoint(191);
		r2.addNode(e3);
		assertEquals(facade.locateAndReturnNode(r2, 193), Optional.empty());
	}

	@Test
	public void returnAccessibleNodesTest() {
		Router r1 = new Router(1, new ArrayList<>());
		Router r2 = new Router(19, new ArrayList<>());
		r1.addNode(new Endpoint(13));
		r1.addNode(r2);
		Node e1 = new Endpoint(191);
		Node e2 = new Endpoint(192);
		r2.addNode(e1);
		r2.addNode(e2);
		assertThat(facade.returnAccessibleNodes(r2)).containsExactlyInAnyOrder(e1, e2);
	}

	@Test
	public void returnContent() {
		NetContent c1 = new MockNetContent();
		assertEquals(facade.returnContent(new Endpoint(1,null,c1)).get(),c1);
	}
	
	@Test
	public void returnContentEmpty() {
		assertThat(facade.returnContent(new Endpoint(1,null,null))).isEmpty();
	}
	
	@Test
	public void returnContentAfterReturningAccessibleNodesTest() {
		Router r1 = new Router(1, new ArrayList<>());
		Router r2 = new Router(19, new ArrayList<>());
		NetContent c1 = new MockNetContent();
		NetContent c2 = new MockNetContent();
		NetContent c3 = new MockNetContent();
		r1.addNode(new Endpoint(13, null, c1));
		r1.addNode(new Endpoint(14, null, c2));
		r1.addNode(r2);
		r2.addNode(new Endpoint(191, null, c3));
		assertThat(facade.returnContentFromCollection(facade.returnAccessibleNodes(r1)))
														.containsExactlyInAnyOrder(c1,c2, c3);
	}
}
