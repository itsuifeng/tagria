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
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.util.IOUtils;

import com.jslsolucoes.tagria.lib.grid.exporter.model.Column;
import com.jslsolucoes.tagria.lib.grid.exporter.model.Header;
import com.jslsolucoes.tagria.lib.grid.exporter.model.Row;
import com.jslsolucoes.tagria.lib.grid.exporter.model.Table;

public class CsvExporter {
	private Table table;
	
	
	public CsvExporter(Table table) {
		this.table = table;
	}

	public void doExport(OutputStream outputStream) throws Exception {
		IOUtils.copy(new ByteArrayInputStream(export()), outputStream);
	}

	
	private byte[] export(){
		StringBuffer csv = new StringBuffer();
		header(csv);
		body(csv);
		return csv.toString().getBytes();
	}
	
	private void header(StringBuffer csv) {
		
		List<String> headers = new ArrayList<String>();
		for(Header header : table.getHeaders()){
			headers.add(header.getContent());
		}
		csv.append(StringUtils.join(headers.toArray(), ",").concat(System.lineSeparator()));
	}
	
	private void body(StringBuffer csv) {
		
		for (Row row : table.getRows()) {
			List<String> line = new ArrayList<String>();
			for (Column column : row.getColumns()) {
				line.add(column.getContent());
			}
			csv.append(StringUtils.join(line.toArray(), ",").concat(System.lineSeparator()));
		}
	}
}
