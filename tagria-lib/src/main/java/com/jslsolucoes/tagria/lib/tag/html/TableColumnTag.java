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
import com.jslsolucoes.tagria.lib.html.Td;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TableColumnTag extends SimpleTagSupport {

	private Boolean header = Boolean.FALSE;
	private Integer colspan;
	private String format;
	private String label;

	@Override
	public void doTag() throws JspException, IOException {
		Td td = new Td();
		if (header) {
			td.add(Attribute.CLASS, "bg-primary");
		}
		if(colspan != null){
			td.add(Attribute.COLSPAN,colspan);
		}
		
		if(!StringUtils.isEmpty(label)){
			td.add(TagUtil.getLocalized(label,getJspContext()));
		} else {
			String body = TagUtil.getBody(getJspBody());
			if (!StringUtils.isEmpty(format)) {
				body = TagUtil.format(format, body,getJspContext());
			}
			td.add(body);
		}
		TagUtil.out(getJspContext(), td);
	}

	public Boolean getHeader() {
		return header;
	}

	public void setHeader(Boolean header) {
		this.header = header;
	}

	public Integer getColspan() {
		return colspan;
	}

	public void setColspan(Integer colspan) {
		this.colspan = colspan;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
