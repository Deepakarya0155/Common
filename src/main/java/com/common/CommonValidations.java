package com.common;

import java.util.List;

public class CommonValidations {
	
	public static boolean isNotNull(String ss) {
		if(ss!=null && !ss.trim().equals("")) {
			return true;
		}
		return false;
	}
	public static boolean isNotNull(List ls) {
		if(ls!=null && ls.size()>0) {
			return true;
		}
		return false;
	}
}
