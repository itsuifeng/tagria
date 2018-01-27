
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
		card.add(Attribute.CLASS, "card hoverable");
		card.add(TagUtil.getBody(getJspBody()));

		if (!StringUtils.isEmpty(toolbar)) {
			Div action = new Div();
			action.add(Attribute.CLASS, "card-action");
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
	 * <div class="card" > <div class="card-content"> Teste de conteudo </div>
	 * <div class="card-action"> Componente </div> </div>
	 */

}
