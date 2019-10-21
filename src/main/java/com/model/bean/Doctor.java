package com.model.bean;

public class Doctor {
	private int doctor_id;
	private String doctor_name;
	private int register_level_id;
	private int department_id;
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public int getRegister_level_id() {
		return register_level_id;
	}
	public void setRegister_level_id(int register_level_id) {
		this.register_level_id = register_level_id;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	
}
