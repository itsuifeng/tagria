
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Li;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class MenuSeparatorTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		Li li = new Li();
		li.add(Attribute.CLASS, "divider");
		TagUtil.out(getJspContext(), li);
	}

}
