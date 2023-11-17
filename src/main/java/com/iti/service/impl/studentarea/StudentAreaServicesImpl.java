package com.iti.service.impl.studentarea;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iti.entity.studentarea.StudentApplication;
import com.iti.model.studentarea.StudentRegModel;
import com.iti.repo.studentarea.StudentApplicationRepo;
import com.iti.service.studentarea.StudentAreaServices;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Service
public class StudentAreaServicesImpl implements StudentAreaServices{
	
	private static final Logger logger = LoggerFactory.getLogger(StudentAreaServicesImpl.class);
	
	@Autowired private StudentApplicationRepo studentApplicationRepo;
	@PersistenceContext private EntityManager entityManager;

	@Override
	@Transactional
	public String saveStudentDetails(StudentRegModel studentRegModel) {
		// TODO Auto-generated method stub
		logger.info("Method: saveStudentDetails"+studentRegModel);
		
		Optional<StudentApplication> findStd = studentApplicationRepo.findById(studentRegModel.getSsc_regno());
		
		if(findStd.isPresent()) {
			return "Student is already registered with registration id: "+findStd.get().getRegid();
		}else {
			StudentApplication studentApplication = new StudentApplication();
			studentApplication.setSscRegno(studentRegModel.getSsc_regno());
			
			Long regid = getNextValueFromSequence("application_registration_id_seq");
			studentApplication.setRegid(String.valueOf(regid));
			
			StudentApplication savedBean = studentApplicationRepo.save(studentApplication);
			
			return "Student is registered Successfuly with regid: "+savedBean.getRegid();
		}
	}
	
	 private Long getNextValueFromSequence(String sequenceName) {
	        String sql = "SELECT NEXTVAL('" + sequenceName + "')";

	        // Execute native query
	        return (Long) entityManager.createNativeQuery(sql).getSingleResult();
	    }

	 

}
