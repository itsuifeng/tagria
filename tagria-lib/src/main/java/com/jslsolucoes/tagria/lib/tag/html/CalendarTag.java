
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
		script.add("$('#" + div.get(Attribute.ID) + "').fullCalendar({ " + "		events: '"
				+ TagUtil.getPathForUrl(getJspContext(), url) + "',"
				+ "		header: {															"
				+ "				left: 'prev,next today'," + "				center: 'title',"
				+ "				right: 'month,agendaWeek,agendaDay'" + "		}," + "		monthNames: ['"
				+ TagUtil.getLocalizedForLib("calendar.january", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.february", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.march", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.april", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.may", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.june", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.july", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.august", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.september", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.october", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.november", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.december", getJspContext()) + "']," + "		monthNamesShort: ['"
				+ TagUtil.getLocalizedForLib("calendar.january.short", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.february.short", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.march.short", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.april.short", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.may.short", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.june.short", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.july.short", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.august.short", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.september.short", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.october.short", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.november.short", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.december.short", getJspContext()) + "'],"
				+ "		dayNames: ['" + TagUtil.getLocalizedForLib("calendar.sunday", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.monday", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.tuesday", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.wednesday", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.thursday", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.friday", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.saturday", getJspContext()) + "']," + "		dayNamesShort: ['"
				+ TagUtil.getLocalizedForLib("calendar.sunday.short", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.monday.short", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.tuesday.short", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.wednesday.short", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.thursday.short", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.friday.short", getJspContext()) + "','"
				+ TagUtil.getLocalizedForLib("calendar.saturday.short", getJspContext()) + "'],"
				+ "		buttonText: {" + "						prev: '&nbsp;&#9668;&nbsp;',"
				+ "    					next: '&nbsp;&#9658;&nbsp;',"
				+ "						prevYear: '&nbsp;&lt;&lt;&nbsp;',"
				+ "						nextYear: '&nbsp;&gt;&gt;&nbsp;'," + "						today: '"
				+ TagUtil.getLocalizedForLib("calendar.today", getJspContext()) + "',"
				+ "						month: '" + TagUtil.getLocalizedForLib("calendar.month", getJspContext()) + "',"
				+ "						week: '" + TagUtil.getLocalizedForLib("calendar.week", getJspContext()) + "',"
				+ "						day: '" + TagUtil.getLocalizedForLib("calendar.day", getJspContext()) + "'"
				+ "		}," + "		allDayText: '" + TagUtil.getLocalizedForLib("calendar.all.day", getJspContext())
				+ "'," + "       theme: true,                               " + "		timeFormat: 'HH:mm',"
				+ "		displayEventEnd: true," + "		eventRender: function(event, element) { "
				+ "			if( event.description ) {"
				+ "				element.popover({ trigger : 'hover click' , title : event.title,  content : event.description,html : true,placement : 'bottom',container : 'body'  }); "
				+ "			}" + "	    }" + "});");
		TagUtil.out(getJspContext(), script);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
