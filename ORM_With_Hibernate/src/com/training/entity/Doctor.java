package com.training.entity;

import java.io.Serializable;
import java.util.Set;

public class Doctor implements Serializable{

	private int doctorCode;
	private String doctorName;
	private long handPhone;
	private Address residentialAddress;
	private Address clinicalAddress;
	
	private Set<Patient> patientList;
	
	private ClinicalAssistant assistant;
	
	public Set<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(Set<Patient> patientList) {
		this.patientList = patientList;
	}

	public ClinicalAssistant getAssistant() {
		return assistant;
	}

	public void setAssistant(ClinicalAssistant assistant) {
		this.assistant = assistant;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Doctor(int doctorCode, String doctorName, long handPhone) {
		super();
		this.doctorCode = doctorCode;
		this.doctorName = doctorName;
		this.handPhone = handPhone;
	}
	
	
	public Address getResidentialAddress() {
		return residentialAddress;
	}

	public void setResidentialAddress(Address residentialAddress) {
		this.residentialAddress = residentialAddress;
	}

	public Address getClinicalAddress() {
		return clinicalAddress;
	}

	public void setClinicalAddress(Address clinicalAddress) {
		this.clinicalAddress = clinicalAddress;
	}

	public int getDoctorCode() {
		return doctorCode;
	}
	public void setDoctorCode(int doctorCode) {
		this.doctorCode = doctorCode;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public long getHandPhone() {
		return handPhone;
	}
	public void setHandPhone(long handPhone) {
		this.handPhone = handPhone;
	}

	@Override
	public String toString() {
		return "Doctor [doctorCode=" + doctorCode + ", doctorName=" + doctorName + ", handPhone=" + handPhone + "]";
	}
	
	
	
}
