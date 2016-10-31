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
import com.jslsolucoes.tagria.lib.html.Button;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.H4;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.html.Span;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ModalTag extends SimpleTagSupport {

	private String id;
	private String label;
	private String attachTo;
	
	@Override
	public void doTag() throws JspException, IOException {
		
		Div modal = new Div();
		modal.add(Attribute.CLASS,"modal fade");
		modal.add(Attribute.ID,TagUtil.getId(id));
		
		Div dialog = new Div();
		dialog.add(Attribute.CLASS,"modal-dialog");
		
		Div content = new Div();
		content.add(Attribute.CLASS,"modal-content");
		
		Div header = new Div();
		header.add(Attribute.CLASS,"modal-header");
		Button close = new Button();
		close.add(Attribute.CLASS,"close");
		close.add(Attribute.DATA_DISMISS,"modal");
		close.add(new Span().add("&times;"));
		header.add(close);
		
		H4 h4 = new H4();
		h4.add(Attribute.CLASS,"modal-title");
		h4.add(TagUtil.getLocalized(label));
		header.add(h4);
		
		content.add(header);
		
		Div body = new Div();
		body.add(Attribute.CLASS,"modal-body");
		body.add(TagUtil.getBody(getJspBody()));
		content.add(body);
		
		dialog.add(content);
		modal.add(dialog);
		TagUtil.out(getJspContext(), modal);
		
		Script script = new Script();
		script.add(Attribute.TYPE, "text/javascript");
		script.add("$('#" + attachTo + "').attr('data-toggle','modal').attr('data-target','#"+modal.get(Attribute.ID)+"');");
		TagUtil.out(getJspContext(), script);
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public String getAttachTo() {
		return attachTo;
	}


	public void setAttachTo(String attachTo) {
		this.attachTo = attachTo;
	}


	
}