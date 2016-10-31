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

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ProgressCircleTag extends SimpleTagSupport {
	
	private String color = "blue";
	private String size = "big";

	
	@Override
	public void doTag() throws JspException, IOException {
			Div wrapper = new Div();
			wrapper.add(Attribute.CLASS,"preloader-wrapper "+size+" active");
			
			Div spinnerLayer = new Div();
			spinnerLayer.add(Attribute.CLASS,"spinner-layer spinner-"+color+"-only");
			
			Div circle = new Div();
			circle.add(Attribute.CLASS,"circle");
			
			Div left = new Div();
			left.add(Attribute.CLASS,"circle-clipper circle-left");
			left.add(circle);
			
			Div center = new Div();
			center.add(Attribute.CLASS,"gap-patch");
			center.add(circle);
			
			Div right = new Div();
			right.add(Attribute.CLASS,"circle-clipper circle-right");
			right.add(circle);
			
			spinnerLayer.add(left);
			spinnerLayer.add(center);
			spinnerLayer.add(right);
			
			wrapper.add(spinnerLayer);
			TagUtil.out(getJspContext(), wrapper);
		
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}
		
}
