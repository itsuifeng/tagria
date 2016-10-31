package com.jslsolucoes.tagria.lib.tag.ajax;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class FunctionTag extends SimpleTagSupport {

	private Boolean executeOnDocumentLoad = Boolean.FALSE;
	private String dataType = "json";
	private String name;
	private String url;

	@Override
	public void doTag() throws JspException, IOException {
		
		
		StringBuilder builder = new StringBuilder();
		builder.append("function " + name + "(){");
		builder.append("var data = new Array();");
		builder.append("$.ajax({																					"
				+ "				type : 'post',																		"	
				+ "				processData: false,																	"
				+ "				dataType : '" + dataType + "',														"
				+ "				beforeSend: function(jqXHR, settings) {												"
				+ "					var data = {};																	"
				+ "					for (var property in settings.data) {											"
				+ "						data[property] = settings.data[property].value;								"
				+ "    					if(settings.data[property].required && settings.data[property].value == ''){"
				+ "    						return false;															"
				+ "    					}																			"
				+ "					}																				"
				+ "					settings.data = $.param(data);													"
				+ "					return true;																	"
			    + "				},																					"
				+ "				url : '" + TagUtil.getPathForUrl(getJspContext(), url) + "',					"
				+ "			    async: true																			"
				+ 				TagUtil.getBody(getJspBody())
				+ "});");
		builder.append("}");
		
		Script function = new Script();
		function.add(Attribute.TYPE, "text/javascript");
		function.add(builder.toString());
		
		TagUtil.out(getJspContext(), function);
		
		if (executeOnDocumentLoad) {
			Script script = new Script();
			script.add(Attribute.TYPE, "text/javascript");
			script.add(name + "();");
			TagUtil.out(getJspContext(), script);
		}
		
	}

	public Boolean getExecuteOnDocumentLoad() {
		return executeOnDocumentLoad;
	}

	public void setExecuteOnDocumentLoad(Boolean executeOnDocumentLoad) {
		this.executeOnDocumentLoad = executeOnDocumentLoad;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
}
