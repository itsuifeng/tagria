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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.A;
import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Button;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.Element;
import com.jslsolucoes.tagria.lib.html.Form;
import com.jslsolucoes.tagria.lib.html.H3;
import com.jslsolucoes.tagria.lib.html.H5;
import com.jslsolucoes.tagria.lib.html.Input;
import com.jslsolucoes.tagria.lib.html.Li;
import com.jslsolucoes.tagria.lib.html.Nav;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.html.Span;
import com.jslsolucoes.tagria.lib.html.Table;
import com.jslsolucoes.tagria.lib.html.Tbody;
import com.jslsolucoes.tagria.lib.html.Th;
import com.jslsolucoes.tagria.lib.html.Thead;
import com.jslsolucoes.tagria.lib.html.Tr;
import com.jslsolucoes.tagria.lib.html.Ul;
import com.jslsolucoes.tagria.lib.tag.Toolballer;
import com.jslsolucoes.tagria.lib.util.TagUtil;

@SuppressWarnings({ "rawtypes", "serial" })
public class GridTag extends SimpleTagSupport implements Toolballer {

	private String var;
	private String varStatus;
	private Boolean simple = Boolean.FALSE;
	private Boolean search = Boolean.FALSE;
	private Boolean export = Boolean.TRUE;
	private Boolean paginate = Boolean.TRUE;
	private String label;
	private Collection data;
	private List<Element> ths = new ArrayList<Element>();
	private Integer resultsPerPage = 60;
	private Integer totalResults;
	private String toolbar;
	private String url = "#";
	private Boolean rendered = Boolean.TRUE;
	private Boolean checkAll = Boolean.FALSE;
	private String noRowText;

