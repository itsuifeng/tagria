package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class JsEventTag extends SimpleTagSupport {

	private String attachTo;
	private String event;
	
	@Override
	public void doTag() throws JspException, IOException {
			
			StringBuilder builder = new StringBuilder();
			builder.append("$('#" + TagUtil.getId(attachTo, null,this) + "')." + event + "(function(){");
			builder.append(TagUtil.getBody(getJspBody()));
			builder.append("});");
			
			Script script = new Script();
			script.add(Attribute.TYPE, "text/javascript");
			script.add(builder.toString());
			TagUtil.out(getJspContext(), script);
		
	}

	public String getAttachTo() {
		return attachTo;
	}

	public void setAttachTo(String attachTo) {
		this.attachTo = attachTo;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}


	
}
