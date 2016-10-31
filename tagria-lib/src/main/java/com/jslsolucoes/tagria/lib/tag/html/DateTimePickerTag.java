package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class DateTimePickerTag extends SimpleTagSupport {

	private String attachTo;

	@Override
	public void doTag() throws JspException, IOException {

		StringBuilder builder = new StringBuilder();
		builder.append("$(document).ready(function(){ "+
				"			$('#" + TagUtil.getId(attachTo, null,this) + "').datetimepicker({ "+
				"				timeOnlyTitle: '"+TagUtil.getLocalizedForLib("time.picker.title")+"', 		"+
				"				timeText: '"+TagUtil.getLocalizedForLib("time.picker.time")+"', 						"+
				"				hourText: '"+TagUtil.getLocalizedForLib("time.picker.hour")+"', 							"+
				"				minuteText: '"+TagUtil.getLocalizedForLib("time.picker.minute")+"', 						"+
				"				secondText: '"+TagUtil.getLocalizedForLib("time.picker.second")+"', 					"+
				"				millisecText: '"+TagUtil.getLocalizedForLib("time.picker.milisecond")+"', 				"+
				"				microsecText: '"+TagUtil.getLocalizedForLib("time.picker.microsecond")+"', 			"+
				"				timezoneText: '"+TagUtil.getLocalizedForLib("time.picker.timezone")+"', 				"+
				"				currentText: '"+TagUtil.getLocalizedForLib("time.picker.now")+"', 						"+
				"				closeText: '"+TagUtil.getLocalizedForLib("time.picker.close")+"', 						"+
				"				timeFormat: 'HH:mm', 						"+
				"				controlType : 'select',					    "+
				"				timeSuffix: '', 							"+
				"				amNames: ['"+TagUtil.getLocalizedForLib("time.picker.am")+"', '"+TagUtil.getLocalizedForLib("time.picker.am.uppercase")+"', '"+TagUtil.getLocalizedForLib("time.picker.am.lowecase")+"'], 				"+
				"				pmNames: ['"+TagUtil.getLocalizedForLib("time.picker.pm")+"', '"+TagUtil.getLocalizedForLib("time.picker.pm.uppercase")+"', '"+TagUtil.getLocalizedForLib("time.picker.pm.lowercase")+"'], 				"+
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

}
