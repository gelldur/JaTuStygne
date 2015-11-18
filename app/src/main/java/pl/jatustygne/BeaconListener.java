package pl.jatustygne;

import android.util.Log;

import com.sensoro.beacon.kit.Beacon;
import com.sensoro.beacon.kit.BeaconManagerListener;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

import pl.jatustygne.bus.EventCofeeTemperature;
import pl.jatustygne.bus.EventCoffeIsCold;
import pl.jatustygne.bus.EventCoffeIsGood;
import pl.jatustygne.bus.EventCoffeToHot;
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
		System.out.println("Beacons: " + arrayList.size());
		for (Beacon beacon : arrayList) {
//			System.out.println(beacon.getProximityUUID());
//			if (beacon.getMacAddress().equalsIgnoreCase("01:17:C5:56:33:D4") == false) {
			if (beacon.getSerialNumber().equalsIgnoreCase("0117C55633d4") == false) {
				continue;
			}
			System.out.println("Beacon temperature: " + beacon.getTemperature());

			final Integer temperature = beacon.getTemperature();
			if (temperature == null) {
				return;
			}

			_temperatureSample.addLast(Float.valueOf(temperature));
			if (_temperatureSample.size() > 10) {
				_temperatureSample.removeFirst();
			}

			float sampledTemperature = 0;

			final Iterator<Float> iterator = _temperatureSample.iterator();
			while (iterator.hasNext()) {
				final Float sample = iterator.next();
				sampledTemperature += sample;
			}

			sampledTemperature /= _temperatureSample.size();

			System.out.println("Temperature: " + sampledTemperature);

			GlobalEventBus.getInstance().postSticky(new EventCofeeTemperature(sampledTemperature));

			Log.i("X",temperature + "[" + sampledTemperature + "]");

			if (sampledTemperature > 38) {
				GlobalEventBus.getInstance().postSticky(new EventCoffeToHot());

			} else if (sampledTemperature > 30) {
				GlobalEventBus.getInstance().postSticky(new EventCoffeIsGood());
			} else {
				GlobalEventBus.getInstance().postSticky(new EventCoffeIsCold());
			}
		}
	}

	private ArrayDeque<Float> _temperatureSample = new ArrayDeque<>(16);
}
