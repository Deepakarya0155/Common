package com.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Common {
	
	public List<String> readFile(String FilePath) throws FileNotFoundException {
		File fl=new File(FilePath);
		return readFile(fl);
	}
	public List<String> readFile(File FilePath) throws FileNotFoundException {
		Scanner scan=new Scanner(FilePath);
		List<String> data=new ArrayList<String>();
		while(scan.hasNext()) {
			data.add(scan.nextLine());
		}
		return data;
	}
	public File LoadFileFromResource(String file) throws URISyntaxException, IOException {
		URL url=CommonApplication.class.getClassLoader().getResources("load_employees.dump").nextElement();
		return new File(url.toURI());
	}
	
	
	public static Date fromPatternToDate(String pattern,String val) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		return sdf.parse(val);
	}
	public static String fromDateToPattern(String pattern,Date val) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		return sdf.format(val);
	}
	
	public static String listToString(List<String> ls) {
		String s="";
		for(String i:ls) {
			s+=i+";";
		}
		return s;
	}
	
}