	@Override
	public void doTag() throws JspException, IOException {

		if (rendered) {

			PageContext pageContext = (PageContext) getJspContext();
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

			if (simple) {
				search = Boolean.FALSE;
				export = Boolean.FALSE;
				paginate = Boolean.FALSE;
			}

			TagUtil.flushBody(getJspBody());

			Div grid = new Div();
			grid.add(Attribute.ID, TagUtil.getId());

			Div panel = new Div();
			panel.add(Attribute.CLASS, "panel panel-primary");

			if (!StringUtils.isEmpty(label)) {
				Div panelHead = new Div();
				panelHead.add(Attribute.CLASS, "panel-heading");
				H3 h3 = new H3();
				h3.add(Attribute.CLASS, "panel-title");
				h3.add(TagUtil.getLocalized(label));
				panelHead.add(h3);
				panel.add(panelHead);
			}

			Div panelBody = new Div();
			panelBody.add(Attribute.CLASS, "panel-body");

			if(checkAll){
				Div checkAll = new Div();
				checkAll.add(Attribute.CLASS,"m-5");
				Ul ul = new Ul();
				ul.add(Attribute.CLASS,"list-group");
				Li li = new Li();
				li.add(Attribute.CLASS,"list-group-item");
				Input input = new Input();
				input.add(Attribute.TYPE,"checkbox");
				input.add(Attribute.CLASS,"bs-grid-check-all");
				li.add(input);
				li.add(" " + TagUtil.getLocalizedForLib("grid.check.all"));
				ul.add(li);
				checkAll.add(ul);
				panelBody.add(checkAll);
			}
			
			panel.add(panelBody);
			
			Div div = new Div();
			div.add(Attribute.CLASS, "clearfix");

			if (!StringUtils.isEmpty(toolbar)) {
				Div divForToolbar = new Div();
				divForToolbar.add(Attribute.CLASS, "pull-left m-5 bs-button-group");
				divForToolbar.add(toolbar);
				div.add(divForToolbar);
			}
			
			panelBody.add(div);
			
			if (!CollectionUtils.isEmpty(data)) {

				if (totalResults == null) {
					totalResults = data.size();
				}

				if (export) {
					Div divForExportation = new Div();
					divForExportation.add(Attribute.CLASS, "pull-right m-5");

					Div buttonGroup = new Div();
					buttonGroup.add(Attribute.CLASS, "btn-group");

					Button pdf = new Button();
					pdf.add(Attribute.CLASS, "btn btn-default waves-effect waves-light bs-grid-export-pdf");
					pdf.add(Attribute.TITLE, TagUtil.getLocalizedForLib("grid.export.pdf"));
					pdf.add(new Span().add(Attribute.CLASS, "fa fa-file-pdf-o"));
					buttonGroup.add(pdf);

					Button excel = new Button();
					excel.add(Attribute.CLASS, "btn btn-default waves-effect waves-light bs-grid-export-excel");
					excel.add(Attribute.TITLE, TagUtil.getLocalizedForLib("grid.export.xls"));
					excel.add(new Span().add(Attribute.CLASS, "fa fa-file-excel-o"));
					buttonGroup.add(excel);

					Button csv = new Button();
					csv.add(Attribute.CLASS, "btn btn-default waves-effect waves-light bs-grid-export-csv");
					csv.add(Attribute.TITLE, TagUtil.getLocalizedForLib("grid.export.csv"));
					csv.add(new Span().add(Attribute.CLASS, "fa fa-file-text-o"));
					buttonGroup.add(csv);

					Button xml = new Button();
					xml.add(Attribute.CLASS, "btn btn-default waves-effect waves-light bs-grid-export-xml");
					xml.add(Attribute.TITLE, TagUtil.getLocalizedForLib("grid.export.xml"));
					xml.add(new Span().add(Attribute.CLASS, "fa fa-file-code-o"));
					buttonGroup.add(xml);

					divForExportation.add(buttonGroup);
					div.add(divForExportation);
				}

				if (search) {
					Div divForSearch = new Div();
					divForSearch.add(Attribute.CLASS, "pull-right m-5");
					Input input = new Input();
					input.add(Attribute.TYPE, "search");
					input.add(Attribute.CLASS, "bs-grid-search form-control");
					input.add(Attribute.PLACEHOLDER, TagUtil.getLocalizedForLib("grid.search"));
					divForSearch.add(input);
					div.add(divForSearch);
				}

				Table table = new Table();
				table.add(Attribute.CLASS, "table table-striped table-hover");

				Thead thead = new Thead();
				Tr tr = new Tr();
				thead.add(tr);
				tr.add(this.ths);
				table.add(thead);

				Tbody tbody = new Tbody();
				int index = 0;
				for (Object row : data) {
					getJspContext().setAttribute(var, row);
					if (!StringUtils.isEmpty(varStatus)) {
						getJspContext().setAttribute(varStatus, index);
					}
					Tr line = new Tr();
					line.add(TagUtil.getBody(getJspBody()));
					tbody.add(line);
					index++;
				}
				getJspContext().setAttribute(var, null);
				if (!StringUtils.isEmpty(varStatus)) {
					getJspContext().setAttribute(varStatus, null);
				}

				table.add(tbody);
				panelBody.add(table);

				if(!simple) {
					Div panelFooter = new Div();
					panelFooter.add(Attribute.CLASS, "panel-footer");
	
					Div clearfix = new Div();
					clearfix.add(Attribute.CLASS, "clearfix");
	
					Integer page = (request.getParameter("page") != null ? Integer.valueOf(request.getParameter("page"))
							: 1);
					Integer resultsPerPage = (request.getParameter("resultsPerPage") != null
							? Integer.valueOf(request.getParameter("resultsPerPage")) : this.resultsPerPage);
	
					Integer toResult = page * resultsPerPage;
					Integer fromResult = (toResult + 1) - resultsPerPage;
					if (toResult >= totalResults) {
						toResult = totalResults;
					}
	
					Div display = new Div();
					display.add(Attribute.CLASS, "pull-left m-5");
					display.add(new H5().add(TagUtil.getLocalizedForLib("grid.page.viewing", fromResult,
							toResult, totalResults)));
					clearfix.add(display);
	
					if (paginate) {
						Div divForResultsPerPage = new Div();
						divForResultsPerPage.add(Attribute.CLASS, "pull-right m-5");
	
						Div dropdown = new Div();
						dropdown.add(Attribute.CLASS, "dropup");
						dropdown.add(Attribute.TITLE, TagUtil.getLocalizedForLib("grid.results.per.page"));
	
						Button button = new Button();
						button.add(Attribute.CLASS, "btn btn-default waves-effect waves-light dropdown-toggle");
						button.add(Attribute.DATA_TOGGLE, "dropdown");
						button.add(" " + resultsPerPage + " ");
	
						Span span = new Span();
						span.add(Attribute.CLASS, "caret");
						button.add(span);
	
						dropdown.add(button);
	
						Ul results = new Ul();
						results.add(Attribute.CLASS, "dropdown-menu dropdown-menu-right");
						Integer iteration = 100;
						while (iteration >= 20) {
							Li li = new Li();
							li.add(Attribute.CLASS, "bs-grid-results-per-page-item");
							if (iteration == resultsPerPage) {
								li.add(Attribute.CLASS, "active");
							}
							A a = new A();
							a.add(Attribute.HREF, "#");
							a.add(String.valueOf(iteration));
							li.add(a);
							results.add(li);
							iteration -= 20;
						}
						dropdown.add(results);
						divForResultsPerPage.add(dropdown);
						clearfix.add(divForResultsPerPage);
	
						Integer totalOfPages = new Double(
								Math.ceil(Double.valueOf(totalResults) / Double.valueOf(resultsPerPage))).intValue();
	
						Div pagination = new Div();
						pagination.add(Attribute.CLASS, "pull-right m-5");
						Nav nav = new Nav();
						nav.add(Attribute.CLASS, "pull-left");
						Ul ul = new Ul();
						ul.add(Attribute.CLASS, "pagination");
						for (int i = 1; i <= totalOfPages; i++) {
							Li li = new Li();
							li.add(Attribute.CLASS, "bs-grid-paginate-item");
							if (i == page) {
								li.add(Attribute.CLASS, "active");
							}
							A a = new A();
							a.add(Attribute.HREF, "#");
							a.add(String.valueOf(i));
							li.add(a);
							ul.add(li);
						}
						nav.add(ul);
						pagination.add(nav);
						clearfix.add(pagination);
					}
	
					panelFooter.add(clearfix);
					panel.add(panelFooter);
				}

			} else {
				Div noRow = new Div();
				noRow.add(Attribute.CLASS, "alert alert-info");
				noRow.add(Attribute.ROLE, "alert");
				noRow.add((!StringUtils.isEmpty(noRowText) ? TagUtil.getLocalized(noRowText)
						: TagUtil.getLocalizedForLib("grid.no.row")));
				panelBody.add(noRow);
			}
			
			
			grid.add(panel);

			if(export){
				Div exporter = new Div();
				exporter.add(Attribute.CLASS, "hidden");
				Form form = new Form();
				form.add(Attribute.METHOD, "post");
				form.add(Attribute.TARGET, "_blank");
				form.add(Attribute.CLASS, "bs-grid-export-form");
				form.add(Attribute.ACTION, TagUtil.getPathForUrl(getJspContext(), "/tagria/exporter"));
				Input type = new Input();
				type.add(Attribute.TYPE, "hidden");
				type.add(Attribute.NAME, "type");
				type.add(Attribute.CLASS, "bs-grid-export-type");
				form.add(type);
				Input html = new Input();
				html.add(Attribute.TYPE, "hidden");
				html.add(Attribute.NAME, "json");
				html.add(Attribute.CLASS, "bs-grid-export-json");
				form.add(html);
				exporter.add(form);
				grid.add(exporter);
			}

			TagUtil.out(getJspContext(), grid);

			Script script = new Script();
			script.add(Attribute.TYPE, "text/javascript");
			script.add("$('#" + grid.get(Attribute.ID) + "').grid({ url : '"
					+ TagUtil.getPathForUrl(getJspContext(), url) + "',queryString : '"
					+ TagUtil.queryString(request, new ArrayList<String>() {
						{
							add("page");
							add("property");
							add("direction");
							add("resultsPerPage");
						}
					}) + "'});");
			TagUtil.out(getJspContext(), script);
		}
	}

