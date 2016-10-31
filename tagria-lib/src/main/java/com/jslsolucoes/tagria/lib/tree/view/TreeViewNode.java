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
