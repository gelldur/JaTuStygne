package pl.jatustygne;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import pl.jatustygne.bus.EventCofeeTemperature;
import pl.jatustygne.bus.EventCoffeIsCold;
import pl.jatustygne.bus.EventCoffeIsGood;
import pl.jatustygne.bus.EventCoffeToHot;
import pl.jatustygne.bus.GlobalEventBus;

public class DrinkChoiceActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drink_choice);
		RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton);
		RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
		RadioButton radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
		RadioButton radioButton4 = (RadioButton) findViewById(R.id.radioButton4);

		CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				startActivity(new Intent(DrinkChoiceActivity.this, HotDrinkActivity.class));
			}
		};

		radioButton1.setOnCheckedChangeListener(listener);
		radioButton2.setOnCheckedChangeListener(listener);
		radioButton3.setOnCheckedChangeListener(listener);
		radioButton4.setOnCheckedChangeListener(listener);
	}

	@Override
	protected void onResume() {
		super.onResume();
		GlobalEventBus.getInstance().register(this);
	}

	@Override
	protected void onPause() {
		GlobalEventBus.getInstance().unregister(this);
		super.onPause();
	}

	public void onEvent(EventCofeeTemperature event) {

	}

	public void onEvent(EventCoffeIsCold event) {

	}

	public void onEvent(EventCoffeIsGood event) {
	}

	public void onEvent(EventCoffeToHot event) {

	}
}
