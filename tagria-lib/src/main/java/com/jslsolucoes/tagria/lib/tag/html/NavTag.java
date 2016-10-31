package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Nav;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class NavTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		
		Nav nav = new Nav();
		nav.add(Attribute.CLASS,"navbar navbar-default");
		nav.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), nav);
	}
}
