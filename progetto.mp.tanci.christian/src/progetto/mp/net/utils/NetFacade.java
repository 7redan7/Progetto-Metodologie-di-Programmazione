package progetto.mp.net.utils;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

import progetto.mp.net.NetContent;
import progetto.mp.net.Node;

public class NetFacade {

	public Optional<Node> locateAndReturnNode(Node node, long ipv4) {
		if (node.locateIpv4(ipv4) == false) {
			return Optional.empty();
		}
		AccessibleEndpointsVisitor visitor = new AccessibleEndpointsVisitor();
		node.accept(visitor);
		return visitor.getResults().stream().filter(x -> x.getIpv4() == ipv4).findFirst();
	}

	public Collection<Node> returnAccessibleNodes(Node node) {
		AccessibleEndpointsVisitor visitor = new AccessibleEndpointsVisitor();
		node.accept(visitor);
		return visitor.getResults();
	}

	public Optional<NetContent> returnContent(Node node) {
		EndpointContentVisitor visitor = new EndpointContentVisitor();
		node.accept(visitor);
		return visitor.getResults().stream().filter(x -> Objects.nonNull(x)).findFirst();
	}

	public Collection<NetContent> returnContentFromCollection(Collection<Node> nodes) {
		EndpointContentVisitor visitor = new EndpointContentVisitor();
		nodes.forEach(x -> x.accept(visitor));
		return visitor.getResults();
	}
}
