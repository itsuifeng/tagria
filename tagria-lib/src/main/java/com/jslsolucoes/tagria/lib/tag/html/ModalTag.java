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
import com.jslsolucoes.tagria.lib.html.H4;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.html.Span;
import com.jslsolucoes.tagria.lib.tag.Toolballer;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ModalTag extends SimpleTagSupport implements Toolballer {

	private String id;
	private String label;
	private String attachTo;
	private Boolean closeable = Boolean.TRUE;
	private Boolean open = Boolean.FALSE;
	private Boolean rendered = Boolean.TRUE;
	private String toolbar;
	
	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			Div modal = new Div();
			modal.add(Attribute.CLASS,"modal fade");
			modal.add(Attribute.ID,TagUtil.getId(id));
			
			if(!closeable){
				modal.add(Attribute.DATA_KEYBOARD,"false");
				modal.add(Attribute.DATA_BACKDROP,"static");
			}
			
			Div dialog = new Div();
			dialog.add(Attribute.CLASS,"modal-dialog");
			
			Div content = new Div();
			content.add(Attribute.CLASS,"modal-content");
			
			Div header = new Div();
			header.add(Attribute.CLASS,"modal-header");
			
			if(closeable){
				Button close = new Button();
				close.add(Attribute.CLASS,"close");
				close.add(Attribute.DATA_DISMISS,"modal");
				close.add(new Span().add("&times;"));
				header.add(close);
			}
			
			H4 h4 = new H4();
			h4.add(Attribute.CLASS,"modal-title");
			h4.add(TagUtil.getLocalized(label,getJspContext()));
			header.add(h4);
			
			content.add(header);
			
			Div body = new Div();
			body.add(Attribute.CLASS,"modal-body");
			body.add(TagUtil.getBody(getJspBody()));
			content.add(body);
			
			if (!StringUtils.isEmpty(toolbar)) {
				Div footer = new Div();
				footer.add(Attribute.CLASS, "modal-footer");
				footer.add(toolbar);
				content.add(footer);
			}
			
			dialog.add(content);
			modal.add(dialog);
			TagUtil.out(getJspContext(), modal);
			
			if(!StringUtils.isEmpty(attachTo)){
				Script script = new Script();
				script.add(Attribute.TYPE, "text/javascript");
				script.add("$('#" + attachTo + "').attr('data-toggle','modal').attr('data-target','#"+modal.get(Attribute.ID)+"');");
				TagUtil.out(getJspContext(), script);
			}
			
			if(open){
				Script script = new Script();
				script.add(Attribute.TYPE, "text/javascript");
				script.add("$('#" + modal.get(Attribute.ID) + "').modal('show')");
				TagUtil.out(getJspContext(), script);
			}
		}
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
	
	@Override
	public void setToolbar(String html) {
		this.toolbar = html;
	}


	public Boolean getCloseable() {
		return closeable;
	}


	public void setCloseable(Boolean closeable) {
		this.closeable = closeable;
	}


	public Boolean getOpen() {
		return open;
	}


	public void setOpen(Boolean open) {
		this.open = open;
	}


	public Boolean getRendered() {
		return rendered;
	}


	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}


	
}