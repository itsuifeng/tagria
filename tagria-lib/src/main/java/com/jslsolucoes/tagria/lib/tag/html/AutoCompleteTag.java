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
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.Input;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class AutoCompleteTag extends SimpleTagSupport {
	
	private String url;
	private String name;
	private String dataValue;
	private String dataText;
	private String value;
	private String placeholder;
	private String text;
	private Boolean required = Boolean.FALSE;
	private Integer minLength = 2;
	
	@Override
	public void doTag() throws JspException, IOException {
		
		Div div = new Div();
		
		Input hidden = new Input();
		hidden.add(Attribute.TYPE,"hidden");
		hidden.add(Attribute.NAME,name);
		hidden.add(Attribute.ID,TagUtil.getId(name,null,this));
		if(!StringUtils.isEmpty(value)){
			hidden.add(Attribute.VALUE,value);
		}
		div.add(hidden);
		
		Input input = new Input();
		input.add(Attribute.AUTOCOMPLETE,"off");
		if(required){
			input.add(Attribute.CLASS,"bs-input-required");
			input.add(Attribute.REQUIRED,"required");
		}
		if(!StringUtils.isEmpty(text)){
			input.add(Attribute.VALUE,TagUtil.getLocalized(text,getJspContext()));
		}
		if(!StringUtils.isEmpty(placeholder)){
			input.add(Attribute.PLACEHOLDER,placeholder);
		}
		input.add(Attribute.TYPE,"text");
		input.add(Attribute.CLASS,"form-control");
		input.add(Attribute.ID,TagUtil.getId(name + ".auto.complete",null,this));
		div.add(input);
		TagUtil.out(getJspContext(),div);
		
		Script script = new Script();
		script.add(Attribute.TYPE, "text/javascript");
		script.add("$('#"+input.get(Attribute.ID)+"').autoComplete({							"+
				    "	minLength : "+ minLength +",															"+
				    "	resultsNotFound : '"+ TagUtil.getLocalizedForLib("auto.complete.no.results",getJspContext()) +"',"+
				    "	display : function (item) {													"+
					"		return item."+dataText+";													"+
					"	},"+
					"	source : '" + TagUtil.getPathForUrl(getJspContext(), url) + "',		"+
					"	select: function( item ) {				 									"+
					"       $('#"+hidden.get(Attribute.ID)+"').val(item."+dataValue+");																	"+
					"	}																			"+
					"}).blur(function(){															"+
					"	if($(this).val()==''){ $('#"+hidden.get(Attribute.ID)+"').val('') }         "+																																	
				    "});");

		TagUtil.out(getJspContext(), script);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDataValue() {
		return dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

	public String getDataText() {
		return dataText;
	}

	public void setDataText(String dataText) {
		this.dataText = dataText;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getMinLength() {
		return minLength;
	}

	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
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

	
}
