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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.A;
import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.Input;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.html.Span;
import com.jslsolucoes.tagria.lib.util.TagUtil;


@SuppressWarnings("rawtypes")
public class TreeViewTag extends SimpleTagSupport {
	private String url;
	private String name;
	private Collection data;
	private String var;
	private Boolean required = Boolean.FALSE;
	private Boolean multiple = Boolean.FALSE;
	
	private List<String> ids = new ArrayList<>();
	private List<String> texts = new ArrayList<>();

	@Override
	public void doTag() throws JspException, IOException {
			
			if (!CollectionUtils.isEmpty(data)) {
				for (Object row : data) {
					getJspContext().setAttribute(var, row);
					TagUtil.flushBody(getJspBody());
				}
			} else {
				TagUtil.flushBody(getJspBody());
			}
		
			Div container = new Div();
			container.add(Attribute.CLASS, "bs-treeview");
			container.add(Attribute.ID,TagUtil.getId());
			if(required){
				container.add(Attribute.CLASS, "bs-treeview-required");
			}
			
			
			if(!StringUtils.isEmpty(name)){
				Div header = new Div();
				A clear = new A();
				clear.add(Attribute.HREF,"javascript:void(0);");
				clear.add(Attribute.ID,TagUtil.getId());
				clear.add(Attribute.CLASS,"btn btn-danger waves-effect waves-light bs-treeview-clear");
				Span danger = new Span();
				danger.add(Attribute.CLASS,"glyphicon glyphicon-trash");		
				clear.add(danger);
				header.add(clear);			
				
				
				Span span = new Span();
				span.add(Attribute.CLASS,"m-5 bs-treeview-text");
				if(!CollectionUtils.isEmpty(texts)){
					span.add(StringUtils.join(texts, " - "));
				}
				header.add(span);	
				
				container.add(header);
			}
			
			Div treeview = new Div();
			treeview.add(Attribute.CLASS,"m-5 bs-treeview-view");
			container.add(treeview);
			if(!CollectionUtils.isEmpty(ids) && !StringUtils.isEmpty(name)){
				for(int index = 0; index < ids.size() ; index++ ){
					Input input = new Input();
					input.add(Attribute.TYPE,"hidden");
					input.add(Attribute.NAME,name.replaceAll("\\[\\]","["+index+"]"));
					input.add(Attribute.VALUE, ids.get(index));
					container.add(input);
				}
			}
			TagUtil.out(getJspContext(),container);
			
			Script script = new Script();
			script.add(Attribute.TYPE, "text/javascript");
			script.add("$('#" + container.get(Attribute.ID) + "').treeview({ multiple : " + multiple + " , url : '"+TagUtil.getPathForUrl(getJspContext(), url)+"', folderIcon : '"+TagUtil.getPathForImageLibResource(getJspContext(), "treeview-tree.png")+"' , fileIcon : '"+TagUtil.getPathForImageLibResource(getJspContext(), "treeview-leaf.png")+"',name : '"+name+"'});");
			TagUtil.out(getJspContext(), script);
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getRequired() {
		return required;
	}


	public void setRequired(Boolean required) {
		this.required = required;
	}


	public Boolean getMultiple() {
		return multiple;
	}


	public void setMultiple(Boolean multiple) {
		this.multiple = multiple;
	}


	public Collection getData() {
		return data;
	}


	public void setData(Collection data) {
		this.data = data;
	}


	public String getVar() {
		return var;
	}


	public void setVar(String var) {
		this.var = var;
	}


	public List<String> getIds() {
		return ids;
	}


	public void setIds(List<String> ids) {
		this.ids = ids;
	}


	public List<String> getTexts() {
		return texts;
	}


	public void setTexts(List<String> texts) {
		this.texts = texts;
	}


	
}
