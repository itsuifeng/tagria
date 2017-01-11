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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class DatePickerTag extends SimpleTagSupport {

	private String attachTo;
	private Integer min;
	
	public static void main(String[] args) {
		DateFormat formatter = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
		System.out.println(((SimpleDateFormat)formatter).toPattern());
		System.out.println(((SimpleDateFormat)formatter).toLocalizedPattern());
	}

	@Override
	public void doTag() throws JspException, IOException {

		StringBuilder builder = new StringBuilder();
		builder.append("$(document).ready(function(){ "+
				"	$('#" + TagUtil.getId(attachTo, null,this) + "').datepicker({ 																																																																	"+
				"					changeMonth: true,																																																																																																																																																																																																																																																		"+
				"					changeYear: true,																																																																								"+
				"					closeText: '"+TagUtil.getLocalizedForLib("date.picker.close",getJspContext())+"',																																								"+
				"					prevText: '"+TagUtil.getLocalizedForLib("date.picker.prev",getJspContext())+"',																																																					"+
				"					nextText: '"+TagUtil.getLocalizedForLib("date.picker.next",getJspContext())+"',																																								"+
				"					currentText: '"+TagUtil.getLocalizedForLib("date.picker.current",getJspContext())+"',																																					"+
				"					monthNames: [ '"+TagUtil.getLocalizedForLib("date.picker.january",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.february",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.march",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.april",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.may",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.june",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.july",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.august",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.september",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.october",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.november",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.december",getJspContext())+"' ],	"+
				"					monthNamesShort: [ '"+TagUtil.getLocalizedForLib("date.picker.january.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.february.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.march.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.april.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.may.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.june.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.july.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.august.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.september.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.october.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.november.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.december.short",getJspContext())+"' ],										"+
				"					dayNames: ['"+TagUtil.getLocalizedForLib("date.picker.sunday",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.monday",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.tuesday",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.wednesday",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.thursday",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.friday",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.saturday",getJspContext())+"'],							"+
				"					dayNamesShort: ['"+TagUtil.getLocalizedForLib("date.picker.sunday.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.monday.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.tuesday.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.wednesday.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.thursday.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.friday.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.saturday.short",getJspContext())+"'],																		"+
				"					dayNamesMin: ['"+TagUtil.getLocalizedForLib("date.picker.sunday.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.monday.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.tuesday.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.wednesday.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.thursday.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.friday.short",getJspContext())+"','"+TagUtil.getLocalizedForLib("date.picker.saturday.short",getJspContext())+"'],																			"+
				"					weekHeader: '"+TagUtil.getLocalizedForLib("date.picker.week",getJspContext())+"',																													"+
				"					dateFormat: '"+TagUtil.getLocalizedForLib("date.picker.format",getJspContext())+"'																												");
		if (min != null) {
			builder.append(",minDate:'" + min + "d'");
		}
		builder.append(TagUtil.getBody(getJspBody()));
		builder.append("}); });");

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

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

}
