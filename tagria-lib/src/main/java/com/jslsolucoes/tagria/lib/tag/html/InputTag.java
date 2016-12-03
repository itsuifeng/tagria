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
import com.jslsolucoes.tagria.lib.html.Input;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class InputTag extends SimpleTagSupport {

	private String checked;
	private String name;
	private String value;
	private String pattern;
	private String type= "text";
	private String placeholder;
	private String accept;
	private Boolean multiple = Boolean.FALSE;
	private Boolean required = Boolean.FALSE;
	private Boolean disabled = Boolean.FALSE;
	private Boolean focus = Boolean.FALSE;
	private String id;
	private String title;
	private Integer maxLength;
	private String format;
	private String cssClass;
	private Integer max;
	private Integer min;
	
	@Override
	public void doTag() throws JspException, IOException {
		Input input = new Input();
		input.add(Attribute.TYPE,type);
		input.add(Attribute.NAME,name);
		
		
		if(max != null){
			input.add(Attribute.MAX,max);
		}
		
		if(min != null){
			input.add(Attribute.MIN,max);
		}
		
		if(multiple){
			input.add(Attribute.MULTIPLE,"multiple");
		}
		if(!StringUtils.isEmpty(accept)){
			input.add(Attribute.ACCEPT,accept);
		}
		
		input.add(Attribute.ID,TagUtil.getId(name, id,this));
		if(!type.equals("checkbox") && !type.equals("radio")){
			input.add(Attribute.CLASS,"form-control");
		}
		
		if(focus){
			input.add(Attribute.AUTOFOCUS,"autofocus");
		}
		
		if(!StringUtils.isEmpty(title)){
			input.add(Attribute.TITLE,TagUtil.getLocalized(title));
		}
		
		if(maxLength != null){
			input.add(Attribute.MAXLENGTH,maxLength);
		}
		if(!StringUtils.isEmpty(placeholder)){
			input.add(Attribute.PLACEHOLDER,TagUtil.getLocalized(placeholder));
		}
		
		if (!StringUtils.isEmpty(format)) {
			value = TagUtil.format(format, value);
		}
		
		if (!StringUtils.isEmpty(value)) {
			input.add(Attribute.VALUE, TagUtil.getLocalized(value));
		}
		if(!StringUtils.isEmpty(pattern)){
			input.add(Attribute.PATTERN, pattern);
		}
		if ((type.equals("checkbox") || type.equals("radio")) && !StringUtils.isEmpty(checked)
				&& (checked.equals(value) || checked.equals("true"))) {
			input.add(Attribute.CHECKED, "checked");
		}
		if(disabled){
			input.add(Attribute.DISABLED, "disabled");
			input.add(Attribute.CLASS,"disabled");
		}
		
		if(required){
			input.add(Attribute.CLASS,"bs-input-required");
			input.add(Attribute.REQUIRED,"required");
		}
		
		if(!StringUtils.isEmpty(cssClass)){
			input.add(Attribute.CLASS,cssClass);
		}
		
		TagUtil.out(getJspContext(), input);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Boolean getFocus() {
		return focus;
	}

	public void setFocus(Boolean focus) {
		this.focus = focus;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public Boolean getMultiple() {
		return multiple;
	}

	public void setMultiple(Boolean multiple) {
		this.multiple = multiple;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}


	
}
