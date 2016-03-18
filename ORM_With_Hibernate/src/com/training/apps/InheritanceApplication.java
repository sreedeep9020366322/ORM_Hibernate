package com.training.apps;


import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.training.entity.InPatient;
import com.training.entity.Patient;
import com.training.utils.HibernateUtils;

public class InheritanceApplication {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtils.getFactory();
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		Timestamp date= new Timestamp(new Date().getTime());
		
	//	InPatient patient = new InPatient(948, "inheritedPatient", 23,606,date);
		
	//	session.save(patient);
		tx.commit();
		System.out.println("patient added");

		Patient patient2 = (Patient) session.get(Patient.class, 77);
		System.out.println(patient2);
		session.close();
		System.out.println("who is it: "+ patient2.fee());
	}
}
