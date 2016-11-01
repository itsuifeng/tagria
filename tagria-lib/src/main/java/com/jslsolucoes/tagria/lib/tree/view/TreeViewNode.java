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
package com.jslsolucoes.tagria.lib.tree.view;

import java.util.HashMap;
import java.util.Map;

public class TreeViewNode {
	private String id;
	private String type = "file";
	private String text;
	private Boolean children;
	private Map<String,String> a_attr = new HashMap<String, String>();
	private Map<String,String> li_attr = new HashMap<String, String>();
	private TreeViewNodeState state = new TreeViewNodeState();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void addAAttribute(String key,String value){
		a_attr.put(key, value);
	}
	
	public void addLiAttribute(String key,String value){
		li_attr.put(key, value);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getChildren() {
		return children;
	}

	public void setChildren(Boolean children) {
		if (children) {
			type = "folder";
		} else {
			type = "file";
		}
		this.children = children;
	}

	public TreeViewNodeState getState() {
		return state;
	}

	public void setState(TreeViewNodeState state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Map<String,String> getLi_attr() {
		return li_attr;
	}

	public void setLi_attr(Map<String,String> li_attr) {
		this.li_attr = li_attr;
	}

	public Map<String,String> getA_attr() {
		return a_attr;
	}

	public void setA_attr(Map<String,String> a_attr) {
		this.a_attr = a_attr;
	}

}
