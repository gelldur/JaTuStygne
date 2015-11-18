package pl.jatustygne;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import pl.jatustygne.bus.EventCofeeTemperature;
import pl.jatustygne.bus.EventCoffeIsCold;
import pl.jatustygne.bus.EventCoffeIsGood;
import pl.jatustygne.bus.EventCoffeToHot;
import pl.jatustygne.bus.GlobalEventBus;

public class ColdDrinkActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cold_drink);
		ImageView image = (ImageView) findViewById(R.id.imageView3);
		image.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(ColdDrinkActivity.this, EmptyCupActivity.class));
			}
		});
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
		startActivity(new Intent(this, GoodDrinkActivity.class));
	}

	public void onEvent(EventCoffeToHot event) {
		startActivity(new Intent(this, HotDrinkActivity.class));
	}
}
