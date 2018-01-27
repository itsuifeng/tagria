
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.A;
import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.H3;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CollapsableTag extends SimpleTagSupport {

	private String label;
	private String state = "primary";
	private Boolean opened = Boolean.FALSE;

	@Override
	public void doTag() throws JspException, IOException {

		Div panelGroup = new Div();
		panelGroup.add(Attribute.CLASS, "panel-group");
		panelGroup.add(Attribute.ID, TagUtil.getId());

		Div panel = new Div();
		panel.add(Attribute.CLASS, "panel panel-" + state);

		Div panelHead = new Div();
		panelHead.add(Attribute.CLASS, "panel-heading");
		H3 h3 = new H3();
		h3.add(Attribute.CLASS, "panel-title");
		A a = new A();
		a.add(Attribute.HREF, "#");
		a.add(Attribute.ID, TagUtil.getId());
		a.add(TagUtil.getLocalized(label, getJspContext()));
		h3.add(a);
		panelHead.add(h3);
		panel.add(panelHead);

		Div content = new Div();
		content.add(Attribute.ID, TagUtil.getId());
		content.add(Attribute.CLASS, "panel-collapse collapse " + (opened ? "in" : ""));

		Div panelBody = new Div();
		panelBody.add(Attribute.CLASS, "panel-body");
		panelBody.add(TagUtil.getBody(getJspBody()));

		content.add(panelBody);
		panel.add(content);

		panelGroup.add(panel);

		TagUtil.out(getJspContext(), panelGroup);

		Script script = new Script();
		script.add(Attribute.TYPE, "text/javascript");
		script.add("$('#" + a.get(Attribute.ID) + "').click(function(){ if($('#" + content.get(Attribute.ID)
				+ "').is(':visible')){ $('#" + content.get(Attribute.ID) + "').collapse('hide');  } else { $('#"
				+ content.get(Attribute.ID) + "').collapse('show');  }  });");
		TagUtil.out(getJspContext(), script);

	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Boolean getOpened() {
		return opened;
	}

	public void setOpened(Boolean opened) {
		this.opened = opened;
	}

}