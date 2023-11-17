package com.iti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iti.repo.studentarea.StudentApplicationRepo;
import com.iti.service.studentarea.StudentApplicationService;
@Service
public class StudentApplicationServiceImpl implements StudentApplicationService{
	
	@Autowired private StudentApplicationRepo repo;

	@Override
	public boolean stdRegExists(String sscRegno) {
		// TODO Auto-generated method stub
		return repo.existsById(sscRegno);
	}

}
