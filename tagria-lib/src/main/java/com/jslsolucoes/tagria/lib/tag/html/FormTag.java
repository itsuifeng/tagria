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
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.Form;
import com.jslsolucoes.tagria.lib.html.H3;
import com.jslsolucoes.tagria.lib.html.H4;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.html.Span;
import com.jslsolucoes.tagria.lib.tag.Toolballer;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class FormTag extends SimpleTagSupport implements Toolballer {

	private String method = "post";
	private String action = "#";
	private String name;
	private String validation;
	private String label;
	private String toolbar;
	private Boolean rendered = Boolean.TRUE;
	private Boolean multipart = Boolean.FALSE;
	private String target = "_self";

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered) {

			Div panel = new Div();
			panel.add(Attribute.CLASS, "panel panel-primary");

			if (!StringUtils.isEmpty(getLabel())) {
				Div panelHead = new Div();
				panelHead.add(Attribute.CLASS, "panel-heading");
				H3 h3 = new H3();
				h3.add(Attribute.CLASS, "panel-title");
				h3.add(TagUtil.getLocalized(getLabel(),getJspContext()));
				panelHead.add(h3);
				panel.add(panelHead);
			}

			Div panelBody = new Div();
			panelBody.add(Attribute.CLASS, "panel-body");

			Form form = new Form();
			form.add(Attribute.NOVALIDATE,"novalidate");
			if(!StringUtils.isEmpty(name)){
				form.add(Attribute.NAME,name);
			}
			form.add(Attribute.TARGET,target);
			form.add(Attribute.ID, TagUtil.getId());
			form.add(Attribute.METHOD, method);
			form.add(Attribute.ACTION, TagUtil.getPathForUrl(getJspContext(), action));
			form.add(Attribute.ONSUBMIT, "return false;");

			if (multipart) {
				form.add(Attribute.ENCTYPE, "multipart/form-data");
			}
			
			Div head = new Div();
			head.add(Attribute.CLASS,"form-group");
			
			Span span = new Span();
			span.add(Attribute.CLASS, "text-danger");
			span.add(" * ");

			Div info = new Div();
			info.add(Attribute.CLASS, "text-center");
			H4 h4 = new H4();
			h4.add(TagUtil.getLocalizedForLib("form.required.title",getJspContext(), span.getHtml()));
			info.add(h4);
			head.add(info);

			Div div = new Div();
			div.add(Attribute.CLASS, "collapse alert alert-danger alert-dismissible bs-form-empty-field");
			div.add(TagUtil.getLocalizedForLib("form.empty.field.message",getJspContext()));
			head.add(div);

			Div errors = new Div();
			errors.add(Attribute.CLASS, "collapse alert alert-danger alert-dismissible bs-form-validation-errors");
			errors.add("&nbsp;");
			head.add(errors);
			
			form.add(head);

			form.add(TagUtil.getBody(getJspBody()));

			
			Div divForToolbar = new Div();
			divForToolbar.add(Attribute.CLASS, "bs-button-group");
			if (!StringUtils.isEmpty(toolbar)) {
				divForToolbar.add(toolbar);
			} else {
				A button = new A();
				button.add(Attribute.CLASS, "btn btn-primary waves-effect waves-light");
				button.add(Attribute.DATA_TYPE,"submit");
				button.add(TagUtil.getLocalizedForLib("form.submit.button",getJspContext()));
				divForToolbar.add(button);
			}
			
			form.add(divForToolbar);

			panelBody.add(form);
			panel.add(panelBody);

			TagUtil.out(getJspContext(), panel);

			Script script = new Script();
			script.add(Attribute.TYPE, "text/javascript");
			script.add("$('#" + form.get(Attribute.ID) + "').form({ " + 
						"	validation : '"+ (!StringUtils.isEmpty(validation) ? TagUtil.getPathForUrl(getJspContext(), validation) : "")+ "'," +
						"   invalid : { " + 
						"		email : '"+TagUtil.getLocalizedForLib("email.invalid",getJspContext())+"',"+
						"		max : '"+TagUtil.getLocalizedForLib("max.invalid",getJspContext())+"',"+
						"		min : '"+TagUtil.getLocalizedForLib("min.invalid",getJspContext())+"'"+
						"	}"+
					"});");

			TagUtil.out(getJspContext(), script);
		}
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getValidation() {
		return validation;
	}

	public void setValidation(String validation) {
		this.validation = validation;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public void setToolbar(String html) {
		this.toolbar = html;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public Boolean getMultipart() {
		return multipart;
	}

	public void setMultipart(Boolean multipart) {
		this.multipart = multipart;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
}
