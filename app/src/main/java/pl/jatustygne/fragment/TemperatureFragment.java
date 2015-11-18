package pl.jatustygne.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar;

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

		return floatRangeSeekBar;
	}
}
