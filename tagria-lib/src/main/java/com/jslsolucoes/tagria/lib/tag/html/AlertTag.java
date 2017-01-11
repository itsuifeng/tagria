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
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class AlertTag extends SimpleTagSupport {

	private Boolean dismissible = Boolean.FALSE;
	private Boolean rendered = Boolean.TRUE;
	private String state;
	private String label;
	
	@Override
	public void doTag() throws JspException, IOException {
		
		if(rendered){
			Div div = new Div();
			div.add(Attribute.CLASS,"alert alert-"+state);
			div.add(Attribute.ROLE,"alert");
			if(dismissible){
				div.add(Attribute.CLASS,"alert-dismissible");
				Button button = new Button();
				button.add(Attribute.TYPE,"button");
				button.add(Attribute.CLASS,"close");
				button.add(Attribute.DATA_DISMISS,"alert");
				
				Span span = new Span();
				span.add("&times;");
				
				button.add(span);
				div.add(button);
			}
			if(!StringUtils.isEmpty(label)){
				div.add(TagUtil.getLocalized(label,getJspContext()));
			} else { 
				div.add(TagUtil.getBody(getJspBody()));
			}
			TagUtil.out(getJspContext(), div);
		}
	}


	public Boolean getDismissible() {
		return dismissible;
	}


	public void setDismissible(Boolean dismissible) {
		this.dismissible = dismissible;
	}


	public Boolean getRendered() {
		return rendered;
	}


	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}
}
