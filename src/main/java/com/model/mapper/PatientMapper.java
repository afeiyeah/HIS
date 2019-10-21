package com.model.mapper;

import java.util.List;
import java.util.Map;


import com.model.bean.Patient;

public interface PatientMapper {
	public Patient getPatientNo();
	public List<Patient> getPatientData(Map<String,Object> map);
	public void savePatient(Patient p);
	public Patient getPatientByNo(int pid);
	public void updatePatientStatus(Map<String,Object> map);
	public List<Patient> getPatientDataByDoc(Map<String,Object> map);
	public Patient selectPatientByPno(int pid);
	public Patient getPatientMRByNo(int pid);
}
