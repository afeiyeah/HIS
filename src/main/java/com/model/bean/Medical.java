package com.model.bean;

import java.sql.Date;

public class Medical {
	private int medical_record;
	private int patient_ID;
	private String complaint;
	private String present_illness;
	private String past_illness;
	private String primary_diagnosis;
	private String checkup_result;
	private String final_diagnosis;
	private int medical_status;
	private int medical_operator;
	private Date operate_date;
	public int getMedical_record() {
		return medical_record;
	}
	public void setMedical_record(int medical_record) {
		this.medical_record = medical_record;
	}
	public int getPatient_ID() {
		return patient_ID;
	}
	public void setPatient_ID(int patient_ID) {
		this.patient_ID = patient_ID;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	public String getPresent_illness() {
		return present_illness;
	}
	public void setPresent_illness(String present_illness) {
		this.present_illness = present_illness;
	}
	public String getPast_illness() {
		return past_illness;
	}
	public void setPast_illness(String past_illness) {
		this.past_illness = past_illness;
	}
	public String getPrimary_diagnosis() {
		return primary_diagnosis;
	}
	public void setPrimary_diagnosis(String primary_diagnosis) {
		this.primary_diagnosis = primary_diagnosis;
	}
	public String getCheckup_result() {
		return checkup_result;
	}
	public void setCheckup_result(String checkup_result) {
		this.checkup_result = checkup_result;
	}
	public String getFinal_diagnosis() {
		return final_diagnosis;
	}
	public void setFinal_diagnosis(String final_diagnosis) {
		this.final_diagnosis = final_diagnosis;
	}
	public int getMedical_status() {
		return medical_status;
	}
	public void setMedical_status(int medical_status) {
		this.medical_status = medical_status;
	}
	public int getMedical_operator() {
		return medical_operator;
	}
	public void setMedical_operator(int medical_operator) {
		this.medical_operator = medical_operator;
	}
	public Date getOperate_date() {
		return operate_date;
	}
	public void setOperate_date(Date operate_date) {
		this.operate_date = operate_date;
	}
	
}
