
package com.jslsolucoes.tagria.lib.tag.x;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;

public class StringUtil {

	private StringUtil() {

	}

	public static String join(Collection<?> collection, String separator) {
		return StringUtils.join(collection, separator);
	}
	
	public static String concat(String value1,String value2) {
		return concatenation(value1,value2);
	}
	
	public static String concat(String value1,String value2,String value3) {
		return concatenation(value1,value2,value3);
	}
	
	public static String concat(String value1,String value2,String value3,String value4) {
		return concatenation(value1,value2,value3,value4);
	}
	
	public static String concat(String value1,String value2,String value3,String value4,String value5) {
		return concatenation(value1,value2,value3,value4,value5);
	}
	
	private static String concatenation(String... values) {
		return Arrays.asList(values).stream().collect(Collectors.joining());
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