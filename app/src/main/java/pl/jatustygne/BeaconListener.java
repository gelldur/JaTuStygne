package pl.jatustygne;

import com.sensoro.beacon.kit.Beacon;
import com.sensoro.beacon.kit.BeaconManagerListener;

import java.util.ArrayList;

import pl.jatustygne.bus.EventCofeeTemperature;
import pl.jatustygne.bus.GlobalEventBus;

/**
 * Created by Dawid Drozd aka Gelldur on 11/18/15.
 */
public class BeaconListener implements BeaconManagerListener {
	@Override
	public void onNewBeacon(final Beacon beacon) {
	}

	@Override
	public void onGoneBeacon(final Beacon beacon) {
	}

	@Override
	public void onUpdateBeacon(final ArrayList<Beacon> arrayList) {
		for (Beacon beacon : arrayList) {
			if (beacon.getMacAddress().equalsIgnoreCase("01:17:C5:56:33:D4")) {
				System.out.println("Temperature: " + beacon.getTemperature());
				GlobalEventBus.getInstance().postSticky(new EventCofeeTemperature(beacon.getTemperature()));
			}
		}
	}
}
