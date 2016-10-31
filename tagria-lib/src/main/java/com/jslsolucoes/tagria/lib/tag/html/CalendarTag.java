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
	
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	
}
