package com.jslsolucoes.tagria.lib.chart;

public class BarDataSetItem {

	private String label;
	private Long data;
	private String backgroundColor;
	private String borderColor;

	public BarDataSetItem() {
		
	}

	public BarDataSetItem(String label, Long data) {
		this(label, data, ChartUtil.backgroundColor(), ChartUtil.borderColor());
	}

	public BarDataSetItem(String label, Long data, String backgroundColor, String borderColor) {
		this.label = label;
		this.data = data;
		this.backgroundColor = backgroundColor;
		this.borderColor = borderColor;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Long getData() {
		return data;
	}

	public void setData(Long data) {
		this.data = data;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public String getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}

	
}
