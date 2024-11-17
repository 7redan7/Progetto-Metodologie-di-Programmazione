package progetto.mp.net.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import progetto.mp.net.Endpoint;
import progetto.mp.net.NetContent;
import progetto.mp.net.Node;
import progetto.mp.net.Router;

public class EndpointContentVisitorTests {

	private EndpointContentVisitor visitor;

	@Before
	public void setup() {
		visitor = new EndpointContentVisitor();
	}

	@Test
	public void visitEndpointTest() {
		NetContent c1 = new MockNetContent();
		Node e1 = new Endpoint(1, new Router(1, new ArrayList<>()), c1);
		e1.accept(visitor);
		assertThat(visitor.getResults()).containsExactly(c1);
	}

	@Test
	public void visitRouterTest() {
		Router r1 = new Router(1, new ArrayList<Node>());
		r1.accept(visitor);
		assertThat(visitor.getResults()).isEmpty();;
	}
	
	@Test
	public void visitRouterWithEndpointAsChildTest() {
		Router r1 = new Router(1, new ArrayList<Node>());
		NetContent c1 = new MockNetContent();
		r1.addNode(new Endpoint(11,null,c1));
		r1.accept(visitor);
		assertThat(visitor.getResults()).isEmpty();;
	}
}
