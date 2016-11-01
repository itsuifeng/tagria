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
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.mozilla.javascript.EvaluatorException;

import com.google.javascript.jscomp.CompilationLevel;
import com.google.javascript.jscomp.Compiler;
import com.google.javascript.jscomp.CompilerOptions;
import com.google.javascript.jscomp.CompilerOptions.LanguageMode;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.google.javascript.jscomp.JSSourceFile;
import com.yahoo.platform.yui.compressor.CssCompressor;

@SuppressWarnings("deprecation")
public class Compressor {

	private List<String> themes = Arrays.asList(new String[] { "default", "green" });
	private String workspace;
	private Boolean minify;

	public Compressor(String workspace, Boolean minify) {
		this.workspace = workspace;
		this.minify = minify;
	}

	public void compressJs() throws IOException {

		String jsFolder = getPackageBase() + "js" + File.separator;

		String[] jsSequence = new String[] { "jquery/jquery.js", "bootstrap/bootstrap.js", "jquery/ui/jquery.ui.js",
				"jquery/ui/jquery.ui.form.js", "jquery/ui/jquery.ui.iframe.js", "jquery/ui/jquery.ui.grid.js",
				"jquery/ui/jquery.ui.detail.table.js", "jquery/ui/jquery.ui.auto.complete.js",
				"jquery/ui/jquery.ui.moment.js", "jquery/ui/jquery.ui.calendar.js",
				"jquery/ui/jquery.ui.calendar.pt.br.js", "jquery/ui/jquery.ui.input.mask.js",
				"jquery/ui/jquery.ui.treeview.js", "jquery/ui/jquery.ui.tabs.js",
				"jquery/ui/jquery.ui.treeview.widget.js", "jquery/ui/jquery.ui.time.picker.js",
				"jquery/ui/jquery.ui.input.currency.mask.js","jquery/ui/jquery.ui.wave.js",};

		File minified = new File(jsFolder + "tagria-ui.js");
		if (minified.exists()) {
			minified.delete();
		}

		StringBuilder finalFile = new StringBuilder();
		for (String js : jsSequence) {
			File jsFile = new File(jsFolder + File.separator + js);
			finalFile.append(FileUtils.readFileToString(jsFile, "UTF-8"));
			finalFile.append("\n");
		}

		String js = finalFile.toString();
		if (minify) {
			js = minifyJs(finalFile.toString(), CompilationLevel.SIMPLE_OPTIMIZATIONS);
		}
		FileUtils.writeStringToFile(minified, js, "UTF-8");
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

	private String getPackageBase() {
		return workspace + "/src/main/resources/com/jslsolucoes/tagria/lib/";
	}
	
	private void copyFileToDirectory(String resource) throws IOException{
		File themeFolder = new File(new File(getPackageBase(), resource), "theme");
		File baseThemeFolder = new File(themeFolder, "base");
		
		for (File file : baseThemeFolder.listFiles()) {
			for (String theme : themes) {
				File folder = new File(themeFolder,theme);
				File resourceFile = new File(folder,file.getName());
				if(!resourceFile.exists()) {
					FileUtils.copyFileToDirectory(file,folder);
				}
			}
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

		File cssThemeFolder = new File(new File(getPackageBase(), "css"), "theme");
		File baseThemeFolder = new File(cssThemeFolder, "base");

		for (String theme : themes) {
			File themeFolder = new File(cssThemeFolder, theme);

			String[] cssSequence = new String[] { "tagria.bootstrap.css", "tagria.bootstrap.extension.css", "tagria.common.css",
					"tagria.font.awesome.css", "tagria.fullcalendar.css", "tagria.jquery.ui.css", "tagria.jquery.ui.theme.css",
					"tagria.jquery.ui.treeview.css", "tagria.jquery.ui.timepicker.css","tagria.jquery.ui.wave.css",
					"tagria.jquery.ui.loading.css","tagria.jquery.ui.card.css" };

			File full = new File(themeFolder, "tagria-ui.css");
			if (full.exists())
				full.delete();

			StringBuilder merged = new StringBuilder();
			for (String css : cssSequence) {
				File cssFile = new File(themeFolder, css);
				if (!cssFile.exists()) {
					cssFile = new File(baseThemeFolder, css);
				}
				merged.append(normalizeCssFile(cssFile, theme));
			}

			for (File file : themeFolder.listFiles()) {
				merged.append(normalizeCssFile(file, theme));
			}

			FileUtils.writeStringToFile(full, (minify ? minifyCss(merged.toString()) : merged.toString()), "UTF-8");
			System.out.println("CSS THEME " + theme.toUpperCase() + " COMPRESSED");
		}
	}

	private String minifyCss(String code) throws IOException {
		StringWriter minified = new StringWriter();
		try {
			CssCompressor cssCompressor = new CssCompressor(new StringReader(code));
			cssCompressor.compress(minified,-1);
			return minified.toString();
		} finally {
			minified.close();
		}
	}

	private String normalizeCssFile(File cssFile, String theme) throws IOException {
		String normalized = FileUtils.readFileToString(cssFile, "UTF-8")
				.replaceAll("\\$\\{theme\\}", theme);
		
		Set<String> extensions = new HashSet<String>();
		extensions.add("png");
		extensions.add("gif");
		extensions.add("eot");
		extensions.add("svg");
		extensions.add("ttf");
		extensions.add("woff");
		extensions.add("woff2");
		extensions.add("otf");
		for(String extension : extensions){
			normalized = normalized.replaceAll("\\." + extension + "('|\")", "."+extension+"?ver=" + TagUtil.getVersion() + "$1");
		}
		return normalized;
	}
}
