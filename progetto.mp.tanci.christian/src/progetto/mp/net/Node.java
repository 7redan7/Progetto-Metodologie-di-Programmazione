package progetto.mp.net;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public abstract class Node {

	private long ipv4;
	private Node father;
	private Collection<NetObserver> observers = new ArrayList<>();

	public Node(long ipv4, Node father) {
		this.ipv4 = ipv4;
		this.father = father;
	}

	public Node(long ipv4) {
		this.ipv4 = ipv4;
		this.father = null;
	}

	public long getIpv4() {
		return ipv4;
	}

	void setIpv4(long newIpv4) {
		this.ipv4 = newIpv4;
	}

	public Optional<Node> getFather() {
		return Optional.ofNullable(father);
	}

	void setFather(Node newFather) {
		this.father = newFather;
	}

	public abstract boolean locateIpv4(long ipv4);

	public abstract void accept(NetVisitor visitor);

	public void addObserver(NetObserver obs) {
		observers.add(obs);
	}

	public void removeObserver(NetObserver obs) {
		observers.remove(obs);
	}

	public Collection<NetObserver> getObservers() {
		return observers;
	}

	public void notifyObservers() {
		observers.stream().forEach(x -> x.update());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ipv4 ^ (ipv4 >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (ipv4 != other.ipv4)
			return false;
		return true;
	}

}
