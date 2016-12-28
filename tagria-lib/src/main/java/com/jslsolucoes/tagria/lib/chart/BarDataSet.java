package com.jslsolucoes.tagria.lib.chart;

import java.util.ArrayList;
import java.util.List;

public class BarDataSet {

	private List<BarDataSetItem> items = new ArrayList<BarDataSetItem>();

	public BarDataSet add(BarDataSetItem barDataSetItem){
		items.add(barDataSetItem);
		return this;
	}

	public List<BarDataSetItem> getItems() {
		return items;
	}

	public void setItems(List<BarDataSetItem> items) {
		this.items = items;
	}
}
