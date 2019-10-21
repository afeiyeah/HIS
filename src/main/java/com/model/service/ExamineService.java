package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.bean.Examine;
import com.model.mapper.ExamineMapper;

@Service
public class ExamineService {
	@Autowired
	private ExamineMapper examineMapper;
	public List<Examine> getAllExamineItem(){
		return examineMapper.getAllExamineItem();
	}
}
