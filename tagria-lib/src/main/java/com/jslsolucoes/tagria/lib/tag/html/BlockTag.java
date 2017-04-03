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
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class BlockTag extends SimpleTagSupport {
	
	private String align;
	private Boolean rendered = Boolean.TRUE;
	
	@Override
	public void doTag() throws JspException, IOException {
		if(rendered != null && rendered) {
			Div div = new Div();
			div.add(Attribute.CLASS,"m-t-20 m-b-20 clearfix");
			if(!StringUtils.isEmpty(align)){
				div.add(Attribute.CLASS,"text-"+align);
			}
			div.add(TagUtil.getBody(getJspBody()));
			TagUtil.out(getJspContext(), div);
		}
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

}
