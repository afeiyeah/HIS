package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.bean.Department;
import com.model.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	@RequestMapping("getDepartmentData")
	@ResponseBody
	public List<Department> getDepartmentData(){
		return departmentService.getDepartmentData();
	}
}
