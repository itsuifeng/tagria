
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Body;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.DocType;
import com.jslsolucoes.tagria.lib.html.Head;
import com.jslsolucoes.tagria.lib.html.Html;
import com.jslsolucoes.tagria.lib.html.Link;
import com.jslsolucoes.tagria.lib.html.Meta;
import com.jslsolucoes.tagria.lib.html.NoScript;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.html.Span;
import com.jslsolucoes.tagria.lib.html.Title;
import com.jslsolucoes.tagria.lib.servlet.TagriaConfigParameter;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ViewTag extends SimpleTagSupport {

	private String title = "-";

	@Override
	public void doTag() throws JspException, IOException {
		Html html = new Html();
		html.add(Attribute.XMLNS, "http://www.w3.org/1999/xhtml");
		html.add(Attribute.LANG, TagUtil.localization(getJspContext()));
		Head head = new Head();
		html.add(head);
		Title titleForPage = new Title();
		titleForPage.add(TagUtil.getLocalized(this.title, getJspContext()));
		head.add(titleForPage);

		Meta meta = new Meta();
		meta.add(Attribute.HTTP_EQUIV, "content-type");
		meta.add(Attribute.CONTENT, "text/html;charset=" + TagUtil.getInitParam(TagriaConfigParameter.ENCODING));

		head.add(meta);

		Meta viewport = new Meta();
		viewport.add(Attribute.NAME, "viewport");
		viewport.add(Attribute.CONTENT, "width=device-width, initial-scale=1");

		head.add(viewport);

		Link bsCss = new Link();
		bsCss.add(Attribute.REL, "stylesheet");
		bsCss.add(Attribute.TYPE, "text/css");
		bsCss.add(Attribute.HREF, TagUtil.getPathForCssLibResource(getJspContext(), "tagria-ui.css"));

		head.add(bsCss);

		Script bsJs = new Script();
		bsJs.add(Attribute.TYPE, "text/javascript");
		bsJs.add(Attribute.SRC, TagUtil.getPathForJsLibResource(getJspContext(), "tagria-ui.js"));

		head.add(bsJs);

		Link favicon = new Link();
		favicon.add(Attribute.REL, "icon");
		favicon.add(Attribute.TYPE, "image/x-icon");
		favicon.add(Attribute.HREF, TagUtil.getPathForUrl(getJspContext(), "/favicon.ico"));
		head.add(favicon);

		StringBuilder jsReady = new StringBuilder();
		jsReady.append("URL_BASE='" + TagUtil.getPathForUrl(getJspContext(), "") + "';");
		jsReady.append(
				"$(document).ajaxStart(function(){ $('.bs-ajax-info-loading').fadeIn(); }).ajaxStop(function(){ 	$('.bs-ajax-info-loading').fadeOut(); }); $(document).ready(function(){ Waves.init(); });");
		Script ready = new Script();
		ready.add(Attribute.TYPE, "text/javascript");
		ready.add(jsReady.toString());
		head.add(ready);

		Body body = new Body();

		Div noScriptBody = new Div();
		noScriptBody.add(Attribute.CLASS, "alert alert-danger");
		noScriptBody.add(
				"Para o correto funcionamento dessa aplicação você deve ativar o suporte a javascript em seu navegador!!");

		NoScript noScript = new NoScript();
		noScript.add(noScriptBody);
		body.add(noScript);

		Div loading = new Div();
		loading.add(Attribute.CLASS, "text-center navbar-fixed-top m-t-20 collapse bs-ajax-info-loading");
		loading.add(new Span().add(Attribute.CLASS, "fa fa-spinner fa-spin fa-3x fa-fw"));
		body.add(loading);

		body.add(TagUtil.minifyHtml(TagUtil.getBody(getJspBody())));
		html.add(body);

		TagUtil.out(getJspContext(), DocType.HTML5);
		TagUtil.out(getJspContext(), html);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
