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
package com.jslsolucoes.tagria.lib.compressor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.mozilla.javascript.EvaluatorException;

import com.google.javascript.jscomp.CompilationLevel;
import com.google.javascript.jscomp.Compiler;
import com.google.javascript.jscomp.CompilerOptions;
import com.google.javascript.jscomp.CompilerOptions.LanguageMode;
import com.google.javascript.jscomp.JSSourceFile;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.yahoo.platform.yui.compressor.CssCompressor;

@SuppressWarnings("deprecation")
public class Compressor {

	private List<String> themes = Arrays.asList(new String[] { "default", "green" });
	private String source;
	private Boolean compress;
	private String destination;

	public Compressor(String source, String destination, Boolean compress) {
		this.source = source;
		this.compress = compress;
		this.destination = destination;
	}

	public void compressJs() throws IOException {

		String[] files = new String[] { "jquery/jquery.js", "bootstrap/bootstrap.js", "jquery/ui/jquery.ui.js",
				"jquery/ui/jquery.ui.form.js", "jquery/ui/jquery.ui.iframe.js", "jquery/ui/jquery.ui.grid.js",
				"jquery/ui/jquery.ui.detail.table.js", "jquery/ui/jquery.ui.auto.complete.js",
				"jquery/ui/jquery.ui.moment.js", "jquery/ui/jquery.ui.calendar.js", "jquery/ui/jquery.ui.input.mask.js",
				"jquery/ui/jquery.ui.treeview.js", "jquery/ui/jquery.ui.tabs.js",
				"jquery/ui/jquery.ui.treeview.widget.js", "jquery/ui/jquery.ui.time.picker.js",
				"jquery/ui/jquery.ui.input.currency.mask.js", "jquery/ui/jquery.ui.wave.js",
				"jquery/ui/jquery.ui.chart.js" };

		List<String> contents = new ArrayList<String>();
		for (String file : files) {
			contents.add(FileUtils.readFileToString(new File(new File(source, "js"), file), "UTF-8"));
		}

		String content = StringUtils.join(contents, "\n");
		FileUtils.writeStringToFile(new File(new File(destination, "js"), "tagria-ui.js"),
				(compress ? minifyJs(content, CompilationLevel.SIMPLE_OPTIMIZATIONS) : content), "UTF-8");
		System.out.println("JS COMPRESSED");
	}

	public String minifyJs(String code, CompilationLevel compilationLevel) throws EvaluatorException, IOException {
		Compiler compiler = new Compiler();
		CompilerOptions options = new CompilerOptions();
		compilationLevel.setOptionsForCompilationLevel(options);
		options.setLanguageIn(LanguageMode.ECMASCRIPT5);
		JSSourceFile input = JSSourceFile.fromCode("input.js", code);
		compiler.compile(JSSourceFile.fromCode("output.js", ""), input, options);
		return compiler.toSource();
	}

	private void copyFileToDirectory(String resource) throws IOException {
		
		File root = new File(new File(source, resource), "theme");
		
		for (String theme : themes) {
			File themeFolder = new File(root, theme);
			if(!themeFolder.exists()){
				themeFolder.mkdir();
			}
			Stream.concat(Arrays.asList(new File(root, "base").listFiles())
			.stream(),Arrays.asList(themeFolder.listFiles()).stream())
			.forEach(file -> {
				try {
					FileUtils.copyFileToDirectory(file, new File(new File(new File(destination, resource), "theme"),theme));
				} catch(Exception exception){
					throw new RuntimeException(exception);
				}
			});
		}
		
	}

	public void compressFonts() throws IOException {
		copyFileToDirectory("fonts");
		System.out.println("FONTS COMPRESSED");
	}

	public void compressImage() throws IOException {
		copyFileToDirectory("image");
		System.out.println("IMAGES COMPRESSED");
	}

	public void compressCss() throws IOException, FileNotFoundException {

		File root = new File(new File(source, "css"), "theme");
		
		for (String theme : themes) {
			
			String[] files = new String[] { "tagria.bootstrap.css", "tagria.bootstrap.extension.css",
					"tagria.common.css", "tagria.font.awesome.css", "tagria.fullcalendar.css", "tagria.jquery.ui.css",
					"tagria.jquery.ui.theme.css", "tagria.jquery.ui.treeview.css", "tagria.jquery.ui.timepicker.css",
					"tagria.jquery.ui.wave.css", "tagria.jquery.ui.loading.css", "tagria.jquery.ui.card.css" };
			
			String content = StringUtils.join(Stream.concat(Arrays
			.asList(files)
			.stream()
			.map(file -> {
				return new File(new File(root, "base"), file);
			}), Arrays.asList(new File(root, theme).listFiles())
			.stream()).map(file -> {
				return normalizeCssFile(file, theme);
			})
			.collect(Collectors.toList()),"\n");
			
			FileUtils.writeStringToFile(new File(new File(new File(new File(destination, "css"), "theme"), theme), "tagria-ui.css")
					, (compress ? minifyCss(content) : content), "UTF-8");
			System.out.println("CSS THEME " + theme.toUpperCase() + " COMPRESSED");
		}
	}

	private String minifyCss(String code) throws IOException {
		StringWriter minified = new StringWriter();
		try {
			CssCompressor cssCompressor = new CssCompressor(new StringReader(code));
			cssCompressor.compress(minified, -1);
			return minified.toString();
		} finally {
			minified.close();
		}
	}

	private String normalizeCssFile(File cssFile, String theme) {
		try {
			String normalized = FileUtils.readFileToString(cssFile, "UTF-8").replaceAll("\\$\\{theme\\}", theme);
	
			Set<String> extensions = new HashSet<String>();
			extensions.add("png");
			extensions.add("gif");
			extensions.add("eot");
			extensions.add("svg");
			extensions.add("ttf");
			extensions.add("woff");
			extensions.add("woff2");
			extensions.add("otf");
			for (String extension : extensions) {
				normalized = normalized.replaceAll("\\." + extension + "('|\")",
						"." + extension + "?ver=" + TagUtil.getVersion() + "$1");
			}
			return normalized;
		} catch(Exception exception){
			throw new RuntimeException(exception);
		}
	}
}