	public Collection getData() {
		return data;
	}

	public void setData(Collection data) {
		this.data = data;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public List<Element> getThs() {
		return ths;
	}

	public void setThs(List<Element> ths) {
		this.ths = ths;
	}

	public void addTh(Th th) {
		ths.add(th);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}

	public Integer getResultsPerPage() {
		return resultsPerPage;
	}

	public void setResultsPerPage(Integer resultsPerPage) {
		this.resultsPerPage = resultsPerPage;
	}

	public Boolean getSimple() {
		return simple;
	}

	public void setSimple(Boolean simple) {
		this.simple = simple;
	}

	@Override
	public void setToolbar(String html) {
		this.toolbar = html;
	}

	public Boolean getSearch() {
		return search;
	}

	public void setSearch(Boolean search) {
		this.search = search;
	}

	public Boolean getExport() {
		return export;
	}

	public void setExport(Boolean export) {
		this.export = export;
	}

	public Boolean getPaginate() {
		return paginate;
	}

	public void setPaginate(Boolean paginate) {
		this.paginate = paginate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVarStatus() {
		return varStatus;
	}

	public void setVarStatus(String varStatus) {
		this.varStatus = varStatus;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public String getNoRowText() {
		return noRowText;
	}

	public void setNoRowText(String noRowText) {
		this.noRowText = noRowText;
	}

	public Boolean getCheckAll() {
		return checkAll;
	}

	public void setCheckAll(Boolean checkAll) {
		this.checkAll = checkAll;
	}

}
