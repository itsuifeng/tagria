package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CarouselTag extends SimpleTagSupport {

	
	private String id;
	
	@Override
	public void doTag() throws JspException, IOException {
		
		Div div = new Div();
		div.add(Attribute.ID,TagUtil.getId(id));
		div.add(Attribute.CLASS,"carousel slide");
		div.add(Attribute.DATA_RIDE,"carousel");
		
		Div inner = new Div();
		inner.add(Attribute.CLASS,"carousel-inner");
		inner.add(TagUtil.getBody(getJspBody()));
		
		div.add(inner);
		TagUtil.out(getJspContext(), div);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}