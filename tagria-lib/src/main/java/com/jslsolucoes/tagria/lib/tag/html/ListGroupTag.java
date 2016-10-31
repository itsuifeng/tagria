package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Ul;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ListGroupTag extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		Ul ul = new Ul();
		ul.add(Attribute.CLASS,"list-group");
		ul.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), ul);
	}

}
