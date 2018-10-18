package com._520it._01_pss.util;

public class StringUtils {

	private StringUtils(){
		
	}
	public static boolean hasLength(String value){
		return value != null &&!"".equals(value.trim());
		
	}
}
