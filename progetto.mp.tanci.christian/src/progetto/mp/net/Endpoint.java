package progetto.mp.net;

public class Endpoint extends Node {

	private NetContent content;

	public Endpoint(long ipv4, Node father, NetContent content) {
		super(ipv4, father);
		this.content=content;
	}

	public Endpoint(long ipv4) {
		super(ipv4);
	}

	public NetContent getContent() {
		return content;
	}

	public void setContent(NetContent content) {
		this.content = content;
		notifyObservers();
	}

	@Override
	public boolean locateIpv4(long ipv4) {
		if (this.getIpv4() == ipv4) {
			return true;
		}
		return false;
	}

	@Override
	public void accept(NetVisitor visitor) {
		visitor.visitEndpoint(this);
	}

}
