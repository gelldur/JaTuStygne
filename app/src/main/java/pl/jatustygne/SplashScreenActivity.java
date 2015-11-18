package pl.jatustygne;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

/**
 * Created by Dawid Drozd aka Gelldur on 11/18/15.
 */
public class SplashScreenActivity extends Activity {

	@Override
	protected void onResume() {
		super.onResume();
		setContentView(R.layout.splashscreen);

		_handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				startActivity(new Intent(SplashScreenActivity.this, CupChoiceActivity.class));
				finish();
			}
		}, 3000);
	}

	private Handler _handler = new Handler();
}
