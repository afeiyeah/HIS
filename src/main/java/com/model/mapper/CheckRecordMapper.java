package com.model.mapper;

import com.model.bean.CheckRecord;

public interface CheckRecordMapper {
	public void saveCheckItemRecord(CheckRecord cr);
	public void updateCheckItems(int[] cid);
}
