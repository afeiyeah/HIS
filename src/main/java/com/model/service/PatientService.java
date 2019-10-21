package com.model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.bean.Patient;
import com.model.bean.User;
import com.model.mapper.CheckRecordMapper;
import com.model.mapper.ExamineRecordMapper;
import com.model.mapper.PatientMapper;

@Service
public class PatientService {
	@Autowired
	private PatientMapper patientMapper;
	@Autowired
	private CheckRecordMapper checkRecordMapper;
	@Autowired
	private ExamineRecordMapper examineRecordMapper;
	public int getPatientNo(){
		Patient p=patientMapper.getPatientNo();
		return p.getPatient_ID();
	}
	public List<Patient> getPatientData(int pageSize,int pageNum){
		Map<String,Object> map=new HashMap<>();
		map.put("k_pageSize", pageSize);
		map.put("k_index", (pageNum-1)*pageSize);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, - 7);
		Date d = c.getTime();
		String day = format.format(d);
		Date selectDate=null;
		try {
			selectDate = format.parse(day);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sDate = new java.sql.Date(selectDate.getTime());
		map.put("k_date", sDate);
		return patientMapper.getPatientData(map);
	}
	
	public void savePatient(Patient p,HttpSession session){
		//setData
		p.setPatient_birth(p.getYear()+"-"+p.getMonth());
		p.setVisited_type(1);
		p.setPatient_status(1);
		p.setPatient_operator(((User)session.getAttribute("loginUser")).getUid());
		p.setOperate_date(new java.sql.Date(new Date().getTime()));
		patientMapper.savePatient(p);
	}
	
	public Patient getPatientByNo(int pid){
		return patientMapper.getPatientByNo(pid);
	}
	public void updatePatientStatus(int pid, int pstatus,HttpSession session){
		Map<String,Object> map=new HashMap<>();
		map.put("k_patient_ID", pid);
		map.put("k_visited_type", pstatus);
		map.put("k_patient_operator", ((User)session.getAttribute("loginUser")).getUid());
		map.put("k_operate_date", new java.sql.Date(new Date().getTime()));
		patientMapper.updatePatientStatus(map);
	}
	public List<Patient> getPatientDataByDoc(String dname){
		Map<String,Object> map=new HashMap<>();
		map.put("k_doctor_name", dname);
		map.put("k_operate_date", new java.sql.Date(new Date().getTime()));
		return patientMapper.getPatientDataByDoc(map);
	}
	public Patient selectPatientByPno(int pid){
		return patientMapper.selectPatientByPno(pid);
	}
	public void updateItems(int[] cid,int[]eid){
		checkRecordMapper.updateCheckItems(cid);
		examineRecordMapper.updateExamineItems(eid);
	}
	public Patient getPatientMRByNo(int pid){
		return patientMapper.getPatientMRByNo(pid);
	}
}
