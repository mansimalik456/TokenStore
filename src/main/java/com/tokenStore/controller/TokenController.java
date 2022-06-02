package com.tokenStore.controller;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tokenStore.repository.TokenRepository;
import com.tokenStore.service.TokenService;

@RestController
public class TokenController {
	
	@Autowired TokenRepository tokenRepository;
	@Autowired TokenService tokenService;
	
	
	@PostMapping("/addToken/deatils")
	public ResponseEntity<?> addTokenInUserDetails(@RequestParam Long uesrId, @RequestParam String deviceId, @RequestParam String token){
		Object addToeknInTheUserDetails = tokenService.addToeknInTheUserDetails(uesrId, deviceId, token);
		
		if(Objects.nonNull(addToeknInTheUserDetails)) {
			return new ResponseEntity<>(addToeknInTheUserDetails, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@GetMapping("/details")
	public ResponseEntity<?> getUserDetails(@RequestParam Long userId, @RequestParam String deviceId){
		
		Object userDetail = tokenService.getUserDetail(userId, deviceId);
		if(Objects.nonNull(userDetail)) {
		//	return ResponseEntity.ok(userDetail);
			return new ResponseEntity<>(userDetail, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateToken(@RequestParam Long userId, @RequestParam String deviceId, @RequestParam String token){	
		boolean updateTokenData = tokenService.updateTokenData(userId, deviceId, token);
		if(updateTokenData) {
			return new ResponseEntity<>(updateTokenData, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
}
