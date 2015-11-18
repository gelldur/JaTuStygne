package pl.jatustygne;

import android.app.Application;

import com.sensoro.beacon.kit.SensoroBeaconManager;

/**
 * Created by Dawid Drozd aka Gelldur on 11/18/15.
 */
public class JaTuStygneApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		final SensoroBeaconManager sensoroBeaconManager = SensoroBeaconManager.getInstance(this);
		if (sensoroBeaconManager.isBluetoothEnabled()) {
			try {
				sensoroBeaconManager.startService();
				sensoroBeaconManager.setBeaconManagerListener(new BeaconListener());
			} catch (Exception e) {
				e.printStackTrace(); // Fetch abnormal info
			}
		}
	}
}
