package com.model.mapper;

import com.model.bean.ExamineRecord;

public interface ExamineRecordMapper {
	public void saveExamineItemRecord(ExamineRecord er);
	public void updateExamineItems(int[]eid);
}
