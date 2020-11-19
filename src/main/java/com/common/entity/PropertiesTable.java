package com.common.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="propertiestable")
public class PropertiesTable {
	@Id
	String K;
	String V;
	public String getK() {
		return K;
	}
	public void setK(String k) {
		K = k;
	}
	public String getV() {
		return V;
	}
	public void setV(String v) {
		V = v;
	}
	
}
