package com.jslsolucoes.tagria.lib.chart;

import java.util.ArrayList;
import java.util.List;

public class BarChartDataSet {

	private String label;
	private List<String> backgroundColor = new ArrayList<>();
	private List<String> borderColor = new ArrayList<>();
	private Integer borderWidth = 1;
	private List<Long> data = new ArrayList<>();

	public void addData(Long data) {
		this.data.add(data);
		this.backgroundColor.add(ChartUtil.backgroundColor());
		this.borderColor.add(ChartUtil.backgroundColor());
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<String> getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(List<String> backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public List<String> getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(List<String> borderColor) {
		this.borderColor = borderColor;
	}

	public Integer getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(Integer borderWidth) {
		this.borderWidth = borderWidth;
	}

	public List<Long> getData() {
		return data;
	}

	public void setData(List<Long> data) {
		this.data = data;
	}
}
