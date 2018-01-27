
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CardBodyTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		Div card = new Div();
		card.add(Attribute.CLASS, "card-content");
		card.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), card);
	}

	/*
	 * <div class="card" > <div class="card-content"> Teste de conteudo </div>
	 * <div class="card-action"> Componente </div> </div>
	 */

}
