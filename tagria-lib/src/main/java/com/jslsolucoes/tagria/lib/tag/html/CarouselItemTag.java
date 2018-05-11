package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.H3;
import com.jslsolucoes.tagria.lib.html.Img;
import com.jslsolucoes.tagria.lib.html.P;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CarouselItemTag extends SimpleTagSupport {

	
	private String label;
	private String description;
	private String url;
	private String alt = "image";
	private Boolean cdn = true;
	private Boolean active = Boolean.FALSE;
	
	@Override
	public void doTag() throws JspException, IOException {
		
		Div div = new Div();
		div.add(Attribute.CLASS,"item");
		
		if(active) {
			div.add(Attribute.CLASS,"active");
		}
		
		Img img = new Img();
		img.add(Attribute.SRC, TagUtil.getPathForStatic(getJspContext(), url, cdn));
		img.add(Attribute.ALT, TagUtil.getLocalized(alt, getJspContext()));
		div.add(img);
		
		if(!StringUtils.isEmpty(label)){
			Div caption = new Div();
			caption.add(Attribute.CLASS,"carousel-caption");
			
			H3 h3 = new H3();
			h3.add(TagUtil.getLocalized(label, getJspContext()));
			caption.add(h3);
			
			if(!StringUtils.isEmpty(description)){
				P p = new P();
				p.add(TagUtil.getLocalized(description, getJspContext()));
				caption.add(p);
			}
			
			div.add(caption);
		}
		TagUtil.out(getJspContext(), div);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public Boolean getCdn() {
		return cdn;
	}

	public void setCdn(Boolean cdn) {
		this.cdn = cdn;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
