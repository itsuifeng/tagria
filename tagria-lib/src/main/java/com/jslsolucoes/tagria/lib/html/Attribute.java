package com.jslsolucoes.tagria.lib.html;

public enum Attribute {

	ACTION("action"),	
	ACCEPT("accept"),
	ALT("alt"),
	AUTOFOCUS("autofocus"),
	AUTOCOMPLETE("autocomplete"),
	CLASS("class"),
	CONTENT("content"),
	CHECKED("checked"),
	COLSPAN("colspan"),
	DATA_DISMISS("data-dismiss"),
	DATA_TOGGLE("data-toggle"),
	DATA_TARGET("data-target"),
	DATA_TYPE("data-type"),
	DATA_URL("data-url"),
	DISABLED("disabled"),
	ENCTYPE("enctype"),
	FOR("for"),
	HREF("href"), 
	HTTP_EQUIV("http-equiv"),
	HEIGHT("height"),
	ID("id"),
	LANG("LANG"),
	METHOD("method"),
	MAXLENGTH("maxlength"),
	MULTIPLE("multiple"),
	NAME("name"),
	ONSUBMIT("onsubmit"),
	PLACEHOLDER("placeholder"),
	PATTERN("pattern"),
	REL("rel"),
	ROLE("role"),
	REQUIRED("required"),
	ROWS("rows"),
	SRC("src"),
	SELECTED("selected"),
	STYLE("style"),
	TYPE("type"),
	TITLE("title"),
	TARGET("target"),
	VALUE("value"),
	XMLNS("xmlns"),
	WIDTH("width");

	private String attribute;

	private Attribute(String attribute) {
		this.attribute = attribute;
	}

	public String getAttribute() {
		return attribute;
	}

}
