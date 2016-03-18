package com.training.apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.training.entity.ClinicalAssistant;
import com.training.entity.Doctor;
import com.training.utils.HibernateUtils;

public class oneToOneApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = HibernateUtils.getFactory();
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Doctor doc = new Doctor(1210, "LatestDoc", 8997);
		ClinicalAssistant assistant = new ClinicalAssistant(00001, "Assistant1");
		
		doc.setAssistant(assistant);

		session.save(doc);
		tx.commit();
		session.close();
		
	}

}
