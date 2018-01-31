
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ProgressBarTag extends SimpleTagSupport {

	private Boolean determinate = Boolean.FALSE;
	private Integer value = 0;

	@Override
	public void doTag() throws JspException, IOException {
		Div div = new Div();
		div.add(Attribute.ID, TagUtil.getId());
		div.add(Attribute.CLASS, "progress");
		Div progress = new Div();
		if (determinate) {
			progress.add(Attribute.CLASS, "determinate");
			progress.add(Attribute.STYLE, "width:" + value + "%");
		} else {
			progress.add(Attribute.CLASS, "indeterminate");
		}
		div.add(progress);
		TagUtil.out(getJspContext(), div);

	}

	public Boolean getDeterminate() {
		return determinate;
	}

	public void setDeterminate(Boolean determinate) {
		this.determinate = determinate;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
