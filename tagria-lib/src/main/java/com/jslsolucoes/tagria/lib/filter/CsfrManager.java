package com.jslsolucoes.tagria.lib.filter;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class CsfrManager {
	
	private static Map<String,String> tokens = new HashMap<String,String>();

	public static boolean isValidFor(String id, String token) {
		String forCompare = tokens.get(id);
		if(!StringUtils.isEmpty(forCompare) && StringUtils.equals(forCompare, token)){
			tokens.remove(id);
			return true;
		} else {
			return false;
		}
	}
	
	public static void persist(String id,String token) {
		tokens.put(id, token);
	}

}
