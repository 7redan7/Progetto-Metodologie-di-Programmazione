package progetto.mp.net.utils;

import progetto.mp.net.NetObserver;
import progetto.mp.net.Router;

public class RouterExpansionObserver implements NetObserver {

	private Router subject;
	private int nodeCounter;

	public RouterExpansionObserver(Router subject) {
		this.subject = subject;
	}

	public int getNodeCounter() {
		return nodeCounter;
	}

	@Override
	public void update() {
		if (subject.getNodes().size() != nodeCounter) {
			nodeCounter = subject.getNodes().size();
		}
	}
}
