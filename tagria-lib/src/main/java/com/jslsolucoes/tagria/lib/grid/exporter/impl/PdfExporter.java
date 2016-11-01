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

import java.io.OutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jslsolucoes.tagria.lib.grid.exporter.model.Column;
import com.jslsolucoes.tagria.lib.grid.exporter.model.Header;
import com.jslsolucoes.tagria.lib.grid.exporter.model.Row;
import com.jslsolucoes.tagria.lib.grid.exporter.model.Table;


public class PdfExporter {
	private Table table;
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 6, Font.BOLD);

	public PdfExporter(Table table) {
		this.table = table;
	}

	public void doExport(OutputStream out) throws Exception {
		Document document = new Document();
		PdfWriter.getInstance(document, out);
		document.open();
		PdfPTable pdf = new PdfPTable(table.getHeaders().size());
		pdf.setWidthPercentage(100);
		title(pdf);
		header(pdf);
		body(pdf);
		document.add(pdf);
		document.close();
	}

	private void title(PdfPTable pdf) {
		PdfPCell cell = new PdfPCell(new Phrase(table.getTitle(), smallBold));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(table.getHeaders().size());
		pdf.addCell(cell);
	}

	private void header(PdfPTable pdf) {
		for (Header header : table.getHeaders()) {
			PdfPCell cell = new PdfPCell(new Phrase(header.getContent(), smallBold));
			if (header.getAlign().equals("center"))
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			else if (header.getAlign().equals("left"))
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			else if (header.getAlign().equals("right"))
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			pdf.addCell(cell);
		}
	}

	private void body(PdfPTable pdf) throws Exception {
		for (Row row : table.getRows()) {
			for (Column column : row.getColumns()) {
				PdfPCell cell = new PdfPCell(new Phrase(column.getContent(), smallBold));
				if (column.getAlign().equals("center"))
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				else if (column.getAlign().equals("left"))
					cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				else if (column.getAlign().equals("right"))
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				pdf.addCell(cell);
			}
		}
	}

}
