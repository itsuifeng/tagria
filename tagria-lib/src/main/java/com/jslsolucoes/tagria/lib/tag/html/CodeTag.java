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

import com.jslsolucoes.tagria.lib.html.Code;
import com.jslsolucoes.tagria.lib.html.Pre;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CodeTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		Pre pre = new Pre();
		Code code = new Code();
		code.add(TagUtil.getBody(getJspBody()).replaceAll(">", "&gt;").replaceAll("<", "&lt;").replaceAll("\n","</br>")
				.replaceAll("    ", "&nbsp;&nbsp;&nbsp;&nbsp;"));
		pre.add(code);
		TagUtil.out(getJspContext(), pre);
	}
}
