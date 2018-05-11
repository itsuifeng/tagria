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

public class MenuLinkTag extends SimpleTagSupport {

	private String align;
	private String url = "#";
	private String label;
	private String target = "_self";
	private String icon;
	private Boolean rendered = Boolean.TRUE;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			Ul ul = new Ul();
			ul.add(Attribute.CLASS, "nav navbar-nav");
			if (!StringUtils.isEmpty(align)) {
				ul.add(Attribute.CLASS, "navbar-" + align);
			}

			A a = new A();
			a.add(Attribute.HREF, TagUtil.getPathForUrl(getJspContext(), url));
			a.add(Attribute.TARGET, target);

			if (!StringUtils.isEmpty(icon)) {
				a.add(new Span().add(Attribute.CLASS, "glyphicon glyphicon-" + icon));
				a.add(" ");
			}

			if (!StringUtils.isEmpty(label)) {
				a.add(TagUtil.getLocalized(label, getJspContext()));
			} else {
				a.add(TagUtil.getBody(getJspBody()));
			}
			Li li = new Li();
			li.add(a);
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}
}
