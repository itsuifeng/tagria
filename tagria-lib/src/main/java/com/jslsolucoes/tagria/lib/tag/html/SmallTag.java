
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Small;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class SmallTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		Small small = new Small();
		small.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), small);
	}

}
