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
package com.jslsolucoes.tagria.lib.tag.ajax;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.util.TagUtil;

public class MapOptionsTag extends SimpleTagSupport {
	private String target;
	private String text;
	private String value;

	@Override
	public void doTag() throws JspException, IOException {

		String id = TagUtil.getId(target, null);
		StringBuilder builder = new StringBuilder();
		builder.append("$('#" + id + "').html('');  $('#" + id + "').append($(document.createElement('option')).attr('value','').text('- - -')); for(i=0;i < data.list.length;i++){ var text = new Array();");
		for(String token : text.split(",")) {
			builder.append("text.push(data.list[i]." + token + ");");
		}		
		builder.append(" var option=$(document.createElement('option')).attr('value',data.list[i]." + value + ").text(text.join(' - ')); " 
				+ " $('#" + id + "').append(option); } ");
		TagUtil.out(getJspContext(), builder.toString());
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
