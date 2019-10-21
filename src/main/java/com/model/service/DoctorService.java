package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.bean.Doctor;
import com.model.mapper.DoctorMapper;


@Service
public class DoctorService {
	@Autowired
	private DoctorMapper doctorMapper;
	public List<Doctor> getDoctorByDept(int department_id){
		return doctorMapper.getDoctorByDept(department_id);
	}
}
