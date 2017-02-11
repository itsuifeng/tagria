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

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class ResourceCompressor {
	
	private ResourceCompressor(){
		
	}

	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

		Compressor compressor = new Compressor(args[0],args[1],Boolean.valueOf(args[2]));
		compressor.compressJs();
		compressor.compressCss();
		compressor.compressImage();
		compressor.compressFonts();

	}
}
