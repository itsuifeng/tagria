
package com.jslsolucoes.tagria.lib.tag.html;

import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.util.TagUtil;

public class MaskTagOnKeyPress extends SimpleTagSupport {

	@Override
	public void doTag() throws javax.servlet.jsp.JspException, java.io.IOException {

		StringBuilder builder = new StringBuilder();
		builder.append(",onKeyPress: function(value, e, field, options){");
		builder.append(TagUtil.getBody(getJspBody()));
		builder.append("}");
		TagUtil.out(getJspContext(), builder.toString());

	}

}