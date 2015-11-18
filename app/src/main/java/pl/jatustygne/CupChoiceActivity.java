package pl.jatustygne;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.sensoro.beacon.kit.Beacon;

public class CupChoiceActivity extends Activity {
    // XML node keys
    static final String KEY_ID = "id";
    static final String KEY_NAME = "title";
    static final String KEY_UUID = "artist";

    ListView list;
    ListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cup_choice);

        ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();

        ArrayList<Beacon> beacons = BeaconListener.getBeacons();


        int i = 1;
        for (Beacon beacon : beacons) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put(KEY_ID, "AA");

            if(beacon.getSerialNumber().equalsIgnoreCase("0117C55633d4")) {
                map.put(KEY_NAME, "Ja tu stygnę!");
            } else {
                map.put(KEY_NAME, "Kubek "+i);
                i++;
            }
            map.put(KEY_UUID, beacon.getSerialNumber());
            songsList.add(map);
        }

        // adding HashList to ArrayList



        list=(ListView)findViewById(R.id.listView);

        // Getting adapter by passing xml data ArrayList
        adapter=new ListAdapter(this, songsList);
        list.setAdapter(adapter);

        // Click event for single list row
        list.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String, String> cup = (HashMap<String, String>) adapter.getItem(position);
                if(cup.get(KEY_UUID).equalsIgnoreCase("0117C55633d4")) {
                    startActivity(new Intent(CupChoiceActivity.this, EmptyCupActivity.class));
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Nie kradnij cudzych kubków!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
