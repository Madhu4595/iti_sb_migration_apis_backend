package com.iti.controller.masterdata;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iti.entity.master.CasteMaster;
import com.iti.entity.master.Dist_mast;
import com.iti.entity.master.Iti;
import com.iti.entity.master.ItiTrade;
import com.iti.entity.master.ItiTradeMaster;
import com.iti.entity.master.OldDistMaster;
import com.iti.entity.master.SSCExamBoardMaster;
import com.iti.entity.master.States_mast;
import com.iti.model.AjaxResponseBody;
import com.iti.model.ClaimsModel;
import com.iti.projections.UniversalProjection;
import com.iti.repo.master.CasteMasterRepo;
import com.iti.repo.master.Dist_mastRepo;
import com.iti.repo.master.ItiRepo;
import com.iti.repo.master.ItiTradeMasterRepo;
import com.iti.repo.master.ItiTradeRepo;
import com.iti.repo.master.OldDistMasterRepo;
import com.iti.repo.master.SSCExamBoardMasterRepo;
import com.iti.repo.master.States_mastRepo;
import com.iti.util.MyUtil;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/masterdata")
@CrossOrigin(origins = "*")
public class MasterDataController {
	
	private static final Logger logger = LoggerFactory.getLogger(MasterDataController.class);
	
	@Autowired private ItiRepo itiRepo;
	@Autowired private Dist_mastRepo dist_mastRepo;
	@Autowired private States_mastRepo states_mastRepo;
	@Autowired private ItiTradeMasterRepo itiTradeMasterRepo;  
	@Autowired private MyUtil myUtil;
	@Autowired private OldDistMasterRepo oldDistMasterRepo;
	@Autowired private ItiTradeRepo itiTradeRepo;
	@Autowired private SSCExamBoardMasterRepo sSCExamBoardMasterRepo;
	@Autowired private CasteMasterRepo casteMasterRepo;
	
	@GetMapping("/getAllCastes")
	public ResponseEntity<List<CasteMaster>> getAllCastes(){
		List<CasteMaster> castes = casteMasterRepo.findAll();
		return new ResponseEntity<>(castes, HttpStatus.OK);
	}
	@GetMapping("/getAllSSCBoards")
	public ResponseEntity<List<SSCExamBoardMaster>> getAllSSCBoards(){
		List<SSCExamBoardMaster> boards = sSCExamBoardMasterRepo.findAll();
		return new ResponseEntity<>(boards, HttpStatus.OK);
	}
	@GetMapping("/getAllItis")
	public ResponseEntity<List<Iti>> allItis(){
		List<Iti> itis = itiRepo.findAll();
		return new ResponseEntity<>(itis, HttpStatus.OK);
	}
	@GetMapping("/ititrademaster")
	public ResponseEntity<List<ItiTradeMaster>> ititrade_master(){
		List<ItiTradeMaster> ititrade_master = itiTradeMasterRepo.findAll();
		return new ResponseEntity<>(ititrade_master, HttpStatus.OK);
	}
	@GetMapping("/ititrade")
	public ResponseEntity<List<ItiTrade>> ititrade(){
		List<ItiTrade> ititrade = itiTradeRepo.findAll();
		return new ResponseEntity<>(ititrade, HttpStatus.OK);
	}
	@GetMapping("/getItiProfilesWithTradeAndStrength")
	public ResponseEntity<List<UniversalProjection>> getItiProfilesWithTradeAndStrength(){
		List<UniversalProjection> list = itiTradeRepo.getItiProfilesWithTradeAndStrength();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@GetMapping("/getAllDists")
	public ResponseEntity<?> getAllDists(){
		logger.info("getAllDists");
		List<OldDistMaster> dists = oldDistMasterRepo.findAll();
		return new ResponseEntity<List<OldDistMaster>>(dists, HttpStatus.OK);
	}
	
	@GetMapping("/getMastersData")
	public AjaxResponseBody getMastersData() {
		System.out.println("/api/masterdata/getMastersData");
		AjaxResponseBody arb = new AjaxResponseBody();
		List<Dist_mast> districts = dist_mastRepo.findAll();arb.setDists(districts);
		List<States_mast> states = states_mastRepo.findAll();arb.setStates(states);
		List<ItiTradeMaster> trades = itiTradeMasterRepo.findAll();arb.setTrades(trades);
		return arb;
	}
	
	@GetMapping("/getAllGovtItisInDist")
	public ResponseEntity<?> getAllGovtItisInDist(HttpServletRequest httpServletRequest){
		logger.info("getAllGovtItisInDist");
		
		ClaimsModel claimsModel = myUtil.getClaimsFromToken(httpServletRequest);
		
		List<Iti> govtItis = itiRepo.getAllGovtItisInDist(claimsModel.getInsCode());
		return new ResponseEntity<>(govtItis, HttpStatus.OK);
	}
	

}
