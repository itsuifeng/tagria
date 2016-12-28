package com.jslsolucoes.tagria.lib.chart;

public class PieDataSetItem {

	private String label;
	private Long data;
	private String backgroundColor;
	private String hoverBackgroundColor;

	public PieDataSetItem() {
		
	}

	public PieDataSetItem(String label, Long data) {
		this(label, data, ChartUtil.backgroundColor(), ChartUtil.backgroundHoverColor());
	}

	public PieDataSetItem(String label, Long data, String backgroundColor, String hoverBackgroundColor) {
		this.label = label;
		this.data = data;
		this.backgroundColor = backgroundColor;
		this.hoverBackgroundColor = hoverBackgroundColor;
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

	public String getHoverBackgroundColor() {
		return hoverBackgroundColor;
	}

	public void setHoverBackgroundColor(String hoverBackgroundColor) {
		this.hoverBackgroundColor = hoverBackgroundColor;
	}
}
