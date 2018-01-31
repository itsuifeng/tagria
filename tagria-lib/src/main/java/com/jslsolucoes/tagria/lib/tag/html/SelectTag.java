
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Option;
import com.jslsolucoes.tagria.lib.html.Select;
import com.jslsolucoes.tagria.lib.util.TagUtil;

@SuppressWarnings("rawtypes")
public class SelectTag extends SimpleTagSupport {

	private Collection data;
	private String name;
	private String value;
	private String var;
	private Boolean required = Boolean.FALSE;
	private String cssClass;

	@Override
	public void doTag() throws JspException, IOException {

		Select select = new Select();
		select.add(Attribute.ID, TagUtil.getId(name, null, this));
		select.add(Attribute.NAME, name);
		select.add(new Option().add(Attribute.VALUE, "").add("- - -"));
		if (required) {
			select.add(Attribute.CLASS, "bs-input-required");
			select.add(Attribute.REQUIRED, "required");
		}
		select.add(Attribute.CLASS, "form-control");

		if (!StringUtils.isEmpty(cssClass)) {
			select.add(Attribute.CLASS, cssClass);
		}

		if (!CollectionUtils.isEmpty(data)) {
			for (Object item : data) {
				getJspContext().setAttribute(var, item);
				select.add(TagUtil.getBody(getJspBody()));
			}
			getJspContext().setAttribute(var, null);
		}
		TagUtil.out(getJspContext(), select);
	}

	public Collection getData() {
		return data;
	}

	public void setData(Collection data) {
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

}
