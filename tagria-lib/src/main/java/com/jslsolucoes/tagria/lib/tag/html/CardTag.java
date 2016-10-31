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
import com.jslsolucoes.tagria.lib.tag.Toolballer;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CardTag extends SimpleTagSupport implements Toolballer {
	
	private String toolbar;
	
	@Override
	public void doTag() throws JspException, IOException {
			Div card = new Div();
			card.add(Attribute.CLASS,"card hoverable");
			card.add(TagUtil.getBody(getJspBody()));
			
			if (!StringUtils.isEmpty(toolbar)) {
				Div action = new Div();
				action.add(Attribute.CLASS,"card-action");
				action.add(toolbar);	
				card.add(action);
			}
			TagUtil.out(getJspContext(), card);
	}

	@Override
	public void setToolbar(String html) {
		this.toolbar = html;
	}
	
	/*
	 * 	<div class="card" >
		<div class="card-content">
			Teste de conteudo
		</div>
		<div class="card-action">
			Componente
		</div>
	</div>
	 */
		
}
