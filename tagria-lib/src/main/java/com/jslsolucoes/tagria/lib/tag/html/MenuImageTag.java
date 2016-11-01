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
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.Img;
import com.jslsolucoes.tagria.lib.html.Ul;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class MenuImageTag extends SimpleTagSupport {

	private String cssClass;
	private String image;
	private Integer height;
	private Integer width;
	private Boolean rendered = Boolean.TRUE;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered) {
			Div div = new Div();
			div.add(Attribute.CLASS, "dropdown btn btn-default waves-effect waves-light bs-menu-image");
			if (!StringUtils.isEmpty(cssClass)) {
				div.add(Attribute.CLASS, cssClass);
			}

			Img img = new Img();
			img.add(Attribute.ALT, "image");
			img.add(Attribute.SRC, TagUtil.getPathForUrl(getJspContext(), image));
			img.add(Attribute.WIDTH, width);
			img.add(Attribute.HEIGHT, height);
			img.add(Attribute.DATA_TOGGLE, "dropdown");

			div.add(img);

			Ul ul = new Ul();
			ul.add(Attribute.CLASS, "dropdown-menu dropdown-menu-right");
			ul.add(TagUtil.getBody(getJspBody()));

			div.add(ul);

			TagUtil.out(getJspContext(), div);
		}
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}
}
