
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TreeViewNodeSelectTag extends SimpleTagSupport {

	private String id;
	private String text;

	@Override
	public void doTag() throws JspException, IOException {
		TreeViewTag treeView = (TreeViewTag) findAncestorWithClass(this, TreeViewTag.class);
		treeView.getIds().add(id);
		treeView.getTexts().add(text);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
