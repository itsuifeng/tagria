package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Span;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class IconTag extends SimpleTagSupport {

	private String icon;

	@Override
	public void doTag() throws JspException, IOException {
		Span span = new Span();
		span.add(Attribute.CLASS, "glyphicon glyphicon-" + icon);
		TagUtil.out(getJspContext(), span);
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
