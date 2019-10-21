package com.model.bean;

public class ExamineRecord {
	private int record_id;
	private int patient_id;
	private int examine_id;
	private int examine_amount;
	private int payment_status;
	private Examine examine;
	public Examine getExamine() {
		return examine;
	}
	public void setExamine(Examine examine) {
		this.examine = examine;
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
	public int getExamine_id() {
		return examine_id;
	}
	public void setExamine_id(int examine_id) {
		this.examine_id = examine_id;
	}
	public int getExamine_amount() {
		return examine_amount;
	}
	public void setExamine_amount(int examine_amount) {
		this.examine_amount = examine_amount;
	}
	public int getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(int payment_status) {
		this.payment_status = payment_status;
	}
	
}
