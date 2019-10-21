package com.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.bean.CheckRecord;
import com.model.bean.CheckRecordList;
import com.model.mapper.CheckRecordMapper;

@Service
public class CheckRecordService {
	@Autowired
	private CheckRecordMapper checkRecordMapper;
	public void saveCheckItemRecord(int patient_id, CheckRecordList crlist){
		for(CheckRecord cr:crlist.getCrlist()){
			cr.setPatient_id(patient_id);
			cr.setPayment_status(0);
			checkRecordMapper.saveCheckItemRecord(cr);
		}
		
	}
}
