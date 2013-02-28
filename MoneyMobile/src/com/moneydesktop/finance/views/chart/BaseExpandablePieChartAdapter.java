package com.moneydesktop.finance.views.chart;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

public abstract class BaseExpandablePieChartAdapter extends BaseExpandableListAdapter {

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		throw new RuntimeException("No child view required");
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		throw new RuntimeException("No group view required");
	}

	public abstract float getChildAmount(int groupPosition, int childPosition);
	public abstract float getGroupAmount(int groupPosition);
}
