package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Table;
import com.jslsolucoes.tagria.lib.html.Tbody;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TableTag extends SimpleTagSupport {
	

	@Override
	public void doTag() throws JspException, IOException {
		Table table = new Table();
		table.add(Attribute.CLASS, "table border-primary rounded-corner");
		Tbody tbody = new Tbody();
		tbody.add(TagUtil.getBody(getJspBody()));
		table.add(tbody);
		TagUtil.out(getJspContext(), table);
	}
	
}
