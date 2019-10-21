package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.bean.Check;
import com.model.mapper.CheckMapper;

@Service
public class CheckService {
	@Autowired
	private CheckMapper checkMapper;
	public List<Check> getAllCheckItem(){
		return checkMapper.getAllCheckItem();
	}
}
