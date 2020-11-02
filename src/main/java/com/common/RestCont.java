package com.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.entity.Employee;

@RestController
@RequestMapping(path="rest")
public class RestCont {

	@Autowired
	BaseDAO basedao;
	
	@CrossOrigin
	@GetMapping("/test")
	public List test(String data) throws ParseException, AddressException, MessagingException, URISyntaxException, IOException {
		
		
		return null;
	}
	
	
	public String saveTest() throws ParseException, FileNotFoundException, URISyntaxException, IOException {
		Common common=new Common();
		List<String> ls=common.readFile(common.LoadFileFromResource("load_employees.dump"));
		System.out.println(ls.size());
		
		for(int i=1141;i<ls.size();i++) {
			Employee em=new Employee();
			String[] Sub=ls.get(i).substring(ls.get(i).indexOf("(")+1,ls.get(i).indexOf(")")).split(",");
			em.setEmp_no(Integer.parseInt(Sub[0]));
			em.setBirth_date(common.fromPatternToDate("yyyy-MM-dd", Sub[1].replace("'", "")));
			em.setHire_date(common.fromPatternToDate("yyyy-MM-dd", Sub[5].replace("'", "")));
			em.setFirst_name(Sub[2]);
			em.setLast_name(Sub[3]);
			System.out.println(Sub[4]);
			if(Sub[4].equalsIgnoreCase("'M'")) {
				em.setGender(em.getGender().M);
			}else {
				em.setGender(em.getGender().F);
			}
			
				if(basedao.insert(em)) {
					System.out.println("success");
				}else {
					System.out.println("Fail");
				}
			
			
		}
		return ls.get(0);
	}
}
