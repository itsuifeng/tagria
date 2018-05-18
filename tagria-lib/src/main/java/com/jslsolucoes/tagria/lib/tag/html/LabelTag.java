
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Label;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class LabelTag extends SimpleTagSupport {

	private String id;
	private String label;
	private Boolean rendered = Boolean.TRUE;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			Label component = new Label();
			component.add(Attribute.ID, TagUtil.getId(id));
			if (!StringUtils.isEmpty(label)) {
				component.add(TagUtil.getLocalized(label, getJspContext()));
			} else {
				component.add(TagUtil.getBody(getJspBody()));
			}
			TagUtil.out(getJspContext(), component);
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
