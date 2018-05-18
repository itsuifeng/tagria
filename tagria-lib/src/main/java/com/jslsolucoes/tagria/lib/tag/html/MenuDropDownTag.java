package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.A;
import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Li;
import com.jslsolucoes.tagria.lib.html.Span;
import com.jslsolucoes.tagria.lib.html.Ul;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class MenuDropDownTag extends SimpleTagSupport {
	
	private String align;
	private String label;
	private Boolean rendered = Boolean.TRUE;
	
	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			Ul ul = new Ul();
			ul.add(Attribute.CLASS, "nav navbar-nav");
			if (!StringUtils.isEmpty(align)) {
				ul.add(Attribute.CLASS, "navbar-" + align);
			}
			
			Li li = new Li();
			li.add(Attribute.CLASS, "dropdown");
			
			A a = new A();
			a.add(Attribute.HREF, "#");
			a.add(Attribute.CLASS, "dropdown-toggle");
			a.add(Attribute.DATA_TOGGLE,"dropdown");
			a.add(TagUtil.getLocalized(label, getJspContext()));
			a.add(" ");
			
			Span spanCaret = new Span();
			spanCaret.add(Attribute.CLASS, "caret");
			a.add(spanCaret);
			
			li.add(a);
			li.add(Ul.newBuilder().add(Attribute.CLASS, "dropdown-menu").add(TagUtil.getBody(getJspBody())));
			ul.add(li);
			TagUtil.out(getJspContext(), ul);
		}
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}	
}