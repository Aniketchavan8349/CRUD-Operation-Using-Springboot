package com.example.ProjectDemo.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ProjectDemo.entity.Country;
import com.example.ProjectDemo.entity.Employee2;



@Repository
public class MainDao {

	
	
	@Autowired
	SessionFactory factory;
	
	public String addCountry(Country c) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			session.persist(c);
			tx.commit();
			msg="Data added succesfully...";
		} catch (Exception e) {
		
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}
	
	public String updateData(Country c) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			
			Country country=session.get(Country.class,c.getCid());
			country.setCname(c.getCname());
			session.merge(country);
			
			tx.commit();
			msg="Data is updated succesfully...";
		} catch (Exception e) {
		
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}
	
   public String deleteCountry(Country c) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Country country=session.get(Country.class,c.getCid());
			session.remove(country);
			
			tx.commit();
			msg="Data is Deleted succesfully...";
		} catch (Exception e) {
		
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}
	
		public Country getPerticularRecord(Country c) {
			
			Session session=null;
			Transaction tx=null;
			String msg=null;
			Country c1=null;
			
			try {
				session=factory.openSession();
				tx=session.beginTransaction();
				
				
				
				String hqlQuery="from Country where id=:myid";
				
				Query<Country> query= session.createQuery(hqlQuery,Country.class);
				query.setParameter( "myid",c.getCid());
				
				
				c1= query.uniqueResult();
				tx.commit();
				
			} catch (Exception e1) {
			
				if(tx!=null) {
					tx.rollback();
				}
				e1.printStackTrace();
			
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			
			return c1;
			}
		
		
		public List<Country> getAllRecords() {
			
			Session session=null;
			Transaction tx=null;
			String msg=null;
			List<Country> list = null;
			
			
			try {
				session=factory.openSession();
				tx=session.beginTransaction();
					
			String hqlQuery="from Country";
			
			Query<Country> query= session.createQuery(hqlQuery,Country.class);
			
			 list= query.list();
			
			tx.commit();
			msg="Data added succesfully...";
		} catch (Exception e) {
		
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		
		return list;
		}
		
		//Employee Class
		
		public String addEmployee(Employee2 e) {
			
			Session session=null;
			Transaction tx=null;
			String msg=null;
			
			try {
				session=factory.openSession();
				tx=session.beginTransaction();
				
				
				session.persist(e);
				
				tx.commit();
				msg="Data is updated succesfully...";
			} catch (Exception e1) {
			
				if(tx!=null) {
					tx.rollback();
				}
				e1.printStackTrace();
			
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			
			return msg;
		}
		
		
		public String updateEmployee(Employee2 e) {
			
			Session session=null;
			Transaction tx=null;
			String msg=null;
			
			try {
				session=factory.openSession();
				tx=session.beginTransaction();
				
				
				Employee2 emp=session.get(Employee2.class,e.getId());
				emp.setName(e.getName());
				emp.setStatus(e.getStatus());
				emp.setCreatedby(e.getCreatedby());
				emp.setCountry(e.getCountry());
				emp.setCreatedt(e.getCreatedt());
				emp.setDepartment(e.getDepartment());
				emp.setUpdateby(e.getUpdateby());
				emp.setUpdatedt(e.getUpdatedt());
				
				
				session.merge(emp);
				
				tx.commit();
				msg="Data is updated succesfully...";
			} catch (Exception e1) {
			
				if(tx!=null) {
					tx.rollback();
				}
				e1.printStackTrace();
			
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			
			return msg;
		}
		
		
		
		
		
		public String deleteEmployee(Employee2 e) {
			
			Session session=null;
			Transaction tx=null;
			String msg=null;
			
			try {
				session=factory.openSession();
				tx=session.beginTransaction();
				
			    Employee2 emp=session.get(Employee2.class,e.getId());
				session.remove(emp);
				
				tx.commit();
				msg="Employee Data will be Deleted succesfully...";
			} catch (Exception e1) {
			
				if(tx!=null) {
					tx.rollback();
				}
				e1.printStackTrace();
			
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			
			return msg;
		
		}
		
		public Employee2 getPerticularEmployee(Employee2 e) {
			
			Session session=null;
			Transaction tx=null;
			Employee2 emp=null ;
			
			try {
				session=factory.openSession();
				tx=session.beginTransaction();
				
				
				
				String hqlQuery="from Employee2 where id=:myid";
				
				Query<Employee2> query= session.createQuery(hqlQuery,Employee2.class);
				query.setParameter( "myid",e.getId());
				
				
				emp= query.uniqueResult();
				tx.commit();
				
			} catch (Exception e1) {
			
				if(tx!=null) {
					tx.rollback();
				}
				e1.printStackTrace();
			
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			
			return emp;
			}
		
		public List<Employee2> getAllEmployee() {
			
			Session session=null;
			Transaction tx=null;
			List<Employee2> list=null;
			
			try {
				
				session=factory.openSession();
				session.beginTransaction();
				
				String hqlQuery="from Employee2";
				
				Query<Employee2> query= session.createQuery(hqlQuery,Employee2.class);
				
				 list= query.list();
				
				tx.commit();
			} catch (Exception e1) {
				
				if(tx!=null) {
					tx.rollback();
				}
				e1.printStackTrace();
				
			}finally
			{
				if(session!=null) {
					session.close();
				}
			}
			return list;
			
			
	
}
		
		public List<Employee2> getStatus(Employee2 e) {
			Session session=null;
			Transaction tx=null;
			
			List<Employee2> list=null;
			
			try {
				session=factory.openSession();
				tx=session.beginTransaction();
				
				
				
				String hqlQuery="from Employee2 where status=:mystatus";
				
				Query<Employee2> query= session.createQuery(hqlQuery,Employee2.class);
				query.setParameter( "mystatus",e.getStatus());
				
				
				list= query.list();
				
				tx.commit();
				
			} catch (Exception e1) {
			
				if(tx!=null) {
					tx.rollback();
				}
				e1.printStackTrace();
			
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			
			return list;
			}

		public Employee2 checkUser(Employee2 e) {
			
			Session session=null;
			Transaction tx=null;
			Employee2 emp=null ;
			String hqlQuery="from Employee2 where name=:myname and department=:mydepartment";
			try {
				session=factory.openSession();
				tx=session.beginTransaction();
				
				
				Query<Employee2> query= session.createQuery(hqlQuery,Employee2.class);
				query.setParameter("myname",e.getName());
				query.setParameter("mydepartment", e.getDepartment());
				
				emp= query.uniqueResult();
				tx.commit();
				
			} catch (Exception e1) {
			
				if(tx!=null) {
					tx.rollback();
				}
				e1.printStackTrace();
			
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			
			return emp;
			}
		
		

		public List<Employee2> fromDate(Employee2 e) {
			Session session=null;
			Transaction tx=null;
			
			List<Employee2> list=null;
			
			try {
				session=factory.openSession();
				tx=session.beginTransaction();
				
				
				
				String hqlQuery="from Employee2 where createdt=:mycreatedt";
				
				Query<Employee2> query= session.createQuery(hqlQuery,Employee2.class);
				query.setParameter( "mycreatedt",e.getCreatedt());
				
				
				list= query.list();
				
				tx.commit();
				
			} catch (Exception e1) {
			
				if(tx!=null) {
					tx.rollback();
				}
				e1.printStackTrace();
			
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			
			return list;
			}
}

