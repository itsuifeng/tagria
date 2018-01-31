
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Option;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.html.Select;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class LocaleSwitchTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {

		Map<String, String> locales = new LinkedHashMap<>();
		locales.put("en", "English");
		locales.put("pt-BR", "Portugues (Brasil)");

		Select select = new Select();
		select.add(Attribute.ID, TagUtil.getId());

		locales.forEach((key, value) -> {
			Option option = new Option();
			option.add(Attribute.VALUE, key);
			option.add(value);
			if (key.equals(TagUtil.localization(getJspContext()))) {
				option.add(Attribute.SELECTED, "selected");
			}
			select.add(option);
		});
		select.add(Attribute.CLASS, "form-control");
		TagUtil.out(getJspContext(), select);

		Script script = new Script();
		script.add(Attribute.TYPE, "text/javascript");
		script.add("$('#" + select.get(Attribute.ID) + "').change(function(){  $.ajax({ url : '"
				+ TagUtil.getPathForLocale(getJspContext()) + "?locale=' + $('#" + select.get(Attribute.ID)
				+ "').val(),success : function(data, textStatus, jqXHR){ window.location.reload() } });   });");
		TagUtil.out(getJspContext(), script);
	}
}
