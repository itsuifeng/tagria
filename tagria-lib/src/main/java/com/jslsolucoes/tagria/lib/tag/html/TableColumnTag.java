
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Td;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TableColumnTag extends SimpleTagSupport {

	private Boolean header = Boolean.FALSE;
	private Integer colspan;
	private String format;
	private String label;

	@Override
	public void doTag() throws JspException, IOException {
		Td td = new Td();
		if (header) {
			td.add(Attribute.CLASS, "bg-primary");
		}
		if (colspan != null) {
			td.add(Attribute.COLSPAN, colspan);
		}

		if (!StringUtils.isEmpty(label)) {
			td.add(TagUtil.getLocalized(label, getJspContext()));
		} else {
			String body = TagUtil.getBody(getJspBody());
			if (!StringUtils.isEmpty(format)) {
				body = TagUtil.format(format, body, getJspContext());
			}
			td.add(body);
		}
		TagUtil.out(getJspContext(), td);
	}

	public Boolean getHeader() {
		return header;
	}

	public void setHeader(Boolean header) {
		this.header = header;
	}

	public Integer getColspan() {
		return colspan;
	}

	public void setColspan(Integer colspan) {
		this.colspan = colspan;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
