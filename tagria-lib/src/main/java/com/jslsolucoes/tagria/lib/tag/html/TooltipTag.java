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

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TooltipTag extends SimpleTagSupport {
	
	private String attachTo;
	private Boolean rendered = Boolean.TRUE;
	
	@Override
	public void doTag() throws JspException, IOException {
		if(rendered != null && rendered){
			Script script = new Script();
			script.add(Attribute.TYPE, "text/javascript");
			script.add("$('#"+TagUtil.getId(attachTo, null)+"').popover({ content : '" +TagUtil.getBody(getJspBody()) +"',trigger : 'hover',html : true,placement : 'bottom',container : 'body' });");
			TagUtil.out(getJspContext(), script);		
		}
	}

	public String getAttachTo() {
		return attachTo;
	}

	public void setAttachTo(String attachTo) {
		this.attachTo = attachTo;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}
}