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

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class FunctionTag extends SimpleTagSupport {

	private Boolean executeOnDocumentLoad = Boolean.FALSE;
	private String dataType = "json";
	private String name;
	private String url;
	private Boolean rendered = Boolean.TRUE;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
		
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

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	
}
