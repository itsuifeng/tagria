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
package com.jslsolucoes.tagria.lib.grid.exporter.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

import com.jslsolucoes.tagria.lib.grid.exporter.model.Column;
import com.jslsolucoes.tagria.lib.grid.exporter.model.Header;
import com.jslsolucoes.tagria.lib.grid.exporter.model.Row;
import com.jslsolucoes.tagria.lib.grid.exporter.model.Table;

public class XmlExporter {
	private Table table;

	public XmlExporter(Table table) {
		this.table = table;
	}
	public void doExport(OutputStream outputStream) throws IOException  {
		IOUtils.copy(new ByteArrayInputStream(export()), outputStream);
	}
	
	private byte[] export(){
		StringBuilder xml = new StringBuilder();
		init(xml);
		start(xml);
		title(xml);
		header(xml);
		body(xml);
		end(xml);
		return xml.toString().getBytes();
	}
	
	private void header(StringBuilder xml) {
		xml.append("<header>");
		for (Header header : table.getHeaders()) {
			xml.append("<column>");
			xml.append(header.getContent());
			xml.append("</column>");
		}
		xml.append("</header>");
	}
	
	private void body(StringBuilder xml) {
		xml.append("<body>");
		for (Row row : table.getRows()) {
			xml.append("<row>");
			for (Column column : row.getColumns()) {
				xml.append("<column>");
				xml.append(column.getContent());
				xml.append("</column>");
			}
			xml.append("</row>");
		}
		xml.append("</body>");
	}

	private void title(StringBuilder xml) {
		xml.append("<title>");
		xml.append(table.getTitle());
		xml.append("</title>");

	}

	private void init(StringBuilder xml) {
		xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	}

	private void end(StringBuilder xml) {
		xml.append("</data>");
	}

	private void start(StringBuilder xml) {
		xml.append("<data>");
	}
}
