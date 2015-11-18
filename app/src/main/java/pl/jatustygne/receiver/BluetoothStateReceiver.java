package pl.jatustygne.receiver;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.sensoro.beacon.kit.SensoroBeaconManager;

import pl.jatustygne.BeaconListener;

/**
 * Created by Dawid Drozd aka Gelldur on 11/18/15.
 */
public class BluetoothStateReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(final Context context, final Intent intent) {
		final String action = intent.getAction();
		if (BluetoothAdapter.ACTION_STATE_CHANGED.equals(action) == false) {
			return;
		}

		final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, -1);
		final SensoroBeaconManager sensoroBeaconManager = SensoroBeaconManager.getInstance(context);

		if (state == BluetoothAdapter.STATE_OFF || state == BluetoothAdapter.STATE_TURNING_OFF) {
			sensoroBeaconManager.stopService();
		} else if (intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, -1) == BluetoothAdapter.STATE_ON) {
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
}
