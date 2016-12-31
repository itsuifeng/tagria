package com.jslsolucoes.tagria.lib.chart;

import java.util.ArrayList;
import java.util.List;

public class BarChartData {

	private List<String> labels = new ArrayList<String>();
	private List<BarChartDataSet> datasets = new ArrayList<BarChartDataSet>();
	
	public List<String> getLabels() {
		return labels;
	}
	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
	public List<BarChartDataSet> getDatasets() {
		return datasets;
	}
	public void setDatasets(List<BarChartDataSet> datasets) {
		this.datasets = datasets;
	}
	
	public void addLabel(String label){
		labels.add(label);
	}
	
	public void addDataSet(BarChartDataSet barChartDataSet){
		datasets.add(barChartDataSet);
	}
}
