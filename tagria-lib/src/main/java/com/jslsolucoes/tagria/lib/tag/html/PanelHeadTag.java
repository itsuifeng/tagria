
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.H3;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class PanelHeadTag extends SimpleTagSupport {

	private String label = "";

	@Override
	public void doTag() throws JspException, IOException {
		Div div = new Div();
		div.add(Attribute.CLASS, "panel-heading");
		H3 h3 = new H3();
		h3.add(Attribute.CLASS, "panel-title");
		if (!StringUtils.isEmpty(label)) {
			h3.add(TagUtil.getLocalized(label, getJspContext()));
		} else {
			h3.add(TagUtil.getBody(getJspBody()));
		}
		div.add(h3);
		TagUtil.out(getJspContext(), div);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
