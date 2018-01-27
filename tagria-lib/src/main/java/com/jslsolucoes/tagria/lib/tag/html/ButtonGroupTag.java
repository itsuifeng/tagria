
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ButtonGroupTag extends SimpleTagSupport {

	private Boolean spaced = Boolean.FALSE;

	@Override
	public void doTag() throws JspException, IOException {
		Div buttonGroup = new Div();
		buttonGroup.add(Attribute.CLASS, spaced ? "bs-button-group" : "btn-group");
		buttonGroup.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), buttonGroup);
	}

	public Boolean getSpaced() {
		return spaced;
	}

	public void setSpaced(Boolean spaced) {
		this.spaced = spaced;
	}
}
