package com.iti.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iti.entity.master.Dist_mast;
import com.iti.entity.master.Iti;
import com.iti.entity.master.ItiTradeMaster;
import com.iti.entity.master.OldDistMaster;
import com.iti.entity.master.States_mast;
import com.iti.entity.transactions.Admissions;
import com.iti.model.AdmissionModel;
import com.iti.model.AjaxResponseBody;
import com.iti.model.ApiError;
import com.iti.model.ClaimsModel;
import com.iti.repo.master.Dist_mastRepo;
import com.iti.repo.master.ItiRepo;
import com.iti.repo.master.ItiTradeMasterRepo;
import com.iti.repo.master.OldDistMasterRepo;
import com.iti.repo.master.States_mastRepo;
import com.iti.repo.transactions.AdmissionsRepo;
import com.iti.util.MyUtil;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/util")
public class UtilApisController {
	
	private static final Logger logger = LoggerFactory.getLogger(UtilApisController.class);
	
	@Autowired private MyUtil myUtil;
	@Autowired private AdmissionsRepo admissionsRepo;
	@Autowired private OldDistMasterRepo oldDistMasterRepo;
	@Autowired private States_mastRepo states_mastRepo;
	@Autowired private ItiTradeMasterRepo itiTradeMasterRepo;
	@Autowired private ItiRepo itiRepo;
	@Autowired private Dist_mastRepo dist_mastRepo;
	
	
	//Get all the candidate who like name as given name
	@PostMapping("getCandAdmInfoByLikeName")
	public ResponseEntity<?> getCandAdmInfoByLikeName(HttpServletRequest request,@RequestParam("name") String name){
		logger.info("getCandAdmInfoByLikeName");
		logger.info("name=>"+name);
		
		if(name.isEmpty()) {
			return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST, "Given Name should not be empty"), HttpStatus.BAD_REQUEST); 
		}
		
		final String authorizationHeader = request.getHeader("Authorization").substring(7);
		System.out.println("authorizationHeader=>" + authorizationHeader);
		
		if(authorizationHeader == null) {
			return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST, "Authorization header is required to get data."), HttpStatus.BAD_REQUEST);
		}
		
		String isValid = myUtil.validateToken(authorizationHeader);
		if(isValid.equalsIgnoreCase("true")) {
			List<Admissions> adm_nums = admissionsRepo.getByNameslikes(name);
			System.out.println("adm_nums=>"+adm_nums.size());
			return new ResponseEntity<>(adm_nums, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST, "Given Token is Invalid."), HttpStatus.BAD_REQUEST);
		}
		 
	}
	//findadmission details of the candidate based on admission number
	@PostMapping("getByAdmNum")
	public ResponseEntity<?> getByAdmNum(HttpServletRequest request,@RequestParam("admNum") String admNum){
		System.out.println("/api/plcmt/reports/getByAdmNum"+admNum);
		
		if(admNum.isEmpty()) {
			return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST, "Given Admission should not be empty"), HttpStatus.BAD_REQUEST); 
		}
		
		final String authorizationHeader = request.getHeader("Authorization").substring(7);
		System.out.println("authorizationHeader=>" + authorizationHeader);
		
		if(authorizationHeader == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token is required to access Data.");
		}
		String isValid = myUtil.validateToken(authorizationHeader);
		if(isValid.equalsIgnoreCase("true")) {

			Admissions admNumData = admissionsRepo.getByAdmNum(admNum);
			System.out.println("admNumData=>"+admNumData.toString());
			
			AdmissionModel admissionModel = new AdmissionModel();
			
			List<OldDistMaster> oldDistMaster = oldDistMasterRepo.findAll();
			System.out.println("oldDistMaster=>size=>"+oldDistMaster.size());
			List<Dist_mast> distsStateWise = dist_mastRepo.findAll();
			System.out.println("distsStateWise=>size=>"+distsStateWise.size());
			List<States_mast> states = states_mastRepo.findAll();
			System.out.println("states=>size=>"+states.size());
			List<ItiTradeMaster> trades = itiTradeMasterRepo.findAll();
			System.out.println("trades=>size=>"+trades.size());
			List<Iti> itis = itiRepo.findAll();
			System.out.println("itis=>size=>"+itis.size());
			
			System.out.println("getIti_code=>"+admNumData.getIti_code());
			
			admissionModel.setAdm_num(admNumData.getAdmNum());
			admissionModel.setName(admNumData.getName());
			
			admissionModel.setIti_code(admNumData.getIti_code());
			Optional<Iti> itiNames = itis.stream().filter(a -> a.getItiCode().equals(admNumData.getIti_code())).findFirst();
			if(itiNames.isPresent()) { admissionModel.setIti_name(itiNames.get().getItiName()); }
			System.out.println("itiNames"+itiNames.get().getItiName());
			
			admissionModel.setDist_code(admNumData.getDist_code());
			Optional<OldDistMaster> oldDists = oldDistMaster.stream().filter(a -> a.getDist_code().equals(admNumData.getDist_code())).findFirst();
			if(oldDists.isPresent()) { admissionModel.setDist_name(oldDists.get().getDist_name()); }
			System.out.println("oldDists"+oldDists.get().getDist_name());
			
			admissionModel.setYear_of_admission(admNumData.getYear_of_admission());
			admissionModel.setTrade_code(String.valueOf(admNumData.getTrade_code()));
			Optional<ItiTradeMaster> trade = trades.stream().filter(t -> t.getTradeCode().equals(admNumData.getTrade_code())).findFirst();
			if(trade.isPresent()) { admissionModel.setTrade_name(trade.get().getTradeName()); }
			System.out.println("trade"+trade.get().getTradeName());
			
			AjaxResponseBody arb = new AjaxResponseBody();
			arb.setResult(admissionModel);
			arb.setDists(distsStateWise);
			arb.setStates(states);
			arb.setTrades(trades);
			
			System.out.println("adm_nums=>"+admNumData.toString());
			return new ResponseEntity<>(arb, HttpStatus.OK);
		
		}else {
			return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST, "Given Token is Invalid."), HttpStatus.BAD_REQUEST);
		}
 
	}
	
	//Get all the claims from given token
	@PostMapping("/getAllClaims")
	public ResponseEntity<?> getAllClaims(HttpServletRequest request){
		logger.info("getAllClaims");
		
		final String authorizationHeader = request.getHeader("Authorization").substring(7);
		System.out.println("authorizationHeader=>" + authorizationHeader);
		
		if(authorizationHeader == null) {
			return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST, "Authorization header is required to get data."), HttpStatus.BAD_REQUEST);
		}
		
		String isValid = myUtil.validateToken(authorizationHeader);
		if(isValid.equalsIgnoreCase("true")) {
			ClaimsModel claimsModel = myUtil.getClaimsFromToken(request);
			return new ResponseEntity<>(claimsModel, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST, "Given Token is Invalid."), HttpStatus.BAD_REQUEST);
		}
	}

}
