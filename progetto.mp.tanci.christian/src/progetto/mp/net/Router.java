package progetto.mp.net;

import java.util.ArrayList;
import java.util.Collection;


public class Router extends Node {

	Collection<Node> Nodes = new ArrayList<>();

	public Router(long ipv4, Node father, Collection<Node> nodes) {
		super(ipv4, father);
		Nodes = nodes;
	}
	public Router(long ipv4, Collection<Node> nodes) {
		super(ipv4);
		Nodes = nodes;
	}

	public void addNode(Node node) {
		node.setFather(this);
		Nodes.add(node);
		notifyObservers();
	}

	public void removeNode(Node node) {
		node.setFather(null);
		Nodes.remove(node);
		notifyObservers();
	}

	public Collection<Node> getNodes() {
		return Nodes;
	}

	@Override
	public boolean locateIpv4(long ipv4) {
		if (this.getIpv4() == ipv4) {
			return true;
		}
		return Nodes.stream().anyMatch(x -> x.locateIpv4(ipv4));
	}

	@Override
	public void accept(NetVisitor visitor) {
		visitor.visitRouter(this);
	}

}
