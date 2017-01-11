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
					"		monthNames: ['" + TagUtil.getLocalizedForLib("calendar.january",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.february",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.march",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.april",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.may",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.june",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.july",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.august",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.september",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.october",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.november",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.december",getJspContext()) + "']," + 
					"		monthNamesShort: ['"+ TagUtil.getLocalizedForLib("calendar.january.short",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.february.short",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.march.short",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.april.short",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.may.short",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.june.short",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.july.short",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.august.short",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.september.short",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.october.short",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.november.short",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.december.short",getJspContext()) + "']," + 
					"		dayNames: ['"+ TagUtil.getLocalizedForLib("calendar.sunday",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.monday",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.tuesday",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.wednesday",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.thursday",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.friday",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.saturday",getJspContext()) + "']," + 
					"		dayNamesShort: ['"+ TagUtil.getLocalizedForLib("calendar.sunday.short",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.monday.short",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.tuesday.short",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.wednesday.short",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.thursday.short",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.friday.short",getJspContext()) + "','"+ TagUtil.getLocalizedForLib("calendar.saturday.short",getJspContext()) +"'],"+
					"		buttonText: {"+ 
					"						prev: '&nbsp;&#9668;&nbsp;'," + 
					"    					next: '&nbsp;&#9658;&nbsp;'," + 
					"						prevYear: '&nbsp;&lt;&lt;&nbsp;'," + 
					"						nextYear: '&nbsp;&gt;&gt;&nbsp;'," +
					"						today: '"+ TagUtil.getLocalizedForLib("calendar.today",getJspContext()) + "'," + 
					"						month: '" + TagUtil.getLocalizedForLib("calendar.month",getJspContext()) + "'," + 
					"						week: '"+ TagUtil.getLocalizedForLib("calendar.week",getJspContext()) + "'," + 
					"						day: '" + TagUtil.getLocalizedForLib("calendar.day",getJspContext()) + "'" + 
					"		}," + 
					"		allDayText: '"	+ TagUtil.getLocalizedForLib("calendar.all.day",getJspContext()) + "'," +
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
