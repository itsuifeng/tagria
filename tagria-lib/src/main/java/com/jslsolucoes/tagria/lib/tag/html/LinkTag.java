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

import com.jslsolucoes.tagria.lib.html.A;
import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class LinkTag extends SimpleTagSupport {

	private String url;
	private String label;
	private String target = "_self";
	private Boolean rendered = Boolean.TRUE;

	@Override
	public void doTag() throws JspException, IOException {
			if(rendered){
				A a = new A();
				a.add(Attribute.HREF, TagUtil.getPathForUrl(getJspContext(), url));
				a.add(Attribute.TARGET, target);
				if (!StringUtils.isEmpty(label)) {
					a.add(TagUtil.getLocalized(label,getJspContext()));
				} else {
					a.add(TagUtil.getBody(getJspBody()));
				}
				TagUtil.out(getJspContext(),a);
			}
	}

	

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public Boolean getRendered() {
		return rendered;
	}



	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}
	
}
