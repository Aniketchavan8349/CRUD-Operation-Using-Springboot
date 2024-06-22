package com.tka.DemoDatabase.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.tka.DemoDatabase.entity.person1;


@Repository
public class Person1Dao {

	
	@Autowired
	SessionFactory factory;
	
	public String insertData(person1 p) {
		
	Session session=factory.openSession();
		
		session.beginTransaction();
		session.persist(p);
		session.getTransaction().commit();
		session.close();
		
		return"Record is Saved...";
		
		
	}
	//for updating data
	public String updateData(int id,person1 p) {
		
	     Session session=factory.openSession();
	     session.beginTransaction();
	     
	    person1 record= session.get(person1.class,id);
	     
	    record.setEmail(p.getEmail());
	     record.setFname(p.getFname());
	     record.setMobileno(p.getMobileno());
	     
	     session.merge(record);
	     
	     session.getTransaction().commit();
	     session.close();
		return" your record are Update succesfully...";
	}
	
	public String deleteData(int id) {
		
		Session session=factory.openSession();
			
			session.beginTransaction();
			person1 p1= session.get(person1.class,id);
			session.remove(p1);
			session.getTransaction().commit();
			session.close();
			
			return"Record is Deleted...";
		}
	
		public person1 getPerticularRecord(int id) {
				
				Session session=factory.openSession();
					
					session.beginTransaction();
					String hqlQuery="from person1 where id=:myid";
				Query<person1> query=session.createQuery(hqlQuery,person1.class);
					query.setParameter("myid",id);
					
				 person1 p=	query.uniqueResult();
					session.getTransaction().commit();
					session.close();
					
					return p;
				}
		
		public List<person1> getAllRecord() {
			
			Session session=factory.openSession();
				
				session.beginTransaction();
				String hqlQuery="from person1";
			Query<person1> query=session.createQuery(hqlQuery,person1.class);
				
			List<person1> list= query.list();
				
			
				session.getTransaction().commit();
				session.close();
				
				return list;
			}
			
}
