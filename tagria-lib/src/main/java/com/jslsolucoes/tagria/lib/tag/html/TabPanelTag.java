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
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.Element;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.html.Ul;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TabPanelTag extends SimpleTagSupport {	
	
	private List<Element> lis = new ArrayList<Element>();
	private List<Element> divs = new ArrayList<Element>();
	
	@Override
	public void doTag() throws JspException, IOException {
		
		TagUtil.flushBody(getJspBody());
		
		Div div = new Div();
		div.add(Attribute.ID,TagUtil.getId());
		
		Ul ul = new Ul();
		ul.add(Attribute.CLASS,"nav nav-tabs");
		ul.add(lis);
		div.add(ul);
		
		Div tabs = new Div();
		tabs.add(Attribute.CLASS,"tab-content");
		tabs.add(divs);
		div.add(tabs);
		
		TagUtil.out(getJspContext(), div);
		
		Script script = new Script();
		script.add(Attribute.TYPE, "text/javascript");
		script.add("$('#" + div.get(Attribute.ID) + "').tab();");
		TagUtil.out(getJspContext(), script);
		
	}
	
	public void addLi(Element element){
		lis.add(element);
	}
	
	public void addDiv(Element element){
		divs.add(element);
	}

	public List<Element> getLis() {
		return lis;
	}

	public void setLis(List<Element> lis) {
		this.lis = lis;
	}

	public List<Element> getDivs() {
		return divs;
	}

	public void setDivs(List<Element> divs) {
		this.divs = divs;
	}
}