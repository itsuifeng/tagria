package com.jslsolucoes.tagria.lib.chart;

import java.util.ArrayList;
import java.util.List;

public class PieChartData {

	private List<String> labels = new ArrayList<>();
	private List<PieChartDataSet> datasets = new ArrayList<>();

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public void addLabel(String label) {
		labels.add(label);
	}

	public void addDataSet(PieChartDataSet pieChartDataSet) {
		datasets.add(pieChartDataSet);
	}

	public List<PieChartDataSet> getDatasets() {
		return datasets;
	}

	public void setDatasets(List<PieChartDataSet> datasets) {
		this.datasets = datasets;
	}

}
