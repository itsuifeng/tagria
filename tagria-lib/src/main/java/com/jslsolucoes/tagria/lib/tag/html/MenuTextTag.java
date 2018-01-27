
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.P;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class MenuTextTag extends SimpleTagSupport {

	private String align;
	private String id;

	@Override
	public void doTag() throws JspException, IOException {
		P p = new P();
		p.add(Attribute.ID, TagUtil.getId(id));
		p.add(Attribute.CLASS, "navbar-text");
		if (!StringUtils.isEmpty(align)) {
			p.add(Attribute.CLASS, "navbar-" + align);
		}
		p.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), p);
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
