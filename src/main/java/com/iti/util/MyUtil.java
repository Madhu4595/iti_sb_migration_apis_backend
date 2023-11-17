package com.iti.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.iti.jwt.JwtUtil;
import com.iti.model.ClaimsModel;
import com.iti.model.ResponseObject;
import com.iti.model.TokenRequestModel;
import com.iti.model.TokenResponseModel;
import com.iti.model.ValidateTokenRequestModel;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;



@Component
public class MyUtil {
	
	 
	
	private static final Logger logger = LoggerFactory.getLogger(MyUtil.class);
	
	@Autowired private JwtUtil jwtUtil;
	
	@Value("${generateToken}") private String generateToken;
	@Value("${validateToken}") private String validateToken;
	@Value("${tokenkey}") private String secretKey;
	
	public static Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/iti_plcmt", "postgres", "mknic123");
			System.out.println("connn ====iti_db_live_copy========> " + connection);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}

	public String getTradeName(String trade_code) throws SQLException {
		String trade_name = "";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = MyUtil.getConnection();
			ps = con.prepareStatement("select trade_code,trade_name from ititrade_master where trade_code=?");
			ps.setInt(1, Integer.parseInt(trade_code));
			ResultSet rs = ps.executeQuery();
			System.out.println("======MyUtil===getTradeName(String trade_code)==ps=>" + ps);

			if (rs.next()) {
				trade_name = rs.getString("trade_name");
			}
		} catch (Exception e) {
			System.out.println("exception is--->" + e);
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e3) {
				e3.printStackTrace();
			}
		}
		return trade_name;
	}
	
	public String getEntryDistCode(String ins_code) {
		String dist_code = "";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = MyUtil.getConnection();
			ps = con.prepareStatement("select dist_code from iti where iti_code=?");
			ps.setString(1, ins_code);
			ResultSet rs = ps.executeQuery();
			System.out.println("======MyUtil===getTradeName(String trade_code)==ps=>" + ps);

			if (rs.next()) {
				dist_code = rs.getString("dist_code");
			}
		} catch (Exception e) {
			System.out.println("exception is--->" + e);
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e3) {
				e3.printStackTrace();
			}
		}
		return dist_code;
		
	}
	
	public String generateToken(TokenRequestModel entity)  {
		System.out.println("generateToken=>"+entity.toString());
		
		try {
			RestTemplate restTemplate = new RestTemplate();
			System.out.println("generateToken=>"+generateToken);
			ResponseEntity<TokenResponseModel> responsee = restTemplate.postForEntity(generateToken, entity, TokenResponseModel.class);
			System.out.println("response==>"+responsee.getBody());

			if (responsee.getStatusCode().is2xxSuccessful()) {
				// Handle the response
				String	jwtToken = responsee.getBody().getJwtToken();
				return jwtToken;
			}
			
		}catch (RestClientException e) {
			// TODO Auto-generated catch block
			System.out.println("RestClientException"+e);
			e.printStackTrace();
			  
		}
		return null;
	}
	
	public String validateToken(String jwtToken) {
		logger.info("validateToken");
		logger.info("jwtToken=>"+jwtToken);
		
		String valid = null;
		
		ValidateTokenRequestModel validateTokenRequestModel = new ValidateTokenRequestModel();
		validateTokenRequestModel.setJwtToken(jwtToken);
		validateTokenRequestModel.setSecretKey(secretKey);
		
		try {
			RestTemplate restTemplate = new RestTemplate();
			
			//ResponseEntity<Boolean> resp = restTemplate.postForEntity("http://localhost:8081/validateToken",validateTokenRequestModel, Boolean.class);
			ResponseEntity<Boolean> resp = restTemplate.postForEntity(validateToken,validateTokenRequestModel, Boolean.class);
			logger.info("resp=>" + resp.toString());
			logger.info("getStatusCode=>" + resp.getStatusCode());

			if (resp.getStatusCode().is2xxSuccessful()) {
				logger.info("valid=>"+resp.getBody().toString());
				valid = resp.getBody().toString();
			}
			
		}catch (RestClientException e) {
			// TODO Auto-generated catch block
			System.out.println("RestClientException"+e);
			e.printStackTrace();
		}
		
		return valid;
	}
	
	

	public ResponseObject validToken(String authorizationHeader) {
		System.out.println("validToken");
		ResponseObject responseObject = null;
		try {
			//String apiUrl = "http://10.96.64.62:8080/authserver/validateToken";
			RestTemplate restTemplate = new RestTemplate();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Authorization", authorizationHeader);

			HttpEntity<String> requesthadeer = new HttpEntity<>(headers);
			
			ResponseEntity<ResponseObject> responsee = restTemplate.postForEntity(validateToken, requesthadeer, ResponseObject.class);
			System.out.println("responsee=>" + responsee.toString());
			System.out.println("responsee=>" + responsee.getBody().getValidToken());
			System.out.println("responsee.getStatusCode()=>" + responsee.getStatusCode());
			if (responsee.getStatusCode().is2xxSuccessful()) {
				// Handle the response
				responseObject = new ResponseObject();
				responseObject.setValidToken(Boolean.valueOf(responsee.getBody().getValidToken()));
				responseObject.setInsCode(responsee.getBody().getInsCode());
				responseObject.setRoleId(responsee.getBody().getRoleId());
				 
			} else {
				// Handle error
				responseObject = new ResponseObject();
				responseObject.setValidToken(Boolean.valueOf(responsee.getStatusCode().toString()));
				System.out.println("Handle error");
			}
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			System.out.println("RestClientException"+e);
			responseObject = new ResponseObject();
			responseObject.setValidToken(false);
			e.printStackTrace();
		}
		System.out.println("responseObject=>"+responseObject.toString());
		return responseObject;
	}
	
	public ClaimsModel getClaimsFromToken(HttpServletRequest request) {
		logger.info("getClaimsFromToken");
		Claims claims = jwtUtil.getClaims(request);
		logger.info("claims" + claims.toString());
		
		ClaimsModel claimsModel = new ClaimsModel(
				claims.get("username", String.class),
				claims.get("roleId", String.class),
				claims.get("ins_code", String.class)
				);
		logger.info("claimsModel=>"+claimsModel.toString());
		
		
		return claimsModel;
	}
}

