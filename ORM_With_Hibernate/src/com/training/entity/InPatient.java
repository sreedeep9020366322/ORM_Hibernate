package com.training.entity;

import java.sql.Timestamp;

public class InPatient extends Patient {

	private int wardNumber;
	private Timestamp dateOfAdmission;

	public int getWardNumber() {
		return wardNumber;
	}
	public void setWardNumber(int wardNumber) {
		this.wardNumber = wardNumber;
	}
	public Timestamp getDateOfAdmission() {
		return dateOfAdmission;
	}
	public void setDateOfAdmission(Timestamp dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}
	
	public InPatient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InPatient(int wardNumber, Timestamp dateOfAdmission) {
		super();
		this.wardNumber = wardNumber;
		this.dateOfAdmission = dateOfAdmission;
	}
	public InPatient(int patientId, String patientName, int age) {
		super(patientId, patientName, age);
		// TODO Auto-generated constructor stub
	}
	
	public InPatient(int patientId,String patientName,int age,int wardNumber,Timestamp dateOfAdmission) {
		
		super(patientId, patientName, age);
		this.wardNumber = wardNumber;
		this.dateOfAdmission = dateOfAdmission;
	}
	
	@Override
	public String fee() {
		
		return "Inpatient";
	}
	@Override
	public String toString() {
		return "InPatient [wardNumber=" + wardNumber + ", dateOfAdmission=" + dateOfAdmission + "]";
	}
	
	
}
