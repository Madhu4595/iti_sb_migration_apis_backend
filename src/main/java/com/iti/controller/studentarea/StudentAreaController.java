package com.iti.controller.studentarea;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iti.model.studentarea.StudentRegModel;
import com.iti.repo.studentarea.StudentApplicationRepo;
import com.iti.service.studentarea.StudentApplicationService;
import com.iti.service.studentarea.StudentAreaServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/std")
@Validated
public class StudentAreaController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentAreaController.class);
	
	@Autowired private StudentApplicationService service;
	@Autowired private StudentApplicationRepo repo;
	@Autowired private StudentAreaServices studentAreaServices;
	
	@PostMapping("/stdRegExists")
	public ResponseEntity<?> stdRegExists(@RequestParam("sscRegno") String sscRegno){
			return new ResponseEntity<Boolean>(service.stdRegExists(sscRegno), HttpStatus.OK);
	}
	
	//saving new student
	@PostMapping("saveStudent")
	public ResponseEntity<?> saveStudent(@Valid @RequestBody StudentRegModel studentApplication){
		logger.info("/saveStudent");
		logger.info("@RequestBody=>"+studentApplication.toString());
		String result = studentAreaServices.saveStudentDetails(studentApplication);
		
		
		//repo.save(studentApplication);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	@GetMapping("/getByteArray")
	public ResponseEntity<?> getByteArray() throws IOException{
		
		byte[] bytes =Files.readAllBytes(Paths.get("C:\\Users\\Administrator\\Pictures\\admissionsreport.PNG"));
		int[] unsigned = new int[bytes.length];
		for (int i = 0; i < bytes.length; i++) {
			unsigned[i] = bytes[i] & 0xFF;
		}
		String bytearray = Arrays.toString(unsigned);
		
		return new ResponseEntity<String>(bytearray, HttpStatus.OK);
	}
	

}
