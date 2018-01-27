
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
	private Map<String, String> aAttr = new HashMap<>();

	@SerializedName("li_attr")
	private Map<String, String> liAttr = new HashMap<>();

	private TreeViewNodeState state = new TreeViewNodeState();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void addAAttribute(String key, String value) {
		aAttr.put(key, value);
	}

	public void addLiAttribute(String key, String value) {
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

	public Map<String, String> getaAttr() {
		return aAttr;
	}

	public void setaAttr(Map<String, String> aAttr) {
		this.aAttr = aAttr;
	}

	public Map<String, String> getLiAttr() {
		return liAttr;
	}

	public void setLiAttr(Map<String, String> liAttr) {
		this.liAttr = liAttr;
	}

}
