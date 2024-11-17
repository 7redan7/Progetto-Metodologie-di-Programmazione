package progetto.mp.net.utils;

import java.util.ArrayList;
import java.util.Collection;

import progetto.mp.net.NetVisitor;
import progetto.mp.net.Node;
import progetto.mp.net.Router;
import progetto.mp.net.Endpoint;

public class AccessibleEndpointsVisitor implements NetVisitor {

	private Collection<Node> results = new ArrayList<>();

	public Collection<Node> getResults() {
		return results;
	}

	@Override
	public void visitEndpoint(Endpoint endpoint) {
		results.add(endpoint);
	}

	@Override
	public void visitRouter(Router router) {
		router.getNodes().forEach(x -> x.accept(this));
	}

}
