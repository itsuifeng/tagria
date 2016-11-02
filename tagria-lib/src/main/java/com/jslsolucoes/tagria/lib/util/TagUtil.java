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
package com.jslsolucoes.tagria.lib.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Element;
import com.jslsolucoes.tagria.lib.servlet.TagriaConfigParameter;
import com.jslsolucoes.tagria.lib.tag.html.DetailTableTag;

public class TagUtil {
	
	public static Locale locale(){
		return Locale.forLanguageTag(getInitParam(TagriaConfigParameter.LOCALE));
	}

	public static String getVersion() {
		return "1.0.1";
	}
	
	public static String format(String type,String value){
		
		if(StringUtils.isEmpty(value)){
			return value;
		} else if (type.equals("date") || type.equals("timestamp") || type.equals("hour")) {
			
			DateFormat dateFormat = DateFormat.getDateTimeInstance();
			if(type.equals("timestamp")){
				dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, locale());
			} else if(type.equals("date")){
				dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale());
			} else if(type.equals("hour")){
				dateFormat = DateFormat.getTimeInstance(DateFormat.MEDIUM, locale());
			}
			List<String> patterns = new ArrayList<String>();
			patterns.add("yyyy-MM-dd HH:mm:ss");
			patterns.add("yyyy-MM-dd");
			for(String pattern : patterns){
				try {
					return dateFormat.format(new SimpleDateFormat(pattern).parse(value));
				} catch (ParseException pe) {
					
				}
			}
			return value; 
		} else if (type.equals("currency")) {
			DecimalFormat nf = new DecimalFormat("#,##0.00",new DecimalFormatSymbols(locale()));
			return nf.format(new Double(value));
		} else if(type.equals("cep")){
			return String.format("%08d", Long.valueOf(value)).replaceAll("^([0-9]{5})([0-9]{3})$", "$1-$2");
		} else if(type.equals("cpf")){
			return String.format("%011d", Long.valueOf(value)).replaceAll("^([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})$", "$1.$2.$3-$4");
		} else if(type.equals("cnpj")){
			return String.format("%014d", Long.valueOf(value)).replaceAll("^([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})([0-9]{2})$", "$1.$2.$3/$4-$5");
		} else if(type.equals("tel")){
			return String.format("%010d", Long.valueOf(value)).replaceAll("^([0-9]{2})([0-9]{4,5})([0-9]{4})$", "($1) $2-$3");
		}
		return value;	
	}

	public static String getId(String name, String id, SimpleTagSupport simpleTagSupport) {
		String idForComponent = "par_" + RandomStringUtils.randomAlphanumeric(20);
		if (!StringUtils.isEmpty(id)) {
			idForComponent = id;
		} else if (!StringUtils.isEmpty(name)) {
			idForComponent = "par_" + name.replaceAll("\\.", "_").replaceAll("\\[([0-9]{1,}|)\\]", "");
		}
		return idForComponent + complementForDetailTable(simpleTagSupport);
	}
	
	public static String complementForDetailTable(SimpleTagSupport simpleTagSupport) {
		if(simpleTagSupport == null){
			return "";
		} else {
			DetailTableTag detailTable = (DetailTableTag) SimpleTagSupport.findAncestorWithClass(simpleTagSupport,
					DetailTableTag.class);
			return (detailTable != null ? "_" + detailTable.getIteration() : "");
		}
	}

	public static String getId(String name, String id) {
		return TagUtil.getId(name, id,null);
	}

	public static String getId() {
		return TagUtil.getId(null, null,null);
	}

	public static String getId(String id) {
		return TagUtil.getId(null, id,null);
	}

	public static String clean(String value) {
		return value.replaceAll("(\n|\r|\t)", "");
	}

	public static String getLocalized(String label) {
		if (label.matches("\\{(.*?)\\}")) {
			String key = label.replaceAll("(\\{|\\})", "").trim();
			try {
				return ResourceBundle.getBundle("messages").getString(key);
			} catch (MissingResourceException e) {
				return '!' + key + '!';
			}
		}
		return label;
	}

	public static String getBody(JspFragment fragment) throws JspException, IOException {
		if (fragment == null)
			return "";
		StringWriter body = new StringWriter();
		fragment.invoke(body);
		body.close();
		return body.toString().trim();
	}

	public static String getInitParam(TagriaConfigParameter tagriaConfigParameter) {
		InputStream props = TagUtil.class.getResourceAsStream("/tagrialib.properties");
		if (props == null) {
			return tagriaConfigParameter.getDefaultValue();
		} else {
			try {
				Properties properties = new Properties();
				properties.load(props);
				String value = (String) properties.get(tagriaConfigParameter.getName());
				if (value == null)
					return tagriaConfigParameter.getDefaultValue();
				return value;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static String getPathForCssLibResource(JspContext jspContext, String css) {
		return TagUtil.getUrlBaseForStaticFile(jspContext) + "/tagria/lib/css/theme/"
				+ TagUtil.getInitParam(TagriaConfigParameter.SKIN) + "/" + css + "?ver=" + getVersion();
	}

	public static String getPathForJsLibResource(JspContext jspContext, String js) {
		return TagUtil.getUrlBaseForStaticFile(jspContext) + "/tagria/lib/js/" + js + "?ver=" + getVersion();
	}

	public static String getPathForImageLibResource(JspContext jspContext, String image) {
		return TagUtil.getUrlBaseForStaticFile(jspContext) + "/tagria/lib/image/theme/"
				+ TagUtil.getInitParam(TagriaConfigParameter.SKIN) + "/" + image + "?ver=" + getVersion();
	}

	public static String getPathForStatic(JspContext jspContext, String src, Boolean cdn) {
		if (cdn) {
			return getPathForStatic(jspContext, src);
		} else {
			return TagUtil.getContextPath(jspContext) + src;
		}
	}

	public static String getPathForStatic(JspContext jspContext, String url) {
		String urlBase = "";
		if (!url.contains("http") && !url.contains("https")) {
			urlBase = TagUtil.getUrlBaseForStaticFile(jspContext);
		}
		return urlBase + url;
	}

	public static String getPathForUrl(JspContext jspContext, String url) {
		if (!url.startsWith("javascript") && !url.startsWith("#") && !url.startsWith("http")
				&& !url.startsWith("https")) {
			url = TagUtil.getContextPath(jspContext) + url;
		}
		url = url.replaceAll("\"", "'");
		return url;
	}

	private static String getContextPath(JspContext jspContext) {
		return ((HttpServletRequest) ((PageContext) jspContext).getRequest()).getContextPath();
	}

	private static String getUrlBaseForStaticFile(JspContext jspContext) {
		String url = TagUtil.getInitParam(TagriaConfigParameter.CDN_URL) != null
				&& Boolean.valueOf(TagUtil.getInitParam(TagriaConfigParameter.CDN_ENABLED))
						? getScheme((HttpServletRequest)((PageContext) jspContext).getRequest()) + "://" + TagUtil.getInitParam(TagriaConfigParameter.CDN_URL)
						: TagUtil.getContextPath(jspContext);
		return url;
	}

	public static String getScheme(HttpServletRequest request) {
		if (request.getHeader("X-Forwarded-Protocol") != null) {
			return request.getHeader("X-Forwarded-Protocol");
		} else {
			return request.getScheme();
		}
	}

	public static void out(JspContext jspContext, Element element) throws IOException {
		out(jspContext,element.getHtml());
	}
	
	public static void out(JspContext jspContext, String content) throws IOException {
		jspContext.getOut().print(content);
	}

	public static String getLocalizedForLib(String key) {
		return getLocalizedForLib(key, (Object[]) null);
	}
	
	public static String getLocalizedForLib(String key, Object... args) {
		try {
			MessageFormat messageFormat = new MessageFormat(ResourceBundle.getBundle("messages_tagrialib").getString(key));
		    return messageFormat.format(args);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
	
	@SuppressWarnings("unchecked")
	public static String queryString(HttpServletRequest request, List<String> excludesParams)
			throws UnsupportedEncodingException {
		List<String> queryString = new ArrayList<String>();
		Enumeration<String> en = request.getParameterNames();
		while (en.hasMoreElements()) {
			String paramName = en.nextElement();
			if (!excludesParams.contains(paramName))
				queryString.add(paramName + "=" + URLEncoder.encode(request.getParameter(paramName), "UTF-8"));
		}
		return StringUtils.join(queryString, '&');
	}

	public static void flushBody(JspFragment fragment) throws JspException, IOException {
		getBody(fragment);
	}

	public static String getPathForBlank(JspContext jspContext) {
		return getPathForUrl(jspContext,"/tagria/blank");
	}

	public static String cssForHideViewport(String hideOnViewport) {
		StringBuilder css = new StringBuilder();
		for(String device : hideOnViewport.split(",")){
			css.append(" hidden-"+device);
		}
		return css.toString();
	}
}
