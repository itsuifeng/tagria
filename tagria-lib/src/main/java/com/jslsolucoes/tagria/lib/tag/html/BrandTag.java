package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.A;
import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class BrandTag extends SimpleTagSupport {

	private String url;
	private String label;
	
	@Override
	public void doTag() throws JspException, IOException {
		
		Div div = new Div();
		A a = new A();
		a.add(Attribute.CLASS,"navbar-brand");
		a.add(Attribute.HREF, TagUtil.getPathForUrl(getJspContext(), url));
		a.add(TagUtil.getLocalized(label));
		div.add(a);
		
		TagUtil.out(getJspContext(), div);
	}

	

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}
}
