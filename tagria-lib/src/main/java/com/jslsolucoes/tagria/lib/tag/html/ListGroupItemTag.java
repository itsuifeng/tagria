package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Li;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ListGroupItemTag extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		Li li = new Li();
		li.add(Attribute.CLASS,"list-group-item");
		li.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), li);
	}

}
