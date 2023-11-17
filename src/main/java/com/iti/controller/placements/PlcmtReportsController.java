package com.iti.controller.placements;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iti.entity.placements.Placement;
import com.iti.entity.placements.PlcmtScheduleEntry;
import com.iti.model.ApiError;
import com.iti.model.ClaimsModel;
import com.iti.model.Plcmt_Report_Bean;
import com.iti.model.ResponseRest;
import com.iti.repo.placements.PlacementRepo;
import com.iti.repo.placements.PlcmtScheduleEntryRepo;
import com.iti.util.MyUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/plcmt")
@CrossOrigin(origins = "*")
public class PlcmtReportsController {

	private final static Logger logger = LoggerFactory.getLogger(PlcmtReportsController.class);

	@Autowired
	private PlacementRepo placementRepo;
	@Autowired
	private MyUtil myUtil;
	@Autowired
	private PlcmtScheduleEntryRepo plcmtScheduleEntryRepo;

	@PostMapping("savePlcmtDetails")
	public ResponseEntity<?> savePlcmtDetails(@RequestBody Plcmt_Report_Bean bean, HttpServletRequest request) {

		System.out.println("/api/plcmt/savePlcmtDetails");
		System.out.println("bean=>" + bean.toString());
		final String authorizationHeader = request.getHeader("Authorization").substring(7);
		System.out.println("authorizationHeader=>" + authorizationHeader);

		if (authorizationHeader == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token is required to access Data.");
		}

		String isValid = myUtil.validateToken(authorizationHeader);
		if (isValid.equalsIgnoreCase("true")) {

			ClaimsModel claimsModel = myUtil.getClaimsFromToken(request);

			Placement plcmtBean = new Placement();

			// plcmtBean.setEntry_by(bean.getEntry_by());
			plcmtBean.setPtype(bean.getPtype());

			plcmtBean.setAdm_num(bean.getAdm_num());
			plcmtBean.setDist_name(bean.getDist_name());
			plcmtBean.setIti_name(bean.getIti_name());
			plcmtBean.setName(bean.getName());
			plcmtBean.setPassmonth(bean.getPassmonth());
			plcmtBean.setPassyear(bean.getPassyear());
			plcmtBean.setYear_of_admission(bean.getYear_of_admission());
			plcmtBean.setTrade_code(bean.getTrade_code());
			plcmtBean.setTrade_name(bean.getTrade_name());

			plcmtBean.setDist_code(bean.getDist_code());
			plcmtBean.setPstate(bean.getPstate());
			plcmtBean.setPaddress(bean.getPaddress());
			plcmtBean.setPdistrict(bean.getPdistrict());
			plcmtBean.setIti_code(bean.getIti_code());

			String distCode = myUtil.getEntryDistCode(claimsModel.getInsCode());

			if (bean.getPtype().equalsIgnoreCase("HigherEducation")) {
				plcmtBean.setPclgname(bean.getPclgname());
				plcmtBean.setPcoursename(bean.getPcoursename());
				plcmtBean.setEntry_by(claimsModel.getInsCode());
				plcmtBean.setEntry_distcode(distCode);

			}

			if (bean.getPtype().equalsIgnoreCase("Job")) {

				plcmtBean.setPname_of_company(bean.getPname_of_company());
				plcmtBean.setPpostname(bean.getPpostname());
				plcmtBean.setPsalary(bean.getPsalary());
				plcmtBean.setPhrno(bean.getPhrno());
				plcmtBean.setScheduleId(bean.getScheduleId());
				plcmtBean.setEntry_by(claimsModel.getInsCode());
				plcmtBean.setEntry_distcode(distCode);
			}
			if (bean.getPtype().equalsIgnoreCase("OJ")) {

				plcmtBean.setPname_of_company(bean.getPname_of_company());
				plcmtBean.setPpostname(bean.getPpostname());
				plcmtBean.setPsalary(bean.getPsalary());
				plcmtBean.setPhrno(bean.getPhrno());
				plcmtBean.setEntry_by(claimsModel.getInsCode());
				plcmtBean.setEntry_distcode(distCode);
			}

			if (bean.getPtype().equalsIgnoreCase("Apprenticeship")) {
				plcmtBean.setPname_of_company(bean.getPname_of_company());
				plcmtBean.setPhrno(bean.getPhrno());
				plcmtBean.setPtrade(bean.getPtrade());
				plcmtBean.setPstipendamt(bean.getPstipendamt());
				plcmtBean.setPaaprstartdate(bean.getPaaprstartdate());
				plcmtBean.setPaaprenddate(bean.getPaaprenddate());
				plcmtBean.setScheduleId(bean.getScheduleId());
				plcmtBean.setEntry_by(claimsModel.getInsCode());
				plcmtBean.setEntry_distcode(distCode);
			}
			if (bean.getPtype().equalsIgnoreCase("OA")) {
				plcmtBean.setPname_of_company(bean.getPname_of_company());
				plcmtBean.setPhrno(bean.getPhrno());
				plcmtBean.setPtrade(bean.getPtrade());
				plcmtBean.setPstipendamt(bean.getPstipendamt());
				plcmtBean.setPaaprstartdate(bean.getPaaprstartdate());
				plcmtBean.setPaaprenddate(bean.getPaaprenddate());
				plcmtBean.setEntry_by(claimsModel.getInsCode());
				plcmtBean.setEntry_distcode(distCode);
			}

			if (bean.getPtype().equalsIgnoreCase("SelfEmployment")) {
				plcmtBean.setPselfemp(bean.getPselfemp());
				plcmtBean.setPmonthincome(bean.getPmonthincome());
				plcmtBean.setEntry_by(claimsModel.getInsCode());
				plcmtBean.setEntry_distcode(distCode);
			}
			String msg = "";
			try {
				placementRepo.save(plcmtBean);
				msg = "plaement details are ADDED successfully with placement ID: " + plcmtBean.getPid();
			} catch (Exception e) {
				msg = "Something went wrong while saving placement data";
				e.printStackTrace();
			}
			ResponseRest resp = new ResponseRest();
			resp.setMsg(msg);
			return ResponseEntity.ok(resp);

		} else {
			return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST, "Given Token is Invalid."),
					HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("getPlcmtYearWiseReport")
	public ResponseEntity<?> getPlcmtYearWiseReport(HttpServletRequest request) {
		logger.info("/getPlcmtYearWiseReport");

		ClaimsModel claimsModel = myUtil.getClaimsFromToken(request);


			if (claimsModel.getRoleId().equalsIgnoreCase("2") || claimsModel.getRoleId().equalsIgnoreCase("10")) {
				return new ResponseEntity<>(placementRepo.getPlcmtYearWiseReport(), HttpStatus.OK);
			} else {
				String msg = "Your Not Authorized to this Page";
				ResponseRest resp = new ResponseRest();
				resp.setMsg(msg);
				return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
			}
		 
	}

	@PostMapping("getPlcmtDistWiseCountReport")
	public ResponseEntity<?> getPlcmtDistWiseCountReport(HttpServletRequest request) {
		logger.info("/getPlcmtDistWiseCountReport");

		ClaimsModel claimsModel = myUtil.getClaimsFromToken(request);

		if (claimsModel.getRoleId().equalsIgnoreCase("10") || claimsModel.getRoleId().equalsIgnoreCase("2")) {
			return new ResponseEntity<>(placementRepo.getPlcmtDistWiseCountReport(), HttpStatus.OK);
		} else {
			String msg = "Your Not Authorized to this Page";
			ResponseRest resp = new ResponseRest();
			resp.setMsg(msg);
			return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("getAllPlcmts")
	public ResponseEntity<?> getAllPlcmts(HttpServletRequest request) throws SQLException {
		logger.info("/getAllPlcmts");

		ClaimsModel claimsModel = myUtil.getClaimsFromToken(request);
		if (claimsModel.getRoleId().equalsIgnoreCase("4")) {
			logger.info("roleId=>" + claimsModel.getRoleId());

			List<Placement> listPlacements = placementRepo.getPlcmtEntryBy(claimsModel.getInsCode());
			List<Placement> listPlacements2 = new ArrayList<Placement>();

			for (Placement lp : listPlacements) {
				if (lp.getPtype().equalsIgnoreCase("A")) {
					lp.setTrade_name(myUtil.getTradeName(lp.getTrade_code()));
				}
				listPlacements2.add(lp);
			}
			System.out.println("listPlacements = > " + listPlacements2.size());
			return new ResponseEntity<>(listPlacements2, HttpStatus.OK);
		} else if (claimsModel.getRoleId().equalsIgnoreCase("3") || claimsModel.getRoleId().equalsIgnoreCase("10")
				|| claimsModel.getRoleId().equalsIgnoreCase("2")) {
			List<Placement> listPlacements = new ArrayList<Placement>();
			listPlacements = placementRepo.findAll();
			List<Placement> listPlacements2 = new ArrayList<Placement>();
			for (Placement lp : listPlacements) {

				if (lp.getPtype().equalsIgnoreCase("A")) {
					lp.setTrade_name(myUtil.getTradeName(lp.getTrade_code()));
				}
				listPlacements2.add(lp);
			}
			System.out.println("listPlacements = > " + listPlacements2.size());
			return new ResponseEntity<>(listPlacements2, HttpStatus.OK);

		}
		return null;
	}

	@PostMapping("getAllSchedulesByDistcode")
	public ResponseEntity<?> getAllSchedulesByDistcode(HttpServletRequest request) {
		logger.info("getAllSchedulesByDistcode");

		ClaimsModel claimsModel = myUtil.getClaimsFromToken(request);
		if (claimsModel.getRoleId().equalsIgnoreCase("3")) {
			List<PlcmtScheduleEntry> plcmtScheduleEntry = plcmtScheduleEntryRepo
					.getAllSchedulesByDistcode(claimsModel.getInsCode());
			System.out.println("findAdm_num===> listEntries=>" + plcmtScheduleEntry.size());

			return new ResponseEntity<>(plcmtScheduleEntry, HttpStatus.OK);
		} else {
			String msg = "Your Not Authorized to this Page";
			ResponseRest resp = new ResponseRest();
			resp.setMsg(msg);
			return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
		}

//		ResponseObject responseObject = myUtil.validToken(authorizationHeader);
//		System.out.println("responseObject=>"+responseObject.getInsCode());
//		
//		if (responseObject.getValidToken()) {
//			if (responseObject.getRoleId().equalsIgnoreCase("3")) {
//				List<PlcmtScheduleEntry> plcmtScheduleEntry  = plcmtScheduleEntryRepo.getAllSchedulesByDistcode(responseObject.getInsCode());
//				System.out.println("findAdm_num===> listEntries=>"+plcmtScheduleEntry.size());
//				
//				return new ResponseEntity<>(plcmtScheduleEntry, HttpStatus.OK);
//			}else {
//				String msg = "Your Not Authorized to this Page";
//				ResponseRest resp = new ResponseRest();
//				resp.setMsg(msg);
//				return new ResponseEntity<>(resp,HttpStatus.NOT_FOUND);
//			}
//		} else {
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Your Given Token is Invalid.");
//		}
	}

	@PostMapping("savePlcmtScheduleEntry")
	public ResponseEntity<?> savePlcmtScheduleEntry(@Valid @RequestBody PlcmtScheduleEntry plcmtScheduleEntry,
			HttpServletRequest request) {
		logger.info("savePlcmtScheduleEntry");
		logger.info("savePlcmtScheduleEntry" + plcmtScheduleEntry.toString());

		ClaimsModel claimsModel = myUtil.getClaimsFromToken(request);
		plcmtScheduleEntry.setDist_code(claimsModel.getInsCode());
		if (claimsModel.getRoleId().equalsIgnoreCase("3")) {
			PlcmtScheduleEntry savedPlcmtScheduleEntry = plcmtScheduleEntryRepo.save(plcmtScheduleEntry);
			System.out.println("after saving data=>" + savedPlcmtScheduleEntry.toString());

			String scheduleId = String.valueOf(savedPlcmtScheduleEntry.getScheduleId());
			System.out.println("scheduleId" + scheduleId);

			String msg = "Schedule Saved Successfully with Placement ID: " + scheduleId
					+ ". Save this id for entering placements entry.";

			ResponseRest resp = new ResponseRest();
			resp.setMsg(msg);

			return new ResponseEntity<>(resp, HttpStatus.OK);
		}

//		ResponseObject responseObject = myUtil.validToken(authorizationHeader);
//		
//		if (responseObject.getValidToken()) {
//			
//			if (responseObject.getRoleId().equalsIgnoreCase("3")) {
//				PlcmtScheduleEntry savedPlcmtScheduleEntry  = plcmtScheduleEntryRepo.save(plcmtScheduleEntry);
//				System.out.println("after saving data=>"+savedPlcmtScheduleEntry.toString());
//				
//				String scheduleId = String.valueOf(savedPlcmtScheduleEntry.getScheduleId());
//				System.out.println("scheduleId"+scheduleId);
//				
//				String msg = "Schedule Saved Successfully with Placement ID: "+scheduleId+". Save this id for entering placements entry.";
//				
//				ResponseRest resp = new ResponseRest();
//				resp.setMsg(msg);
//				
//				return new ResponseEntity<>(resp, HttpStatus.OK);
//			}else {
//				String msg = "Your Not Authorized to this Page";
//				ResponseRest resp = new ResponseRest();
//				resp.setMsg(msg);
//				return new ResponseEntity<>(resp,HttpStatus.NOT_FOUND);
//			}
//			
//		} else {
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Your Given Token is Invalid.");
//		}
		return null;
	}

	@PostMapping("getCandPlcmtDetails")
	public ResponseEntity<?> getCandPlcmtDetails(HttpServletRequest request, @RequestParam("admNum") String admNum) {

		System.out.println("/api/plcmt/reports/getCandPlcmtDetails" + admNum);

		if (admNum.isEmpty()) {
			return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST, "Given Admission should not be empty"),
					HttpStatus.BAD_REQUEST);
		}

		final String authorizationHeader = request.getHeader("Authorization").substring(7);
		System.out.println("authorizationHeader=>" + authorizationHeader);

		if (authorizationHeader == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token is required to access Data.");
		}

		String isValid = myUtil.validateToken(authorizationHeader);
		if (isValid.equalsIgnoreCase("true")) {
			List<Placement> plcmt = placementRepo.getPlcmtByAdmnum(admNum);
			return new ResponseEntity<>(plcmt, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST, "Given Token is Invalid."),
					HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("getAllByPlcmtType")
	public ResponseEntity<?> getAllByPlcmtType(HttpServletRequest request,
			@RequestParam("scheduleType") String scheduleType) {

		System.out.println("/api/plcmt/getAllByPlcmtType" + scheduleType);

		if (scheduleType.isEmpty() || scheduleType.isEmpty()) {
			return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST, "Given ITI code should not be empty"),
					HttpStatus.BAD_REQUEST);
		}

		final String authorizationHeader = request.getHeader("Authorization").substring(7);
		System.out.println("authorizationHeader=>" + authorizationHeader);

		if (authorizationHeader == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token is required to access Data.");
		}
		String isValid = myUtil.validateToken(authorizationHeader);
		if (isValid.equalsIgnoreCase("true")) {
			ClaimsModel claimsModel = myUtil.getClaimsFromToken(request);
			List<PlcmtScheduleEntry> plcmtScheduleEntry = plcmtScheduleEntryRepo.getAllByScheduleType(scheduleType,
					claimsModel.getInsCode());
			return new ResponseEntity<>(plcmtScheduleEntry, HttpStatus.OK);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Your Given Token is Invalid.");
		}
	}

	@PostMapping("itiLevelPlcmtDetails")
	public ResponseEntity<?> getPlcmtDetailsForITI(HttpServletRequest httpServletRequest) {
		logger.info("itiLevelPlcmtDetails");

		ClaimsModel claims = myUtil.getClaimsFromToken(httpServletRequest);
		logger.info("iti_code=>" + claims.getInsCode());

		List<Placement> plcmtDetails = placementRepo.getItiLevelPlcmts(claims.getInsCode());
		logger.info("plcmtDetails size=>" + plcmtDetails.size());

		return new ResponseEntity<List<Placement>>(plcmtDetails, HttpStatus.OK);
	}

}
