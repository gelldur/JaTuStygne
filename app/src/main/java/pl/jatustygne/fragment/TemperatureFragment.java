package pl.jatustygne.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar;

import java.util.Random;

/**
 * Created by Dawid Drozd aka Gelldur on 11/18/15.
 */
public class TemperatureFragment extends Fragment {
	@Nullable
	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
							 final Bundle savedInstanceState) {
		final RangeSeekBar<Float> floatRangeSeekBar = new RangeSeekBar<>(getActivity());
		floatRangeSeekBar.setRangeValues(30.F, 100.F);
		floatRangeSeekBar.setColorFilter(Color.BLACK);
		Random random = new Random();
		float rand1 = random.nextFloat() % 100 + 30;
		float rand2 = random.nextFloat() % 100 + 30;
		floatRangeSeekBar.setSelectedMinValue(rand1 < rand2 ? rand1 : rand2);
		floatRangeSeekBar.setSelectedMaxValue(rand1 < rand2 ? rand2 : rand1);
//		floatRangeSeekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Float>() {
//			@Override
//			public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Float minValue, Float maxValue) {
//				SharedPreferences sharedPreferences = getActivity().getSharedPreferences("pl.jatustygne", Context.MODE_PRIVATE);
//				sharedPreferences.edit().putFloat(minValName(), minValue).putFloat(maxValName(), maxValue);
//			}
//		});
		return floatRangeSeekBar;
	}

//	protected abstract String minValName();
//	protected abstract String maxValName();
}
