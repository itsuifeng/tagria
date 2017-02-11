package com.jslsolucoes.tagria.lib.chart;

import java.util.Random;

public class ChartUtil {
	
	private ChartUtil(){
		
	}

	public static String backgroundColor(){
		return random();
	}
	
	public static String borderColor(){
		return random();
	}
	
	public static String backgroundHoverColor(){
		return random();
	}
	
	private static String random(){
		Random random = new Random();
        int nextInt = random.nextInt(256*256*256);
        return String.format("#%06x", nextInt); 
	}
}
