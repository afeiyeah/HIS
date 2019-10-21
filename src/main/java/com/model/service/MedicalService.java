package com.model.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.bean.Medical;
import com.model.bean.User;
import com.model.mapper.MedicalMapper;
import com.model.mapper.PatientMapper;

@Service
public class MedicalService {
	@Autowired
	private MedicalMapper medicalMapper;
	@Autowired
	private PatientMapper patientMapper;
	public void saveMedicalRecord(Medical m, HttpSession session){
		m.setMedical_status(1);
		m.setMedical_operator(((User)session.getAttribute("loginUser")).getUid());
		m.setOperate_date(new java.sql.Date(new Date().getTime()));
		//保存病历
		medicalMapper.saveMedicalRecord(m);
		//更新患者状态
		Map<String,Object> map=new HashMap<>();
		map.put("k_patient_ID", m.getPatient_ID());
		map.put("k_visited_type", 2);
		map.put("k_patient_operator", ((User)session.getAttribute("loginUser")).getUid());
		map.put("k_operate_date", new java.sql.Date(new Date().getTime()));
		patientMapper.updatePatientStatus(map);
	}
	public void updateMedicalRecord(Medical medical, HttpSession session){
		medical.setMedical_operator(((User)session.getAttribute("loginUser")).getUid());
		medical.setOperate_date(new java.sql.Date(new Date().getTime()));
		//更新病历
		medicalMapper.updateMedicalRecord(medical);
	}
}
