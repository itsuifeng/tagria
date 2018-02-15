
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TooltipTag extends SimpleTagSupport {

	private String label;
	private String attachTo;
	private String attachToSelector;
	private Boolean rendered = Boolean.TRUE;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			Script script = new Script();
			script.add(Attribute.TYPE, "text/javascript");
			script.add(
					"$('" + attachTo() + "').popover({ content : '" + content()
							+ "',trigger : 'hover',html : true,placement : 'bottom',container : 'body' });");
			TagUtil.out(getJspContext(), script);
		}
	}
	
	private String content() throws JspException, IOException {
		if (!StringUtils.isEmpty(label)) {
			return TagUtil.getLocalized(label, getJspContext());
		} else {
			return TagUtil.getBody(getJspBody());
		}
	}

	private String attachTo() {
		if(StringUtils.isEmpty(attachToSelector)){
			return "#" + TagUtil.getId(attachTo, null, this);
		} 
		return attachToSelector;
	}

	public String getAttachTo() {
		return attachTo;
	}

	public void setAttachTo(String attachTo) {
		this.attachTo = attachTo;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public String getAttachToSelector() {
		return attachToSelector;
	}

	public void setAttachToSelector(String attachToSelector) {
		this.attachToSelector = attachToSelector;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}