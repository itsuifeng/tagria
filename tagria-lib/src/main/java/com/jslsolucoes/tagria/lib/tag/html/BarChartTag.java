package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.chart.BarChartData;
import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Canvas;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class BarChartTag extends SimpleTagSupport {

	private Integer width = 400;
	private Integer height = 400;
	private Boolean responsive = Boolean.TRUE;
	private BarChartData dataset;
	private String label;
	private Boolean horizontal = Boolean.FALSE;
	private Boolean rendered = Boolean.TRUE;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			Div container = new Div();
			if (!responsive) {
				container.add(Attribute.STYLE, "width:" + width + "px;height:" + height + "px");
			}
			Canvas canvas = new Canvas();
			canvas.add(Attribute.ID, TagUtil.getId());
			container.add(canvas);
			TagUtil.out(getJspContext(), container);

			Script script = new Script();
			script.add(Attribute.TYPE, "text/javascript");
			script.add("new Chart(document.getElementById('" + canvas.get(Attribute.ID) + "'), {		"
					+ "			type : '" + (horizontal ? "horizontalBar" : "bar") + "',					"
					+ "			data : {																"
					+ " 				labels: [															"
					+ StringUtils.join(dataset.getLabels().stream().map(datasetLabel -> "'" + datasetLabel + "'")
							.collect(Collectors.toList()), ",")
					+ " 				],																	"
					+ " 				datasets: [															" +

					StringUtils.join(dataset.getDatasets().stream()
							.map(datasetGroup -> "{" + "         		label: '"
									+ TagUtil.getLocalized(datasetGroup.getLabel(), getJspContext()) + "',		"
									+ "         		data: [																"
									+ StringUtils.join(datasetGroup.getData(), ",")
									+ "					],																"
									+ "         			backgroundColor: [												"
									+ StringUtils.join(datasetGroup.getBackgroundColor().stream()
											.map(color -> "'" + color + "'").collect(Collectors.toList()), ",")
									+ "         			],																"
									+ "         			borderColor: [													"
									+ StringUtils.join(datasetGroup.getBorderColor().stream()
											.map(color -> "'" + color + "'").collect(Collectors.toList()), ",")
									+ "         			],																"
									+ "					borderWidth: " + datasetGroup.getBorderWidth()
									+ "			}																		")
							.collect(Collectors.toList()), ",")
					+ "     			]																				"
					+ "			},																					"
					+ "			options: {																			"
					+ (!StringUtils.isEmpty(label)
							? "				title: {																		"
									+ "      				display: true,																"
									+ "     				text: '" + TagUtil.getLocalized(label, getJspContext())
									+ "'										"
									+ " 				}																				"
							: "")
					+ "			}																					"
					+ "		});																						");

			TagUtil.out(getJspContext(), script);
		}
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

	public BarChartData getDataset() {
		return dataset;
	}

	public void setDataset(BarChartData dataset) {
		this.dataset = dataset;
	}

	public Boolean getHorizontal() {
		return horizontal;
	}

	public void setHorizontal(Boolean horizontal) {
		this.horizontal = horizontal;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

}
