
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Iframe;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class IframeTag extends SimpleTagSupport {

	private String name;
	private String id;
	private String url;

	@Override
	public void doTag() throws JspException, IOException {
		Iframe iframe = new Iframe();
		iframe.add(Attribute.CLASS,"bs-iframe");
		iframe.add(Attribute.NAME, name);
		iframe.add(Attribute.ID, TagUtil.getId(name, id));
		iframe.add(Attribute.SRC, TagUtil.getPathForUrl(getJspContext(), url));
		TagUtil.out(getJspContext(), iframe);

		Script script = new Script();
		script.add(Attribute.TYPE, "text/javascript");
		script.add("$('#" + iframe.get(Attribute.ID) + "').iframe();");
		TagUtil.out(getJspContext(), script);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
