package pl.jatustygne;

import android.content.Intent;
import android.os.Bundle;

import pl.jatustygne.bus.EventCofeeTemperature;
import pl.jatustygne.bus.EventCoffeIsCold;
import pl.jatustygne.bus.EventCoffeIsGood;
import pl.jatustygne.bus.EventCoffeToHot;
import pl.jatustygne.bus.GlobalEventBus;

public class GoodDrinkActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.good_drink);
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
		startActivity(new Intent(this, ColdDrinkActivity.class));
	}

	public void onEvent(EventCoffeIsGood event) {

	}

	public void onEvent(EventCoffeToHot event) {
		startActivity(new Intent(this, HotDrinkActivity.class));
	}
}
