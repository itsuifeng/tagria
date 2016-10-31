package com.jslsolucoes.tagria.lib.html;

public class Script extends Element {

	@Override
	public String getTag() {
		return "script";
	}
	
	public boolean forceCloseTagWithEmptyBody() {
		return true;
	}

}
