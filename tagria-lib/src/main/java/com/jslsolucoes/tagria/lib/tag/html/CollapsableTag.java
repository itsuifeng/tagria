package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.A;
import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.H3;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CollapsableTag extends SimpleTagSupport {

	private String label;
	private String state = "primary";

	@Override
	public void doTag() throws JspException, IOException {
		
		String id = TagUtil.getId();
		
		Div panel = new Div();
		panel.add(Attribute.CLASS, "panel panel-"+state);

		Div panelHead = new Div();
		panelHead.add(Attribute.CLASS, "panel-heading");
		H3 h3 = new H3();
		h3.add(Attribute.CLASS, "panel-title");
		A a  = new A();
		a.add(Attribute.HREF,"#"+id);
		a.add(Attribute.DATA_TOGGLE,"collapse");
		a.add(TagUtil.getLocalized(label));
		h3.add(a);
		panelHead.add(h3);
		panel.add(panelHead);
		
		Div content = new Div();
		content.add(Attribute.ID,id);
		content.add(Attribute.CLASS,"panel-collapse collapse");

		Div panelBody = new Div();
		panelBody.add(Attribute.CLASS, "panel-body");
		panelBody.add(TagUtil.getBody(getJspBody()));
		
		content.add(panelBody);
		panel.add(content);

		TagUtil.out(getJspContext(), panel);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}