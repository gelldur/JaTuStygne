package pl.jatustygne;

import android.content.Intent;
import android.os.Bundle;

import org.joda.time.DateTime;

import java.util.Date;

import pl.jatustygne.BaseActivity;
import pl.jatustygne.DrinkChoiceActivity;
import pl.jatustygne.R;
import pl.jatustygne.bus.EventCofeeTemperature;
import pl.jatustygne.bus.EventCoffeIsCold;
import pl.jatustygne.bus.EventCoffeIsGood;
import pl.jatustygne.bus.EventCoffeToHot;
import pl.jatustygne.bus.GlobalEventBus;

public class HotDrinkActivity extends BaseActivity {

	private DateTime createTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hot_drink);
		createTime = new DateTime();
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
		if(new DateTime().isAfter(createTime.plusMinutes(1))) {
			startActivity(new Intent(this, GoodDrinkActivity.class));
		}
	}

	public void onEvent(EventCoffeToHot event) {

	}
}
