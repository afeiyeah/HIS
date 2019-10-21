package com.model.mapper;

import java.util.List;

import com.model.bean.Doctor;

public interface DoctorMapper {
	public List<Doctor> getDoctorByDept(int department_id);
}
