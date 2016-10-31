package com.jslsolucoes.tagria.lib.grid.exporter.impl;

import java.io.ByteArrayInputStream;
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
	public void doExport(OutputStream outputStream) throws Exception {
		IOUtils.copy(new ByteArrayInputStream(export()), outputStream);
	}
	
	private byte[] export(){
		StringBuffer xml = new StringBuffer();
		init(xml);
		start(xml);
		title(xml);
		header(xml);
		body(xml);
		end(xml);
		return xml.toString().getBytes();
	}
	
	private void header(StringBuffer xml) {
		xml.append("<header>");
		for (Header header : table.getHeaders()) {
			xml.append("<column>");
			xml.append(header.getContent());
			xml.append("</column>");
		}
		xml.append("</header>");
	}
	
	private void body(StringBuffer xml) {
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

	private void title(StringBuffer xml) {
		xml.append("<title>");
		xml.append(table.getTitle());
		xml.append("</title>");

	}

	private void init(StringBuffer xml) {
		xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	}

	private void end(StringBuffer xml) {
		xml.append("</data>");
	}

	private void start(StringBuffer xml) {
		xml.append("<data>");
	}
}
