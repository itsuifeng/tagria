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

public enum HttpHeaderParameter {
	ETAG("Etag"), CACHE_CONTROL("Cache-Control"), EXPIRES("Expires"), ACCESS_CONTROL_ALLOW_ORIGIN("Access-Control-Allow-Origin");

	private String name;

	private HttpHeaderParameter(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
