
package com.jslsolucoes.tagria.lib.tag.x;

import java.util.Collection;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;

public class StringUtil {

	private StringUtil() {

	}

	public static String join(Collection<?> collection, String separator) {
		return StringUtils.join(collection, separator);
	}

	public static String concat(String left, String right) {
		return left.concat(right);
	}

	public static Integer length(Long value) {
		return String.valueOf(value).length();
	}

	public static String fullStackTrace(Exception exception) {
		return ExceptionUtils.getFullStackTrace(exception).replaceAll("\n", "<br/>");
	}

	public static String lineBreak(String value) {
		return value.replaceAll("\n", "<br>");
	}

}