package progetto.mp.net.utils;

import progetto.mp.net.NetObserver;
import progetto.mp.net.Endpoint;
import progetto.mp.net.NetContent;

public class ContentObserver implements NetObserver {

	private Endpoint subject;
	private NetContent content;
	private String log;

	public ContentObserver(Endpoint endpoint) {
		subject = endpoint;
		content = endpoint.getContent();
		log = "";
	}

	@Override
	public void update() {
		if (!subject.getContent().equals(content)) {
			log += "The content of the node has been changed.\n";
		}
	}

	public String getLog() {
		return log;
	}

}
