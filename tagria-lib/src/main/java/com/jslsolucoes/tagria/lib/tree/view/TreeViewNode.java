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

import com.google.gson.annotations.SerializedName;

public class TreeViewNode {
	private String id;
	private String type = "file";
	private String text;
	private Boolean children;
	
	@SerializedName("a_attr")
	private Map<String,String> aAttr = new HashMap<>();
	
	@SerializedName("li_attr")
	private Map<String,String> liAttr = new HashMap<>();
	
	private TreeViewNodeState state = new TreeViewNodeState();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void addAAttribute(String key,String value){
		aAttr.put(key, value);
	}
	
	public void addLiAttribute(String key,String value){
		liAttr.put(key, value);
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

	public Map<String,String> getaAttr() {
		return aAttr;
	}

	public void setaAttr(Map<String,String> aAttr) {
		this.aAttr = aAttr;
	}

	public Map<String,String> getLiAttr() {
		return liAttr;
	}

	public void setLiAttr(Map<String,String> liAttr) {
		this.liAttr = liAttr;
	}



}
