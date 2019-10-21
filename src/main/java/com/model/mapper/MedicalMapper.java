package com.model.mapper;

import com.model.bean.Medical;

public interface MedicalMapper {
	public void saveMedicalRecord(Medical m);
	public void updateMedicalRecord(Medical medical);
}
