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

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Button;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.Span;
import com.jslsolucoes.tagria.lib.html.Ul;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class MenuButtonTag extends SimpleTagSupport {

	private String cssClass;
	private String icon;
	private String align;
	private String label;
	private String title;
	private Boolean rendered = Boolean.TRUE;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			Div div = new Div();
			div.add(Attribute.CLASS, "btn-group navbar-btn");
			if (!StringUtils.isEmpty(align)) {
				div.add(Attribute.CLASS, "navbar-" + align);
			}

			Button button = new Button();
			button.add(Attribute.CLASS, "btn btn-default waves-effect waves-light dropdown-toggle");
			if (!StringUtils.isEmpty(cssClass)) {
				button.add(Attribute.CLASS, cssClass);
			}
			button.add(Attribute.DATA_TOGGLE, "dropdown");

			if (!StringUtils.isEmpty(icon)) {
				Span span = new Span();
				span.add(Attribute.CLASS, "glyphicon glyphicon-" + icon);
				button.add(span);
			}

			if (!StringUtils.isEmpty(label)) {
				button.add(TagUtil.getLocalized(label,getJspContext()));
			}

			if (!StringUtils.isEmpty(title)) {
				button.add(Attribute.TITLE, TagUtil.getLocalized(title,getJspContext()));
			}

			div.add(button);

			Ul ul = new Ul();
			ul.add(Attribute.CLASS, "dropdown-menu dropdown-menu-right");
			ul.add(TagUtil.getBody(getJspBody()));

			div.add(ul);

			TagUtil.out(getJspContext(), div);
		}
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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
}
