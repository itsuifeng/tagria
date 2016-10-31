package com.jslsolucoes.tagria.lib.compressor;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class ResourceCompressor {

	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

		Compressor compressor = new Compressor(args[0],Boolean.valueOf(args[1]));
		compressor.compressJs();
		compressor.compressCss();
		compressor.compressImage();
		compressor.compressFonts();

	}
}
