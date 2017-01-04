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
package com.jslsolucoes.tagria.lib.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.joda.time.Seconds;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jslsolucoes.tagria.lib.grid.exporter.impl.CsvExporter;
import com.jslsolucoes.tagria.lib.grid.exporter.impl.ExcelExporter;
import com.jslsolucoes.tagria.lib.grid.exporter.impl.PdfExporter;
import com.jslsolucoes.tagria.lib.grid.exporter.impl.XmlExporter;
import com.jslsolucoes.tagria.lib.grid.exporter.model.Table;
import com.jslsolucoes.tagria.lib.util.TagUtil;

@SuppressWarnings("serial")
@WebServlet(name="tagria", urlPatterns="/tagria/*",loadOnStartup=1)
public class Tagria extends HttpServlet {

	private static String CHARSET = "utf-8";
	private static Integer CACHE_EXPIRES_DAY = 365;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI().replaceAll(";jsessionid=.*", "");
		System.out.println(uri);
		String etag = DigestUtils.sha256Hex(uri);
		
		if (uri.endsWith("blank")) {
			response.setStatus(HttpServletResponse.SC_OK);
			return;
		}
		
		if (uri.endsWith("locale")) {
			
			System.out.println(request.getParameter("locale"));
			
			response.setStatus(HttpServletResponse.SC_OK);
			request.getSession().setAttribute("tagria-locale", 
					request.getParameter("locale"));
			return;
		}
		
		if (request.getHeader("If-None-Match") != null
				&& etag.equals(request.getHeader("If-None-Match"))) {
			response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
			return;
		}
		
		if (TagUtil.getInitParam(TagriaConfigParameter.ENCODING) != null)
			CHARSET = TagUtil.getInitParam(TagriaConfigParameter.ENCODING);
		response.setCharacterEncoding(CHARSET);
		try {
			
			DateTime today = new DateTime();
			DateTime expires = new DateTime().plusDays(CACHE_EXPIRES_DAY);

			if (uri.endsWith(".css")) {
				response.setContentType("text/css");
			} else if (uri.endsWith(".js")) {
				response.setContentType("text/javascript");
			} else if (uri.endsWith(".png")) {
				response.setContentType("image/png");
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss 'GMT'", Locale.ENGLISH);
			
			if(Boolean.valueOf(TagUtil.getInitParam(TagriaConfigParameter.CDN_ENABLED))){
				response.setHeader(HttpHeaderParameter.ACCESS_CONTROL_ALLOW_ORIGIN.getName(), "*");
			}
			
			response.setHeader(HttpHeaderParameter.ETAG.getName(),etag);
			response.setHeader(HttpHeaderParameter.EXPIRES.getName(), sdf.format(expires.toDate()));
			response.setHeader(HttpHeaderParameter.CACHE_CONTROL.getName(),
					"public,max-age=" + Seconds.secondsBetween(today, expires).getSeconds());

			String url = "/com/jslsolucoes"
					+ uri.replaceFirst(request.getContextPath(), "").replaceAll(";jsessionid=.*", "");
			InputStream in = getClass().getResourceAsStream(url);
			IOUtils.copy(in, response.getOutputStream());
			in.close();

		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Gson gson = new GsonBuilder().create();
			String json = request.getParameter("json");
			String type = request.getParameter("type");
			Table table = gson.fromJson(json, Table.class);
			response.setHeader("Content-Disposition", "attachment; filename=grid."+type);
			if (request.getParameter("type").equals("pdf")) {
				response.setContentType("application/pdf");
				PdfExporter exporter = new PdfExporter(table);
				exporter.doExport(response.getOutputStream());
			} else if (request.getParameter("type").equals("csv")) {
				response.setContentType("text/csv");
				CsvExporter exporter = new CsvExporter(table);
				exporter.doExport(response.getOutputStream());
			} else if (request.getParameter("type").equals("xml")) {
				response.setContentType("text/xml");
				XmlExporter exporter = new XmlExporter(table);
				exporter.doExport(response.getOutputStream());
			} else if (request.getParameter("type").equals("xls")) {
				response.setContentType("application/vnd.ms-excel");
				ExcelExporter exporter = new ExcelExporter(table);
				exporter.doExport(response.getOutputStream());
			}
		} catch(Exception e){
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
}
