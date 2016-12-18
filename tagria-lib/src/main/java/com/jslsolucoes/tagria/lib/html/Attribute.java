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
	DATA_KEYBOARD("data-keyboard"),
	DATA_BACKDROP("data-backdrop"),
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
	MAX("max"), 
	MIN("min"),
	NAME("name"),
	NOVALIDATE("novalidate"),
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
