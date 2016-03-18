package com.training.apps;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.training.entity.Address;
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
		Doctor doc = new Doctor(3, "LatestDoc", 8997);
		ClinicalAssistant assistant = new ClinicalAssistant(22, "Assistant1");
		
		Timestamp date = new Timestamp(new Date().getTime());
		
		Set<Patient> patientList = new HashSet<Patient>();
		InPatient patient1 = new InPatient(1,"inpatient",21,600,date);
		InPatient patient2 = new InPatient(2,"inpatient",22,601,date);
		InPatient patient3 = new InPatient(3,"inpatient",23,602,date);
		
		patientList.add(patient1);
		patientList.add(patient2);
		patientList.add(patient3);
		
		doc.setAssistant(assistant);
		doc.setPatientList(patientList);
		
		Address cliniAddress = new Address("sector 21", "pocket E", "Gurgaon", 122002);
		Address resiAddress = new Address("Sector 23", "Pocket W", "City 1", 5445);
		
		doc.setClinicalAddress(cliniAddress);
		doc.setResidentialAddress(resiAddress);
		
		
		session.save(doc);
		tx.commit();
		session.close();
		
		factory.close();
		
	}
}
