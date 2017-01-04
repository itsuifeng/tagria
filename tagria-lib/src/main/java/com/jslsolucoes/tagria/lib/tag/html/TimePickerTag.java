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
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TimePickerTag extends SimpleTagSupport {

	private String attachTo;
	private String pattern = "HH:mm";

	@Override
	public void doTag() throws JspException, IOException {

		StringBuilder builder = new StringBuilder();
		builder.append("$(document).ready(function(){ "+
				"			$('#" + TagUtil.getId(attachTo, null,this) + "').timepicker({ "+
				"				timeOnlyTitle: '"+TagUtil.getLocalizedForLib("time.picker.title",getJspContext())+"', 		"+
				"				timeText: '"+TagUtil.getLocalizedForLib("time.picker.time",getJspContext())+"', 						"+
				"				hourText: '"+TagUtil.getLocalizedForLib("time.picker.hour",getJspContext())+"', 							"+
				"				minuteText: '"+TagUtil.getLocalizedForLib("time.picker.minute",getJspContext())+"', 						"+
				"				secondText: '"+TagUtil.getLocalizedForLib("time.picker.second",getJspContext())+"', 					"+
				"				millisecText: '"+TagUtil.getLocalizedForLib("time.picker.milisecond",getJspContext())+"', 				"+
				"				microsecText: '"+TagUtil.getLocalizedForLib("time.picker.microsecond",getJspContext())+"', 			"+
				"				timezoneText: '"+TagUtil.getLocalizedForLib("time.picker.timezone",getJspContext())+"', 				"+
				"				currentText: '"+TagUtil.getLocalizedForLib("time.picker.now",getJspContext())+"', 						"+
				"				closeText: '"+TagUtil.getLocalizedForLib("time.picker.close",getJspContext())+"', 						"+
				"				timeFormat: '"+pattern+"', 						"+
				"				controlType : 'select',					    "+
				"				timeSuffix: '', 							"+
				"				amNames: ['"+TagUtil.getLocalizedForLib("time.picker.am",getJspContext())+"', '"+TagUtil.getLocalizedForLib("time.picker.am.uppercase",getJspContext())+"', '"+TagUtil.getLocalizedForLib("time.picker.am.lowecase",getJspContext())+"'], 				"+
				"				pmNames: ['"+TagUtil.getLocalizedForLib("time.picker.pm",getJspContext())+"', '"+TagUtil.getLocalizedForLib("time.picker.pm.uppercase",getJspContext())+"', '"+TagUtil.getLocalizedForLib("time.picker.pm.lowercase",getJspContext())+"'], 				"+
				"				isRTL: false 								"+
				"	   		}); 											"+
				"		});													");
		Script script = new Script();
		script.add(Attribute.TYPE, "text/javascript");
		script.add(builder.toString());
		TagUtil.out(getJspContext(), script);

	}

	public String getAttachTo() {
		return attachTo;
	}

	public void setAttachTo(String attachTo) {
		this.attachTo = attachTo;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}
