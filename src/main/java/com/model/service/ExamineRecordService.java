package com.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.bean.ExamineRecord;
import com.model.bean.ExamineRecordList;
import com.model.mapper.ExamineRecordMapper;

@Service
public class ExamineRecordService {
	@Autowired
	private ExamineRecordMapper examineRecordMapper;
	public void saveExamineItemRecord(int pid, ExamineRecordList elist){
		for(ExamineRecord er:elist.getElist()){
			er.setPatient_id(pid);
			er.setPayment_status(0);
			examineRecordMapper.saveExamineItemRecord(er);
		}
	}
}
