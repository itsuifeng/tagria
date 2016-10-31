package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Button;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.Span;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class AlertTag extends SimpleTagSupport {

	private Boolean dismissible = Boolean.FALSE;
	private Boolean rendered = Boolean.TRUE;
	private String state;
	
	@Override
	public void doTag() throws JspException, IOException {
		if(rendered){
			Div div = new Div();
			div.add(Attribute.CLASS,"alert alert-"+state);
			div.add(Attribute.ROLE,"alert");
			if(dismissible){
				div.add(Attribute.CLASS,"alert-dismissible");
				Button button = new Button();
				button.add(Attribute.TYPE,"button");
				button.add(Attribute.CLASS,"close");
				button.add(Attribute.DATA_DISMISS,"alert");
				
				Span span = new Span();
				span.add("&times;");
				
				button.add(span);
				div.add(button);
			}
			div.add(TagUtil.getBody(getJspBody()));
			TagUtil.out(getJspContext(), div);
		}
	}


	public Boolean getDismissible() {
		return dismissible;
	}


	public void setDismissible(Boolean dismissible) {
		this.dismissible = dismissible;
	}


	public Boolean getRendered() {
		return rendered;
	}


	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}
}
