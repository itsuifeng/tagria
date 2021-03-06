
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.A;
import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.Iframe;
import com.jslsolucoes.tagria.lib.html.Li;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TabTag extends SimpleTagSupport {

	private String label;
	private String url;
	private String state = "default";
	private Boolean rendered = Boolean.TRUE;
	private Boolean active = Boolean.FALSE;
	private Boolean reloadOnSelect = Boolean.TRUE;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			TabPanelTag panel = (TabPanelTag) findAncestorWithClass(this, TabPanelTag.class);

			String id = TagUtil.getId();
			Li li = new Li();
			if (reloadOnSelect) {
				li.add(Attribute.CLASS, "ui-tabs-reload-on-select");
			}
			if (active) {
				li.add(Attribute.CLASS, "active");
			}
			li.add(Attribute.CLASS, "tab-" + state);
			
			
			A a = new A();
			a.add(Attribute.HREF, "#" + id);
			a.add(Attribute.DATA_TOGGLE, "tab");
			a.add(TagUtil.getLocalized(label, getJspContext()));
			li.add(a);

			panel.addLi(li);

			Div div = new Div();
			div.add(Attribute.CLASS, "tab-pane m-5");
			if (active) {
				div.add(Attribute.CLASS, "active");
			}
			div.add(Attribute.ID, id);
			if (StringUtils.isEmpty(url)) {
				div.add(TagUtil.getBody(getJspBody()));
			} else {
				Iframe iframe = new Iframe();
				iframe.add(Attribute.ID, TagUtil.getId());
				iframe.add(Attribute.SRC, TagUtil.getPathForBlank(getJspContext()));
				iframe.add(Attribute.DATA_URL, TagUtil.getPathForUrl(getJspContext(), url));
				if (active) {
					iframe.add(Attribute.CLASS, "active");
				}
				div.add(iframe);

				Script script = new Script();
				script.add(Attribute.TYPE, "text/javascript");
				script.add("$('#" + iframe.get(Attribute.ID) + "').iframe();");
				div.add(script);
			}
			panel.addDiv(div);
		}
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getReloadOnSelect() {
		return reloadOnSelect;
	}

	public void setReloadOnSelect(Boolean reloadOnSelect) {
		this.reloadOnSelect = reloadOnSelect;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
