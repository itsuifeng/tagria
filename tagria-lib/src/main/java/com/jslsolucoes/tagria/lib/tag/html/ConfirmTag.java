package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.A;
import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Button;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.H4;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.html.Span;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ConfirmTag extends SimpleTagSupport {
	
	private String label = TagUtil.getLocalizedForLib("button.confirm.text");
	private String url = "#";
	private String target = "_self";
	private String attachTo;

	@Override
	public void doTag() throws JspException, IOException {
		
		Div modal = new Div();
		modal.add(Attribute.CLASS,"modal fade");
		modal.add(Attribute.ID,TagUtil.getId());
		
		Div dialog = new Div();
		dialog.add(Attribute.CLASS,"modal-dialog modal-sm");
		
		Div content = new Div();
		content.add(Attribute.CLASS,"modal-content");
		
		Div header = new Div();
		header.add(Attribute.CLASS,"modal-header");
		Button close = new Button();
		close.add(Attribute.CLASS,"close");
		close.add(Attribute.DATA_DISMISS,"modal");
		close.add(new Span().add("&times;"));
		header.add(close);
		
		H4 h4 = new H4();
		h4.add(Attribute.CLASS,"modal-title");
		h4.add(TagUtil.getLocalizedForLib("button.confirm.title"));
		header.add(h4);
		
		content.add(header);
		
		Div body = new Div();
		body.add(Attribute.CLASS,"modal-body");
		
		String bodyContent = TagUtil.getBody(getJspBody());
		
		if(!StringUtils.isEmpty(bodyContent)){
			body.add(bodyContent);
		} else {
			body.add(TagUtil.getLocalized(label));
		}
		content.add(body);
		
		Div footer = new Div();
		footer.add(Attribute.CLASS,"modal-footer");
		Button cancel = new Button();
		cancel.add(Attribute.CLASS,"btn btn-danger waves-effect waves-light cancel");
		cancel.add(Attribute.DATA_DISMISS,"modal");
		cancel.add(TagUtil.getLocalizedForLib("button.confirm.cancel"));
		footer.add(cancel);
		
		A confirm = new A();
		confirm.add(Attribute.CLASS,"btn btn-primary waves-effect waves-light sure");
		confirm.add(TagUtil.getLocalizedForLib("button.confirm.confirm"));
		confirm.add(Attribute.HREF,TagUtil.getPathForUrl(getJspContext(), url));
		confirm.add(Attribute.TARGET, target);
		
		footer.add(confirm);		
		content.add(footer);
		
		dialog.add(content);
		modal.add(dialog);
		TagUtil.out(getJspContext(), modal);
		
		Script script = new Script();
		script.add(Attribute.TYPE, "text/javascript");
		script.add("$('#" + attachTo + "').attr('data-toggle','modal').attr('data-target','#"+modal.get(Attribute.ID)+"');");
		TagUtil.out(getJspContext(), script);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getAttachTo() {
		return attachTo;
	}

	public void setAttachTo(String attachTo) {
		this.attachTo = attachTo;
	}
	
	
}
