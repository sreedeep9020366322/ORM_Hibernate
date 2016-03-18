package com.training.impl;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.training.entity.*;
import com.training.iface.MyDAO;
import com.training.utils.HibernateUtils;

public class DoctorDAO implements MyDAO<Doctor>{

	SessionFactory factory;
	
	public DoctorDAO() {
		super();

		factory = HibernateUtils.getFactory();
	}

	@Override
	public Serializable add(Doctor t) {

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		
		Integer key = (Integer)session.save(t);

		tx.commit();
		session.close();
		return key;
	}

	@Override
	public Doctor find(Serializable obj) {

		SessionFactory factory = HibernateUtils.getFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Doctor doc2 = (Doctor) session.get(Doctor.class, obj);
		
		tx.commit();
		session.close();

		return doc2;
	}

	@Override
	public List<Doctor> findAll() {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		List<Doctor> docList = session.createQuery("from Doctor").list();
		tx.commit();
		session.close();
		
		return docList;
	}

	@Override
	public boolean update(Doctor obj) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		boolean result= true;
		try{
			session.update(obj);
		}catch(Exception e){
			result = false;
		}
		tx.commit();
		session.close();
		
		return result;
	}

	@Override
	public boolean delete(Serializable obj) {

		boolean result = true;
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Doctor doc = find(obj);
		
		try{
			session.delete(doc);
		}catch(Exception e) {
		
			result = false;
		}
		
		return result;
	}

	@PreDestroy
	public void destroy() {
		factory.close();
	}
	
}
