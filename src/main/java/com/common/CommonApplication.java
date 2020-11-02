package com.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonApplication {
	
	static Logger log=Logger.getLogger("app");
	
	public static void main(String[] args) throws IOException, URISyntaxException, ParseException {
		SpringApplication.run(CommonApplication.class, args);
		log.info("Applicatin Started");
		
	
		
		
//		common.fromPatternToDate("yyyy-mm-dd", val)
	}
	
	
	

}
