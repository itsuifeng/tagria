package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Style;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CssCodeTag extends SimpleTagSupport {

	
	@Override
	public void doTag() throws JspException, IOException {
			Style style = new Style();
			style.add(Attribute.TYPE, "text/css");
			style.add(TagUtil.getBody(getJspBody()));
			TagUtil.out(getJspContext(), style);
	}
}
