package progetto.mp.net.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import progetto.mp.net.Endpoint;
import progetto.mp.net.Router;
import progetto.mp.net.Node;

public class AccessibleEndpointsVisitorTests {

	private AccessibleEndpointsVisitor visitor;

	@Before
	public void setup() {
		visitor = new AccessibleEndpointsVisitor();
	}

	@Test
	public void visitEndpointTest() {
		Node n1 = new Endpoint(1);
		n1.accept(visitor);
		assertThat(visitor.getResults()).containsExactly(n1);
	}

	@Test
	public void visitRouterTest() {
		Router r1 = new Router(1, new ArrayList<Node>());
		Node n1 = new Endpoint(11);
		Node n2 = new Endpoint(12);
		Node n3 = new Endpoint(13);
		r1.addNode(n1);
		r1.addNode(n2);
		r1.addNode(n3);
		r1.accept(visitor);
		assertThat(visitor.getResults()).containsExactlyInAnyOrder(n1, n2, n3);
	}
}
