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
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CalendarTag extends SimpleTagSupport {

	private String url;

	@Override
	public void doTag() throws JspException, IOException {
		
			Div div = new Div();
			div.add(Attribute.ID, TagUtil.getId());
			TagUtil.out(getJspContext(), div);
			
			Script script = new Script();
			script.add(Attribute.TYPE, "text/javascript");
			script.add("$('#" + div.get(Attribute.ID) + "').fullCalendar({ "+
					"		events: '" + TagUtil.getPathForUrl(getJspContext(), url)+ "'," +
					"		header: {															"+	
					"				left: 'prev,next today'," + 
					"				center: 'title'," + 
					"				right: 'month,agendaWeek,agendaDay'"+
					"		},"+
					"		monthNames: ['" + TagUtil.getLocalizedForLib("calendar.january") + "','"+ TagUtil.getLocalizedForLib("calendar.february") + "','"+ TagUtil.getLocalizedForLib("calendar.march") + "','"+ TagUtil.getLocalizedForLib("calendar.april") + "','"+ TagUtil.getLocalizedForLib("calendar.may") + "','"+ TagUtil.getLocalizedForLib("calendar.june") + "','"+ TagUtil.getLocalizedForLib("calendar.july") + "','"+ TagUtil.getLocalizedForLib("calendar.august") + "','"+ TagUtil.getLocalizedForLib("calendar.september") + "','"+ TagUtil.getLocalizedForLib("calendar.october") + "','"+ TagUtil.getLocalizedForLib("calendar.november") + "','"+ TagUtil.getLocalizedForLib("calendar.december") + "']," + 
					"		monthNamesShort: ['"+ TagUtil.getLocalizedForLib("calendar.january.short") + "','"+ TagUtil.getLocalizedForLib("calendar.february.short") + "','"+ TagUtil.getLocalizedForLib("calendar.march.short") + "','"+ TagUtil.getLocalizedForLib("calendar.april.short") + "','"+ TagUtil.getLocalizedForLib("calendar.may.short") + "','"+ TagUtil.getLocalizedForLib("calendar.june.short") + "','"+ TagUtil.getLocalizedForLib("calendar.july.short") + "','"+ TagUtil.getLocalizedForLib("calendar.august.short") + "','"+ TagUtil.getLocalizedForLib("calendar.september.short") + "','"+ TagUtil.getLocalizedForLib("calendar.october.short") + "','"+ TagUtil.getLocalizedForLib("calendar.november.short") + "','"+ TagUtil.getLocalizedForLib("calendar.december.short") + "']," + 
					"		dayNames: ['"+ TagUtil.getLocalizedForLib("calendar.sunday") + "','"+ TagUtil.getLocalizedForLib("calendar.monday") + "','"+ TagUtil.getLocalizedForLib("calendar.tuesday") + "','"+ TagUtil.getLocalizedForLib("calendar.wednesday") + "','"+ TagUtil.getLocalizedForLib("calendar.thursday") + "','"+ TagUtil.getLocalizedForLib("calendar.friday") + "','"+ TagUtil.getLocalizedForLib("calendar.saturday") + "']," + 
					"		dayNamesShort: ['"+ TagUtil.getLocalizedForLib("calendar.sunday.short") + "','"+ TagUtil.getLocalizedForLib("calendar.monday.short") + "','"+ TagUtil.getLocalizedForLib("calendar.tuesday.short") + "','"+ TagUtil.getLocalizedForLib("calendar.wednesday.short") + "','"+ TagUtil.getLocalizedForLib("calendar.thursday.short") + "','"+ TagUtil.getLocalizedForLib("calendar.friday.short") + "','"+ TagUtil.getLocalizedForLib("calendar.saturday.short") +"'],"+
					"		buttonText: {"+ 
					"						prev: '&nbsp;&#9668;&nbsp;'," + 
					"    					next: '&nbsp;&#9658;&nbsp;'," + 
					"						prevYear: '&nbsp;&lt;&lt;&nbsp;'," + 
					"						nextYear: '&nbsp;&gt;&gt;&nbsp;'," +
					"						today: '"+ TagUtil.getLocalizedForLib("calendar.today") + "'," + 
					"						month: '" + TagUtil.getLocalizedForLib("calendar.month") + "'," + 
					"						week: '"+ TagUtil.getLocalizedForLib("calendar.week") + "'," + 
					"						day: '" + TagUtil.getLocalizedForLib("calendar.day") + "'" + 
					"		}," + 
					"		allDayText: '"	+ TagUtil.getLocalizedForLib("calendar.all.day") + "'," +
					"       theme: true,                               "+
					"		timeFormat: 'HH:mm'," +
					"		displayEventEnd: true,"+
					"		eventRender: function(event, element) { "+
					"			if( event.description ) {"+
					"				element.popover({ trigger : 'hover click' , title : event.title,  content : event.description,html : true,placement : 'bottom',container : 'body'  }); "+
					"			}"+
					"	    }"+
					"});");
			TagUtil.out(getJspContext(), script);
	}
	
	/*
	 * view.appendJsCode("$('#" + id + "').fullCalendar({" + "theme: true," + "events: '"
					+ TagUtil.getPathForUrl(getJspContext(), url) + "'," + "timeFormat: 'H:mm{ - H:mm}'," + "header: {"
					+ "	left: 'prev,next today'," + "	center: 'title'," + "	right: 'month,agendaWeek,agendaDay'"
					+ "}," + "monthNames: ['" + TagUtil.getLocalizedForTagria("calendar.january") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.february") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.march") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.april") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.may") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.june") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.july") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.august") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.september") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.october") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.november") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.december") + "']," + "monthNamesShort: ['"
					+ TagUtil.getLocalizedForTagria("calendar.january.short") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.february.short") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.march.short") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.april.short") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.may.short") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.june.short") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.july.short") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.august.short") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.september.short") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.october.short") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.november.short") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.december.short") + "']," + "dayNames: ['"
					+ TagUtil.getLocalizedForTagria("calendar.sunday") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.monday") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.tuesday") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.wednesday") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.thursday") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.friday") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.saturday") + "']," + "dayNamesShort: ['"
					+ TagUtil.getLocalizedForTagria("calendar.sunday.short") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.monday.short") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.tuesday.short") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.wednesday.short") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.thursday.short") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.friday.short") + "','"
					+ TagUtil.getLocalizedForTagria("calendar.saturday.short") + "']," + "buttonText: {"
					+ "	prev: '&nbsp;&#9668;&nbsp;'," + "    next: '&nbsp;&#9658;&nbsp;',"
					+ "	prevYear: '&nbsp;&lt;&lt;&nbsp;'," + "	nextYear: '&nbsp;&gt;&gt;&nbsp;'," + "	today: '"
					+ TagUtil.getLocalizedForTagria("calendar.today") + "'," + "	month: '"
					+ TagUtil.getLocalizedForTagria("calendar.month") + "'," + "	week: '"
					+ TagUtil.getLocalizedForTagria("calendar.week") + "'," + "	day: '"
					+ TagUtil.getLocalizedForTagria("calendar.day") + "'" + "}," + "allDayText: '"
					+ TagUtil.getLocalizedForTagria("calendar.all.day") + "'," + "lazyFetching: false,"
					+ "loading: function(bool) {" + "	if (bool) $('.ui-ajax-info-loading').fadeIn('normal');"
					+ "	else $('.ui-ajax-info-loading').fadeOut('normal');" + "},"
					+ "eventRender: function (event,element) {" + "	if( event.description ) {" + "element.qtip({"
					+ "	content : {" + "    	text : event.description," + "		title : {"
					+ "			text : event.title" + "		}" + "	}," + "	position: {"
					+ "		at: 'bottom center'," + "		my: 'top center'," + "		viewport: $(window),"
					+ "		adjust: {" + "			method: 'flip'" + "		}" + "	}," + "	hide: {"
					+ "		event: 'mouseout click'" + "	}," + "	show: {" + "		event : 'mouseover'," + "	},"
					+ "	style : {" + "		classes : 'ui-shadow'," + "		widget : true" + "	}" + "});" + "	}" + "}"
					+ "});");
	 */
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	
}
