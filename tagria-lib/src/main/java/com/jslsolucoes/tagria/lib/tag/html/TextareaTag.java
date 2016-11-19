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
import com.jslsolucoes.tagria.lib.html.Textarea;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TextareaTag extends SimpleTagSupport {

	private String name;
	private String value;
	private String placeholder;
	private Boolean required = Boolean.FALSE;
	private Integer rows = 4;
	
	@Override
	public void doTag() throws JspException, IOException {
		Textarea textarea = new Textarea();
		textarea.add(Attribute.NAME,name);
		textarea.add(Attribute.ROWS, rows);
		textarea.add(Attribute.ID,TagUtil.getId(name, null,this));
		textarea.add(Attribute.CLASS,"form-control");
		if(!StringUtils.isEmpty(placeholder)){
			textarea.add(Attribute.PLACEHOLDER,TagUtil.getLocalized(placeholder));
		}
		if (!StringUtils.isEmpty(value)) {
			textarea.add(value);
		}
		if(required){
			textarea.add(Attribute.CLASS,"bs-input-required");
			textarea.add(Attribute.REQUIRED,"required");
		}
		TagUtil.out(getJspContext(), textarea);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

}
