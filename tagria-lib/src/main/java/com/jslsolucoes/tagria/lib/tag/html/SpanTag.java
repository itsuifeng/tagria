package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Span;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class SpanTag extends SimpleTagSupport {
	
	private String id;
	
	@Override
	public void doTag() throws JspException, IOException {
		Span span = new Span();
		span.add(Attribute.ID,TagUtil.getId(id));
		span.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), span);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
