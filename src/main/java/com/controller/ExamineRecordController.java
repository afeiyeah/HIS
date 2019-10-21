package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.bean.ExamineRecordList;
import com.model.bean.User;
import com.model.service.ExamineRecordService;

@Controller
public class ExamineRecordController {
	@Autowired
	private ExamineRecordService examineRecordService;
	@RequestMapping("saveExamineItemRecord/{pid}/{doctor_id}")
	@ResponseBody
	public String saveExamineItemRecord(@PathVariable int pid,@PathVariable String doctor_id,ExamineRecordList elist,HttpSession session){
		if(doctor_id.equals(((User)session.getAttribute("loginUser")).getUname())){
			examineRecordService.saveExamineItemRecord(pid, elist);
			return "{\"result\":\"保存成功\"}";
		}else{
			return "{\"result\":\"该患者不是你的患者\"}";
		}
		
	}
}
