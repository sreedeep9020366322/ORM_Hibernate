package com.training.apps;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.training.entity.ClinicalAssistant;
import com.training.entity.Doctor;
import com.training.entity.InPatient;
import com.training.entity.Patient;
import com.training.utils.HibernateUtils;

public class one2ManyApplication {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = HibernateUtils.getFactory();
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Doctor doc = new Doctor(7212, "LatestDoc", 8997);
		ClinicalAssistant assistant = new ClinicalAssistant(02002, "Assistant1");
		
		Timestamp date = new Timestamp(new Date().getTime());
		
		Set<Patient> patientList = new HashSet<Patient>();
		InPatient patient1 = new InPatient(050,"inpatient1",21,600,date);
		InPatient patient2 = new InPatient(051,"inpatient2",22,601,date);
		InPatient patient3 = new InPatient(052,"inpatient3",23,602,date);
		
		patientList.add(patient1);
		patientList.add(patient2);
		patientList.add(patient3);
		
		doc.setAssistant(assistant);
		doc.setPatientList(patientList);
		
		session.save(doc);
		tx.commit();
		session.close();
		
	}
}
