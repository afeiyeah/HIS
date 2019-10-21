package com.model.bean;

import java.sql.Date;
import java.util.List;

public class Patient {
	private int patient_ID;
	private String patient_name;
	private String patient_gender;
	private int patient_age;
	private String patient_birth;
	private String patient_identity;
	private String patient_address;
	private int register_level_id;
	private int department_id;
	private int doctor_id;
	private int casebook;
	private int register_cost;
	private Date register_date;
	private int visited_type;
	private int patient_status;
	private int patient_operator;
	private Date operate_date;
	
	private Level level;
	private Doctor doctor;
	private Department department;
	
	private String year;
	private String month;
	
	private List<CheckRecord> crlist;
	private List<ExamineRecord> erlist;
	
	private Medical m;
	public Medical getM() {
		return m;
	}
	public void setM(Medical m) {
		this.m = m;
	}
	public List<CheckRecord> getCrlist() {
		return crlist;
	}
	public void setCrlist(List<CheckRecord> crlist) {
		this.crlist = crlist;
	}
	public List<ExamineRecord> getErlist() {
		return erlist;
	}
	public void setErlist(List<ExamineRecord> erlist) {
		this.erlist = erlist;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public int getPatient_ID() {
		return patient_ID;
	}
	public void setPatient_ID(int patient_ID) {
		this.patient_ID = patient_ID;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public String getPatient_gender() {
		return patient_gender;
	}
	public void setPatient_gender(String patient_gender) {
		this.patient_gender = patient_gender;
	}
	public int getPatient_age() {
		return patient_age;
	}
	public void setPatient_age(int patient_age) {
		this.patient_age = patient_age;
	}
	public String getPatient_birth() {
		return patient_birth;
	}
	public void setPatient_birth(String patient_birth) {
		this.patient_birth = patient_birth;
	}
	public String getPatient_identity() {
		return patient_identity;
	}
	public void setPatient_identity(String patient_identity) {
		this.patient_identity = patient_identity;
	}
	public String getPatient_address() {
		return patient_address;
	}
	public void setPatient_address(String patient_address) {
		this.patient_address = patient_address;
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
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public int getCasebook() {
		return casebook;
	}
	public void setCasebook(int casebook) {
		this.casebook = casebook;
	}
	public int getRegister_cost() {
		return register_cost;
	}
	public void setRegister_cost(int register_cost) {
		this.register_cost = register_cost;
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	public int getVisited_type() {
		return visited_type;
	}
	public void setVisited_type(int visited_type) {
		this.visited_type = visited_type;
	}
	public int getPatient_status() {
		return patient_status;
	}
	public void setPatient_status(int patient_status) {
		this.patient_status = patient_status;
	}
	public int getPatient_operator() {
		return patient_operator;
	}
	public void setPatient_operator(int patient_operator) {
		this.patient_operator = patient_operator;
	}
	public Date getOperate_date() {
		return operate_date;
	}
	public void setOperate_date(Date operate_date) {
		this.operate_date = operate_date;
	}
	
}
