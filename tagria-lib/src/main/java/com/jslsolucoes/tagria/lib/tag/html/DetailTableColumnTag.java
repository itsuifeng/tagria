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
import com.jslsolucoes.tagria.lib.html.Span;
import com.jslsolucoes.tagria.lib.html.Td;
import com.jslsolucoes.tagria.lib.html.Th;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class DetailTableColumnTag extends SimpleTagSupport {

	private String label;
	private Boolean required = Boolean.FALSE;

	@Override
	public void doTag() throws JspException, IOException {
		
		DetailTableTag detail = (DetailTableTag) findAncestorWithClass(this, DetailTableTag.class);
		
		Th th = new Th();
		th.add(TagUtil.getLocalized(label,getJspContext()));
		if(required){
			Span span = new Span();
			span.add(Attribute.CLASS,"text-danger");
			span.add(" * ");
			th.add(span);
		}
		detail.add(th);

		Td td = new Td();
		td.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), td);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

}
