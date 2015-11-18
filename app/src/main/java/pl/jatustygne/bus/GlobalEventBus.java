package pl.jatustygne.bus;

import de.greenrobot.event.EventBus;

/**
 * Created by Dawid Drozd aka Gelldur on 11/18/15.
 */
public class GlobalEventBus extends EventBus {
	public static GlobalEventBus getInstance() {
		return _instance;
	}

	private static final GlobalEventBus _instance = new GlobalEventBus();
}
