/*******************************************************************************
 * Copyright 2016 JSL Solucoes LTDA - https://jslsolucoes.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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

public class ButtonTag extends SimpleTagSupport {
	
	private String id;
	private String type;
	private String url = "#";
	private String icon;
	private String title;
	private String label;
	private String target = "_self";
	private Boolean rendered = Boolean.TRUE;
	private Boolean confirm = Boolean.FALSE;
	private String confirmText = TagUtil.getLocalizedForLib("button.confirm.text");
	private String cssClass;
	private Boolean disabled = Boolean.FALSE;
	private String state = "default";
	
	@Override
	public void doTag() throws JspException, IOException {
		if(rendered){
			A a = new A();
			if(!StringUtils.isEmpty(type)){
				a.add(Attribute.DATA_TYPE,type);
			}
			a.add(Attribute.TARGET, target);
			a.add(Attribute.ID,TagUtil.getId(id));
			a.add(Attribute.CLASS,"btn btn-"+state + " waves-effect waves-light");
			
			if(!StringUtils.isEmpty(cssClass)){
				a.add(Attribute.CLASS,cssClass);
			}
			
			if(disabled){
				a.add(Attribute.CLASS,"disabled");	
			}
			
			if (!StringUtils.isEmpty(title)) {
				a.add(Attribute.TITLE, TagUtil.getLocalized(title));
			}
			
			if(confirm){
				
				String id = TagUtil.getId();
				a.add(Attribute.HREF,"#");
				a.add(Attribute.DATA_TOGGLE,"modal");
				a.add(Attribute.DATA_TARGET,"#" + id);
				
				Div modal = new Div();
				modal.add(Attribute.CLASS,"modal fade");
				modal.add(Attribute.ID,id);
				
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
				body.add(TagUtil.getLocalized(confirmText));
				content.add(body);
				
				Div footer = new Div();
				footer.add(Attribute.CLASS,"modal-footer");
				Button cancel = new Button();
				cancel.add(Attribute.CLASS,"btn btn-danger waves-effect waves-light cancel");
				cancel.add(Attribute.DATA_DISMISS,"modal");
				cancel.add(TagUtil.getLocalizedForLib("button.confirm.cancel"));
				footer.add(cancel);
				
				A confirm = new A();
				confirm.add(Attribute.ID,id);
				confirm.add(Attribute.CLASS,"btn btn-primary waves-effect waves-light sure");
				confirm.add(TagUtil.getLocalizedForLib("button.confirm.confirm"));
				confirm.add(Attribute.HREF,TagUtil.getPathForUrl(getJspContext(), url));
				confirm.add(Attribute.TARGET, target);
				
				Script script = new Script();
				script.add(Attribute.TYPE, "text/javascript");
				script.add(" $('#"+confirm+"').click(function(){ $('#" + modal + "').modal('hide'); });");
				
				
				
				footer.add(confirm);		
				content.add(footer);
				
				dialog.add(content);
				modal.add(dialog);
				TagUtil.out(getJspContext(), modal);
				
			} else {
				a.add(Attribute.HREF,TagUtil.getPathForUrl(getJspContext(), url));
			}
			
			if(!StringUtils.isEmpty(icon)){
				Span span = new Span();
				span.add(Attribute.CLASS,"glyphicon glyphicon-"+icon);		
				a.add(span);
			}
			
			if(!StringUtils.isEmpty(label)){
				a.add(" " + TagUtil.getLocalized(label));
			}
			TagUtil.out(getJspContext(), a);
		}
	}

	
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Boolean getConfirm() {
		return confirm;
	}

	public void setConfirm(Boolean confirm) {
		this.confirm = confirm;
	}

	public String getConfirmText() {
		return confirmText;
	}

	public void setConfirmText(String confirmText) {
		this.confirmText = confirmText;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
}
