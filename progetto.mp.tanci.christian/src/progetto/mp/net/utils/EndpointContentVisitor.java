package progetto.mp.net.utils;

import java.util.ArrayList;
import java.util.Collection;

import progetto.mp.net.Router;
import progetto.mp.net.Endpoint;
import progetto.mp.net.NetContent;
import progetto.mp.net.NetVisitor;

public class EndpointContentVisitor implements NetVisitor {

	private Collection<NetContent> results = new ArrayList<>();

	public Collection<NetContent> getResults() {
		return results;
	}

	@Override
	public void visitEndpoint(Endpoint endpoint) {
		results.add(endpoint.getContent());
	}

	@Override
	public void visitRouter(Router router) {
		// does nothing
	}

}
