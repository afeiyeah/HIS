package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.bean.Doctor;
import com.model.service.DoctorService;

@Controller
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	@RequestMapping("getDoctorByDept/{department_id}")
	@ResponseBody
	public List<Doctor> getDoctorByDept(@PathVariable int department_id){
		return doctorService.getDoctorByDept(department_id);
	}
}
