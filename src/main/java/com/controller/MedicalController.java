package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.bean.Medical;
import com.model.service.MedicalService;

@Controller
public class MedicalController {
	@Autowired
	private MedicalService medicalService;
	@RequestMapping("regMedicalRecord/{pid}")
	@ResponseBody
	public String regMedicalRecord(@PathVariable int pid,Medical m,HttpSession session){
		m.setPatient_ID(pid);
		medicalService.saveMedicalRecord(m, session);
		return "{\"result\":\"保存成功\"}";
	}
	
	@RequestMapping("updateMedicalRecord")
	@ResponseBody
	public String updateMedicalRecord(Medical m,HttpSession session){
		medicalService.updateMedicalRecord(m, session);
		return "{\"result\":\"保存成功\"}";
	}
}
