package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.bean.CheckRecordList;
import com.model.bean.User;
import com.model.service.CheckRecordService;

@Controller
public class CheckRecordController {
	@Autowired
	private CheckRecordService checkRecordService;
	@RequestMapping("saveCheckItemRecord/{pid}/{doctor_id}")
	@ResponseBody
	public String saveCheckItemRecord(@PathVariable int pid, @PathVariable String doctor_id,CheckRecordList crlist,HttpSession session){
		if(doctor_id.equals(((User)session.getAttribute("loginUser")).getUname())){
			checkRecordService.saveCheckItemRecord(pid, crlist);
			return "{\"result\":\"保存成功\"}";
		}else{
			return "{\"result\":\"该患者不是你的患者\"}";
		}
		
	}
}
