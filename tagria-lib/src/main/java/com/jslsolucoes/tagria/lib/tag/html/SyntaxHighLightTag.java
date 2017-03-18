package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.html.Textarea;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class SyntaxHighLightTag extends SimpleTagSupport {

	private String name;
	private String language;

	@Override
	public void doTag() throws JspException, IOException {
		Textarea textarea = new Textarea();
		textarea.add(Attribute.NAME,name);
		textarea.add(Attribute.ID,TagUtil.getId(name, null,this));
		textarea.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), textarea);
		
		
		Script script = new Script();
		script.add(Attribute.TYPE, "text/javascript");
		script.add("CodeMirror.fromTextArea(document.getElementById('"+textarea.get(Attribute.ID)+"'), {"+
			    "mode: '"+language+"',"+
			    "lineNumbers: true "+
			 "});");
		TagUtil.out(getJspContext(), script);
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}