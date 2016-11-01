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

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Img;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ImageTag extends SimpleTagSupport {

	private String alt;
	private String shape;
	private Integer height;
	private String url;
	private Integer width;
	private String cssClass;
	private Boolean cdn = true;
	private Boolean responsive = true;

	@Override
	public void doTag() throws JspException, IOException {
		
			Img img = new Img();
			if(responsive){
				img.add(Attribute.CLASS, "img-responsive");
			}
			if(!StringUtils.isEmpty(shape)){
				img.add(Attribute.CLASS, "img-" + shape);
			}
			if(!StringUtils.isEmpty(cssClass)){
				img.add(Attribute.CLASS, cssClass);
			}
			img.add(Attribute.SRC, TagUtil.getPathForStatic(getJspContext(), url, cdn));
			img.add(Attribute.ALT, TagUtil.getLocalized(alt));
			if(width != null){
				img.add(Attribute.WIDTH, width);
			}
			if(height != null){
				img.add(Attribute.HEIGHT, height);
			}
			TagUtil.out(getJspContext(), img);
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Boolean getCdn() {
		return cdn;
	}

	public void setCdn(Boolean cdn) {
		this.cdn = cdn;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public Boolean getResponsive() {
		return responsive;
	}

	public void setResponsive(Boolean responsive) {
		this.responsive = responsive;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
