package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.bean.Patient;
import com.model.bean.User;
import com.model.service.PatientService;

@Controller
public class PatientController {
	@Autowired
	private PatientService patientService;
	@RequestMapping("getPatientNo")
	@ResponseBody
	public String getPatientNo(){
		int pno=patientService.getPatientNo();
		return "{\"pno\":\""+pno+"\"}";
	}
	
	@RequestMapping("getPatientData/{pageSize}/{pageNum}")
	@ResponseBody
	public List<Patient> getPatientData(@PathVariable int pageSize,@PathVariable int pageNum){
		return patientService.getPatientData(pageSize, pageNum);
	}
	@RequestMapping("savePatient")
	@ResponseBody
	public String savePatient(Patient p,HttpSession session){
		System.out.println(p.getPatient_ID());
		patientService.savePatient(p, session);
		return "{\"result\":\"挂号成功\"}";
	}
	@RequestMapping("getPatientByNo/{pid}")
	@ResponseBody
	public Patient getPatientByNo(@PathVariable int pid){
		Patient p=patientService.getPatientByNo(pid);
		if(p==null){
			return new Patient();
		}else{
			return p;
		}
		
	}
	@RequestMapping("refundPatient/{pid}")
	@ResponseBody
	public String refundPatient(@PathVariable int pid,HttpSession session){
		patientService.updatePatientStatus(pid, 3, session);
		return "{\"result\":\"退号成功\"}";
	}
	@RequestMapping("getPatientDataByDoc")
	@ResponseBody
	public List<Patient> getPatientDataByDoc(HttpSession session){
		String dname=((User)session.getAttribute("loginUser")).getUname();
		return patientService.getPatientDataByDoc(dname);
	}
	
	@RequestMapping("selectPatientByPno/{pid}")
	@ResponseBody
	public Patient selectPatientByPno(@PathVariable int pid){
		Patient p=patientService.selectPatientByPno(pid);
		if(p==null){
			return new Patient();
		}else{
			return p;
		}
		
	}
	@RequestMapping("payItems")
	@ResponseBody
	public String payItems(int[] cid,int[]eid){
		patientService.updateItems(cid, eid);
		return "{\"result\":\"缴费成功\"}";
	}
	@RequestMapping("getPatientMRByNo/{pid}")
	@ResponseBody
	public Patient getPatientMRByNo(@PathVariable int pid){
		Patient p=patientService.getPatientMRByNo(pid);
		if(p==null){
			return new Patient();
		}else{
			return p;
		}
		
	}
	
}
