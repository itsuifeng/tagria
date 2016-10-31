package com.jslsolucoes.tagria.lib.html;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public abstract class Element {
	private List<Element> elements = new ArrayList<Element>();
	private HashMap<Attribute, String> atributos = new LinkedHashMap<Attribute, String>();

	public Element add(Element element) {
		elements.add(element);
		return this;
	}

	public void remove(Attribute attribute) {
		atributos.remove(attribute);
	}

	public void remove(Attribute attribute, String value) {

		String separator = " ";
		if (attribute.equals(Attribute.STYLE))
			separator = ";";
		String newValue = atributos.get(attribute).replaceAll(value + "(" + separator + "|)", "");
		if (StringUtils.isEmpty(newValue)) {
			remove(attribute);
		} else {
			atributos.put(attribute, newValue);
		}
	}

	public Element add(List<Element> elements) {
		this.elements.addAll(elements);
		return this;
	}

	public String get(Attribute attribute) {
		return (String) atributos.get(attribute);
	}

	public Element add(Attribute attribute, boolean value) {
		return add(attribute, String.valueOf(value));
	}
	
	public Element add(String html) {
		this.elements.add(new CData(html));
		return this;
	}

	public Element add(Attribute attribute, String value) {
		value = value.trim();
		if (atributos.containsKey(attribute)) {
			String separator = " ";
			if (attribute.equals(Attribute.STYLE))
				separator = ";";
			value = get(attribute).concat(separator).concat(value);
		}
		atributos.put(attribute, value);
		return this;
	}

	public Element add(Attribute attribute, Integer value) {
		return this.add(attribute, String.valueOf(value));
	}

	public String getHtml() {
		StringBuilder html = new StringBuilder();
		html.append("<");
		html.append(this.getTag());
		for (Attribute attribute : atributos.keySet()) {
			html.append(" ");
			html.append(attribute.getAttribute());
			html.append("=\"");
			html.append(atributos.get(attribute));
			html.append("\"");
		}
		if (this.elements.isEmpty() && !forceCloseTagWithEmptyBody()) {
			html.append("/");
		}
		html.append(">");
		for (Element element : this.elements) {
			html.append(element.getHtml());
		}
		if (!this.elements.isEmpty() || forceCloseTagWithEmptyBody()) {
			html.append("</" + this.getTag() + ">");
		}
		return html.toString();
	}

	public boolean hasAttribute(Attribute attribute) {
		return this.atributos.get(attribute) != null;
	}

	public abstract String getTag();
	
	public boolean forceCloseTagWithEmptyBody(){
		return false;
	}

}
