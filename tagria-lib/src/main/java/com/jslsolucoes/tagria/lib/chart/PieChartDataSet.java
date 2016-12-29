package com.jslsolucoes.tagria.lib.chart;

import java.util.ArrayList;
import java.util.List;

public class PieChartDataSet {

	private List<String> backgroundColor = new ArrayList<String>();
	private List<String> hoverBackgroundColor = new ArrayList<String>();
	private List<Long> data = new ArrayList<Long>();
	
	public void addData(Long data){
		this.data.add(data);
		this.backgroundColor.add(ChartUtil.backgroundColor());
		this.hoverBackgroundColor.add(ChartUtil.backgroundColor());
	}
	
	public List<String> getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(List<String> backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
	public List<Long> getData() {
		return data;
	}
	public void setData(List<Long> data) {
		this.data = data;
	}

	public List<String> getHoverBackgroundColor() {
		return hoverBackgroundColor;
	}

	public void setHoverBackgroundColor(List<String> hoverBackgroundColor) {
		this.hoverBackgroundColor = hoverBackgroundColor;
	}
}
