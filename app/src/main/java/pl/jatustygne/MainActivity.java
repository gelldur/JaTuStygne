package pl.jatustygne;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sensoro.beacon.kit.Beacon;
import com.sensoro.beacon.kit.BeaconManagerListener;
import com.sensoro.beacon.kit.SensoroBeaconManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		SensoroBeaconManager sensoroBeaconManager = SensoroBeaconManager.getInstance(getApplicationContext());
		if (sensoroBeaconManager.isBluetoothEnabled()) {
			try {
				sensoroBeaconManager.startService();
			} catch (Exception e) {
				e.printStackTrace(); // Fetch abnormal info
			}
		}

		BeaconManagerListener beaconManagerListener = new BeaconManagerListener() {

			@Override
			public void onUpdateBeacon(ArrayList<Beacon> beacons) {
				System.out.println("~~~~~~~~ I have beacons: " + beacons.size());
				for (Beacon beacon : beacons) {
					System.out.println(beacon.toString());
				}
				System.out.println("");
			}

			@Override
			public void onNewBeacon(Beacon beacon) {
				System.out.println("~~~~~~~~ New beacon");
				System.out.println(beacon.toString());
				System.out.println("");
			}

			@Override
			public void onGoneBeacon(Beacon beacon) {
				System.out.println("~~~~~~~~ Beacon gone!");
				System.out.println(beacon.toString());
				System.out.println("");
			}
		};
		sensoroBeaconManager.setBeaconManagerListener(beaconManagerListener);
	}
}
