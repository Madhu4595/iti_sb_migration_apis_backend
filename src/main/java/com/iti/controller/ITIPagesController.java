package com.iti.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/iti")
public class ITIPagesController {
	
	private final static Logger logger = LoggerFactory.getLogger(ITIPagesController.class);
	
	@PostMapping("/savePlcmt")
	public String plcmtEntry(HttpServletRequest httpServletRequest) {
		logger.info(httpServletRequest.getServletContext().getContextPath());
		return null;
	}

}
