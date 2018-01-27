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
	private Boolean readOnly = Boolean.FALSE;
	private Boolean required = Boolean.FALSE;

	@Override
	public void doTag() throws JspException, IOException {
		Textarea textarea = new Textarea();
		textarea.add(Attribute.NAME, name);
		textarea.add(Attribute.ID, TagUtil.getId(name, null, this));
		textarea.add(TagUtil.getBody(getJspBody()));

		if (required) {
			textarea.add(Attribute.CLASS, "bs-syntax-highlight-required");
		}

		TagUtil.out(getJspContext(), textarea);

		Script script = new Script();
		script.add(Attribute.TYPE, "text/javascript");
		script.add("CodeMirror.fromTextArea(document.getElementById('" + textarea.get(Attribute.ID) + "'), {"
				+ "mode: '" + language + "'," + "indentWithTabs: true," + "smartIndent: true," + "lineNumbers: true,"
				+ "readOnly : " + (readOnly ? "'nocursor'" : "false") + "," + "matchBrackets : true"
				+ "}).on('change',function(cm){ $('#" + textarea.get(Attribute.ID) + "').val(cm.getValue());  });");
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

	public Boolean getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(Boolean readOnly) {
		this.readOnly = readOnly;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}
}