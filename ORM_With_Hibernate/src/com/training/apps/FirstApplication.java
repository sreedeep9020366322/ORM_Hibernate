package com.training.apps;

import java.util.List;

import org.hibernate.*;

import com.training.entity.Address;
import com.training.entity.Doctor;
import com.training.impl.DoctorDAO;
import com.training.utils.HibernateUtils;

public class FirstApplication {

	public static void main(String[] args) {
		
		/*SessionFactory factory = HibernateUtils.getFactory();
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Doctor doc = new Doctor(888,"Rupesh",987634);

		Address cliniAddress = new Address("sector 21", "pocket E", "Gurgaon", 122002);
		Address resiAddress = new Address("Sector 23", "Pocket W", "City 1", 5445);
		
		doc.setClinicalAddress(cliniAddress);
		doc.setResidentialAddress(resiAddress);
		
		Integer key = (Integer)session.save(doc);
		
		//session.save(doc);
		
		System.out.println(key);
		
		Doctor doc2 = (Doctor) session.get(Doctor.class, 20);
		
		System.out.println(doc.getClinicalAddress());
		
		tx.commit();
		
		factory.close();*/

	
		DoctorDAO doc = new DoctorDAO();
		
		Doctor doc1 = doc.find(1);
		
		System.out.println("Doctor found :" + doc1);
		
		List<Doctor> docList = doc.findAll();
		
		System.out.println(docList.get(0));
		
		
		//doc1.setDoctorName("New Name");
		System.out.println("Delete success: "+doc.delete(81));
		//System.out.println("Update success: "+ doc.update(doc1));
		
		//System.out.println("Adding: " + doc.add(new Doctor(305, "Umesh", 9999)));
		
		
	}
}
