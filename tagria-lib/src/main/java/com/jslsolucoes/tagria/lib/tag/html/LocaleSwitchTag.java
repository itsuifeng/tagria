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
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Option;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.html.Select;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class LocaleSwitchTag extends SimpleTagSupport {
	
	
	@Override
	public void doTag() throws JspException, IOException {

		Map<String,String> locales = new LinkedHashMap<String,String>();	
		locales.put("pt-BR","Portugues (Brasil)");
		locales.put("en","English");
		
		Select select = new Select();
		select.add(Attribute.ID, TagUtil.getId());
		
		locales.forEach((key,value) -> {
			Option option = new Option();
			option.add(Attribute.VALUE, key);
			option.add(value);
			if(key.equals(locale())){
				option.add(Attribute.SELECTED, "selected");
			}
			select.add(option);
		});
		select.add(Attribute.CLASS, "form-control");
		TagUtil.out(getJspContext(), select);
		
		Script script = new Script();
		script.add(Attribute.TYPE, "text/javascript");
		script.add("$('#" + select.get(Attribute.ID) + "').change(function(){  $.ajax({ url : '"+TagUtil.getPathForLocale(getJspContext())+"?locale=' + $('#" + select.get(Attribute.ID) + "').val(),success : function(data, textStatus, jqXHR){ window.location.reload() } });   });");
		TagUtil.out(getJspContext(), script);
	}

	
	private String locale(){
		HttpSession httpSession = ((PageContext) getJspContext()).getSession();
		return (String) httpSession.getAttribute("tagria-locale");
	}
	
}
