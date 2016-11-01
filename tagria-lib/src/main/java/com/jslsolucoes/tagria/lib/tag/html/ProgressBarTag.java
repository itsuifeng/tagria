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
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ProgressBarTag extends SimpleTagSupport {
	
	
	private Boolean determinate = Boolean.FALSE;
	private Integer value = 0;	
	
	@Override
	public void doTag() throws JspException, IOException {
			Div div = new Div();
			div.add(Attribute.ID,TagUtil.getId());
			div.add(Attribute.CLASS,"progress");
			Div progress = new Div();
			if(determinate){
				progress.add(Attribute.CLASS,"determinate");
				progress.add(Attribute.STYLE,"width:"+value+"%");
			} else {
				progress.add(Attribute.CLASS,"indeterminate");
			}
			div.add(progress);
			TagUtil.out(getJspContext(), div);
		
	}

	public Boolean getDeterminate() {
		return determinate;
	}

	public void setDeterminate(Boolean determinate) {
		this.determinate = determinate;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
