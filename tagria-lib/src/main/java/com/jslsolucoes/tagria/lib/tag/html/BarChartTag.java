package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.chart.BarDataSet;
import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Canvas;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class BarChartTag extends SimpleTagSupport {

	private Integer width = 400;
	private Integer height = 400;
	private Boolean responsive = Boolean.TRUE;
	private BarDataSet dataset;
	private String label;
	private Boolean horizontal = Boolean.FALSE;
	
	@Override
	public void doTag() throws JspException, IOException {
		
		Div container = new Div();
		if(!responsive){
			container.add(Attribute.STYLE,"width:"+width+"px;height:"+height+"px");
		}
		
		Canvas canvas = new Canvas();
		canvas.add(Attribute.ID,TagUtil.getId());
		container.add(canvas);
		
		TagUtil.out(getJspContext(), container);
		
		Script script = new Script();
		script.add(Attribute.TYPE, "text/javascript");
		script.add("new Chart(document.getElementById('"+canvas.get(Attribute.ID)+ "'), {		"+
		   "			type : '"+(horizontal ? "horizontalBar" : "bar")+"',					"+
		   "			data : {																"+
		   " 				labels: [															"+
						StringUtils.join(dataset
						.getItems()
						.stream()
						.map(slice -> "'"+slice.getLabel()+"'")
						.collect(Collectors.toSet())
						,",") +
		   " 				],																	"+
		   " 				datasets: [{														"+
		   "         			data: [															"+
		   				StringUtils.join(dataset
		   						.getItems()
		   						.stream()
		   						.map(slice -> slice.getData())
		   						.collect(Collectors.toSet()),",") +
		   "					],																"+
		   "         			backgroundColor: [												"+
						StringUtils.join(dataset
										.getItems()
											.stream()
											.map(slice -> "'"+slice.getBackgroundColor()+"'")
											.collect(Collectors.toSet()),",") +
		   "         			],																"+
		   "         			borderColor: [											"+
						   StringUtils.join(dataset
									.getItems()
										.stream()
										.map(slice -> "'"+slice.getBorderColor()+"'")
										.collect(Collectors.toSet()),",") +
		   "         			],																"+
		   "					borderWidth: 1													"+
		   "     			}]																	"+
		   "			},																		"+
	       "			options: {																	"+
		      (!StringUtils.isEmpty(label) ? 
		   "				title: {																"+
	       "      				display: true,														"+
	       "     				text: '"+TagUtil.getLocalized(label)+"'								"+
	       " 				}																		" : "")+
		   "			}																			"+   
		   "		});																			");
		
		TagUtil.out(getJspContext(), script);
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public BarDataSet getDataset() {
		return dataset;
	}

	public void setDataset(BarDataSet dataset) {
		this.dataset = dataset;
	}

	public Boolean getResponsive() {
		return responsive;
	}

	public void setResponsive(Boolean responsive) {
		this.responsive = responsive;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}


}
