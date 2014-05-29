
package com.blstream.myguide;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Piotrek on 2014-05-28.
 */
public class PreferencesFragment extends Fragment {

	private Spinner mSpLanguage;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_preferences, container,
				false);

		setHasOptionsMenu(true);
		setActionBar();

		mSpLanguage = (Spinner) view.findViewById(R.id.spLanguage);
		setUpSpinner();

		return view;
	}

	private void setActionBar() {
		if (getActivity().getActionBar() != null) {
			getActivity().getActionBar().setTitle(getString(R.string.preferences_title));
			getActivity().getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		}
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		MenuItem itemSearch = menu.findItem(R.id.action_search);
		MenuItem itemFilter = menu.findItem(R.id.action_filter);

		if (itemSearch != null) itemSearch.setVisible(false);
		if (itemFilter != null) itemFilter.setVisible(false);

		super.onCreateOptionsMenu(menu, inflater);
	}

	private void setUpSpinner() {
		ArrayAdapter<String> languageAdapter = new ArrayAdapter<String>(getActivity(),
				R.array.languages, android.R.layout.simple_spinner_item);

		mSpLanguage.setAdapter(languageAdapter);
	}
}
