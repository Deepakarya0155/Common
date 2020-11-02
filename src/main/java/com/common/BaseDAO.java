package com.common;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseDAO {

	@Autowired
	EntityManagerFactory emf;
	
	
	Logger app=Logger.getLogger("app");
	
	
	private SessionFactory getSessionFactory() {
		return emf.unwrap(SessionFactory.class);
	}
	
	private EntityManager getEntityManager() {
		return emf.unwrap(EntityManager.class);
	}
	
	public boolean insert(Object obj) {
		app.info("Insert Method start");
		boolean result=false;
		Session ss=null;
		Transaction tx=null;
		try {
			ss=getSessionFactory().openSession();
			tx=ss.beginTransaction();
			ss.save(obj);
			tx.commit();
			result=true;
			app.info("record saved successfully "+result);
		}catch(Exception e) {
			app.info("Fail to save log  ",e);
		}finally {
			if(ss!=null) {
				ss.close();
			}
		}
		app.info("Insert Method end");
		return result;
	}
	
	public List getAllRecord(Class cls) {
		app.info("getAllRecord Method start");
		boolean result=false;
		Session ss=null;
		Transaction tx=null;
		List ls=null;
		try {
			ss=getSessionFactory().openSession();
			ls=ss.createCriteria(cls).list();
			app.info("Number of record fatched "+ls.size());
		}catch(Exception e) {
			app.info("Fail to save log  ",e);
		}finally {
			if(ss!=null) {
				ss.close();
			}
		}
		app.info("getAllRecord Method end");
		return ls;
	}
	
	public List getEQ(Class cls,String col,Object val) {
		app.info("getEQ Method start");
		boolean result=false;
		Session ss=null;
		Transaction tx=null;
		List ls=null;
		Criteria criteria=null;
		try {
			ss=getSessionFactory().openSession();
			criteria=ss.createCriteria(cls);
			criteria.add(Restrictions.eqOrIsNull(col, val));
			ls=criteria.list();
			app.info("Number of record fatched "+ls.size());
		}catch(Exception e) {
			app.info("Fail to save log  ",e);
		}finally {
			if(ss!=null) {
				ss.close();
			}
		}
		app.info("getEQ Method end");
		return ls;
	}
	
	
	
	
	public List getLessThanEqualsTo(Class cls,String col,Object val) {
		app.info("getLessThanEqualsTo Method start");
		boolean result=false;
		Session ss=null;
		Transaction tx=null;
		List ls=null;
		Criteria criteria=null;
		try {
			ss=getSessionFactory().openSession();
			criteria=ss.createCriteria(cls);
			criteria.add(Restrictions.le(col, val));
			ls=criteria.list();
			app.info("Number of record fatched "+ls.size());
		}catch(Exception e) {
			app.info("Fail to save log  ",e);
		}finally {
			if(ss!=null) {
				ss.close();
			}
		}
		app.info("getLessThanEqualsTo Method end");
		return ls;
	}
	public List getLessThan(Class cls,String col,Object val) {
		app.info("getLessThan Method start");
		boolean result=false;
		Session ss=null;
		Transaction tx=null;
		List ls=null;
		Criteria criteria=null;
		try {
			ss=getSessionFactory().openSession();
			criteria=ss.createCriteria(cls);
			criteria.add(Restrictions.lt(col, val));
			ls=criteria.list();
			app.info("Number of record fatched "+ls.size());
		}catch(Exception e) {
			app.info("Fail to save log  ",e);
		}finally {
			if(ss!=null) {
				ss.close();
			}
		}
		app.info("getLessThan Method end");
		return ls;
	}
	public List getGreterThan(Class cls,String col,Object val) {
		app.info("getGreterThan Method start");
		boolean result=false;
		Session ss=null;
		Transaction tx=null;
		List ls=null;
		Criteria criteria=null;
		try {
			ss=getSessionFactory().openSession();
			criteria=ss.createCriteria(cls);
			criteria.add(Restrictions.gt(col, val));
			ls=criteria.list();
			app.info("Number of record fatched "+ls.size());
		}catch(Exception e) {
			app.info("Fail to save log  ",e);
		}finally {
			if(ss!=null) {
				ss.close();
			}
		}
		app.info("getGreterThan Method end");
		return ls;
	}
	
	public List getGreterThanEqualTo(Class cls,String col,Object val) {
		app.info("getGreterThanEqualTo Method start");
		boolean result=false;
		Session ss=null;
		Transaction tx=null;
		List ls=null;
		Criteria criteria=null;
		try {
			ss=getSessionFactory().openSession();
			criteria=ss.createCriteria(cls);
			criteria.add(Restrictions.ge(col, val));
			ls=criteria.list();
			app.info("Number of record fatched "+ls.size());
		}catch(Exception e) {
			app.info("Fail to save log  ",e);
		}finally {
			if(ss!=null) {
				ss.close();
			}
		}
		app.info("getGreterThanEqualTo Method end");
		return ls;
	}
	
	public List getBetween(Class cls,String col,Object val,Object val2) {
		app.info("getBetween Method start");
		boolean result=false;
		Session ss=null;
		Transaction tx=null;
		List ls=null;
		Criteria criteria=null;
		try {
			ss=getSessionFactory().openSession();
			criteria=ss.createCriteria(cls);
			criteria.add(Restrictions.between(col, val, val2));
			ls=criteria.list();
			app.info("Number of record fatched "+ls.size());
		}catch(Exception e) {
			app.info("Fail to save log  ",e);
		}finally {
			if(ss!=null) {
				ss.close();
			}
		}
		app.info("getBetween Method end");
		return ls;
	}
	
	public List getLike(Class cls,String col,Object val) {
		app.info("getBetween Method start");
		boolean result=false;
		Session ss=null;
		Transaction tx=null;
		List ls=null;
		Criteria criteria=null;
		try {
			ss=getSessionFactory().openSession();
			criteria=ss.createCriteria(cls);
			criteria.add(Restrictions.like(col, "%"+val+"%"));
			ls=criteria.list();
			app.info("Number of record fatched "+ls.size());
		}catch(Exception e) {
			app.info("Fail to save log  ",e);
		}finally {
			if(ss!=null) {
				ss.close();
			}
		}
		app.info("getBetween Method end");
		return ls;
	}
	
	public boolean remove(Class cls,String col,Object val) {
		app.info("remove Method start");
		boolean result=false;
		Session ss=null;
		Transaction tx=null;
		try {
			ss=getSessionFactory().openSession();
			tx=ss.beginTransaction();
			for(Object o:ss.createCriteria(cls).add(Restrictions.eqOrIsNull(col, val)).list()){
				ss.delete(o);
			}
			tx.commit();
			result=true;
			app.info("record removed successfully "+result);
		}catch(Exception e) {
			app.info("Fail to remove log  ",e);
		}finally {
			if(ss!=null) {
				ss.close();
			}
		}
		app.info("remove Method end");
		return result;
	}
	
	public boolean update(Object obj) {
		app.info("update Method start");
		boolean result=false;
		Session ss=null;
		Transaction tx=null;
		try {
			ss=getSessionFactory().openSession();
			tx=ss.beginTransaction();
			ss.update(obj);
			tx.commit();
			result=true;
			app.info("update  successfully "+result);
		}catch(Exception e) {
			app.info("Fail to update log  ",e);
		}finally {
			if(ss!=null) {
				ss.close();
			}
		}
		app.info("update Method end");
		return result;
	}
}
