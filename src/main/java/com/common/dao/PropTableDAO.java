package com.common.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.common.BaseDAO;
import com.common.CommonValidations;
import com.common.entity.PropertiesTable;

@Component
public class PropTableDAO {
	
	@Autowired
	BaseDAO basedao;
	
	Logger app=Logger.getLogger("app");
	
	Class cls=PropertiesTable.class;
	
	public Boolean addNewKey(String key,String val) {
		Boolean response=false;
		PropertiesTable prop=new PropertiesTable();
		prop.setK(key);
		prop.setV(val);
		response=basedao.insert(prop);
		if(response) {
			app.info("Key inserted success key "+key+" val "+val);
		}else {
			app.info("key inserted fail key "+key+" val "+val);
		}
		return response;
	}

	public String getKey(String key) {
		List<PropertiesTable> ls =basedao.getEQ(cls, "key", key);
		if(CommonValidations.isNotNull(ls)) {
			return ls.get(0).getV();
		}
		else {
			return "";
		}
	}
}
