
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ColTag extends SimpleTagSupport {

	private Integer size;

	@Override
	public void doTag() throws JspException, IOException {
		Div div = new Div();
		div.add(Attribute.CLASS, "col-xs-" + size);
		div.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), div);
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

}
