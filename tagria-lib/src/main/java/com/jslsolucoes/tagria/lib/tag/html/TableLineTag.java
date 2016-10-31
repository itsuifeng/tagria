package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Tr;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TableLineTag extends SimpleTagSupport {
	private Boolean rendered = true;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			Tr tr = new Tr();
			tr.add(TagUtil.getBody(getJspBody()));
			TagUtil.out(getJspContext(), tr);
		}
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}
}
