package progetto.mp.net.utils;

import static org.junit.Assert.*;
import org.junit.Test;

import progetto.mp.net.Endpoint;
import progetto.mp.net.NetContent;

public class ContentObserverTests {

	@Test
	public void contentChangedTest() {
		NetContent c1 = new MockNetContent("Marco", "");
		Endpoint e1 = new Endpoint(1, null, c1);
		ContentObserver obs1 = new ContentObserver(e1);
		e1.addObserver(obs1);
		e1.setContent(new MockNetContent("Mario", ""));
		assertEquals("The content of the node has been changed.\n", obs1.getLog());
	}

	@Test
	public void contentNotChangedTest() {
		NetContent c1 = new MockNetContent("Marco", "");
		Endpoint e1 = new Endpoint(1, null, c1);
		ContentObserver obs1 = new ContentObserver(e1);
		e1.addObserver(obs1);
		e1.setContent(c1);
		assertEquals("", obs1.getLog());
	}

	@Test
	public void contentChangedTwoTimesTest() {
		NetContent c1 = new MockNetContent("Marco", "");
		Endpoint e1 = new Endpoint(1, null, c1);
		ContentObserver obs1 = new ContentObserver(e1);
		e1.addObserver(obs1);
		e1.setContent(new MockNetContent("Mario", ""));
		e1.setContent(new MockNetContent("Aldo", ""));
		assertEquals("The content of the node has been changed.\n"
				+ "The content of the node has been changed.\n"
				+ "", obs1.getLog());
	}

}
