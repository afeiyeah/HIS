package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.bean.Examine;
import com.model.service.ExamineService;

@Controller
public class ExamineController {
	@Autowired
	private ExamineService examineService;
	@RequestMapping("getAllExamineItem")
	@ResponseBody
	public List<Examine> getAllExamineItem(){
		return examineService.getAllExamineItem();
	}
}
