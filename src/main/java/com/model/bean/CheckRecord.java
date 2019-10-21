package com.model.bean;

public class CheckRecord {
	private int record_id;
	private int patient_id;
	private int checkup_id;
	private int checkup_amount;
	private Check check;
	public Check getCheck() {
		return check;
	}
	public void setCheck(Check check) {
		this.check = check;
	}
	public int getRecord_id() {
		return record_id;
	}
	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public int getCheckup_id() {
		return checkup_id;
	}
	public void setCheckup_id(int checkup_id) {
		this.checkup_id = checkup_id;
	}
	public int getCheckup_amount() {
		return checkup_amount;
	}
	public void setCheckup_amount(int checkup_amount) {
		this.checkup_amount = checkup_amount;
	}
	public int getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(int payment_status) {
		this.payment_status = payment_status;
	}
	private int payment_status;
	
}
