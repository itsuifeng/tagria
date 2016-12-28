package com.jslsolucoes.tagria.lib.chart;

import java.util.ArrayList;
import java.util.List;

public class PieDataSet {

	private List<PieDataSetItem> items = new ArrayList<PieDataSetItem>();

	public PieDataSet add(PieDataSetItem pieDataSetSlice){
		items.add(pieDataSetSlice);
		return this;
	}

	public List<PieDataSetItem> getItems() {
		return items;
	}

	public void setItems(List<PieDataSetItem> items) {
		this.items = items;
	}

}
