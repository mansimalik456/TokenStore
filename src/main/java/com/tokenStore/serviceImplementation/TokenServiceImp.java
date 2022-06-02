package com.tokenStore.serviceImplementation;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Optional;
import com.tokenStore.entity.UserDetails;
import com.tokenStore.repository.TokenRepository;
import com.tokenStore.scheduler.GetScheduler;
import com.tokenStore.service.TokenService;

@Service
public class TokenServiceImp implements TokenService {

	@Autowired ObjectMapper mapper;
	@Autowired TokenRepository tokenRepository;
	
	public Object addToeknInTheUserDetails(Long uesrId, String deviceId, String token) {
		Optional<UserDetails> getUserId = tokenRepository.findByUserId(uesrId);
		if(getUserId.isPresent()) {
			UserDetails userDetails = getUserId.get();
			Map<String, String> data = userDetails.getTokenData();
			data.put(deviceId, token);
			return tokenRepository.save(userDetails);
		}else {
			UserDetails user = new UserDetails();
			user.setUserId(uesrId);
			Map<String, String> tokenDataSet = new HashMap<>();
			tokenDataSet.put(deviceId, token);
			user.setTokenData(tokenDataSet);
			return tokenRepository.save(user);	
		}
		
	}

	public Object getUserDetail(Long userId, String deviceId) {
		Optional<UserDetails> byUserId = tokenRepository.findByUserId(userId);
		if(byUserId.isPresent()) {
			UserDetails details = byUserId.get();
			System.out.println("data here"+details);
			Map<String, String> tokenData = details.getTokenData();
			System.out.println("tokenData : " + tokenData);
			return tokenData;
		}
		return null;
	}


	@Override
	public boolean updateTokenData(Long userId, String deviceId, String token) {
		
		Optional<UserDetails> findByUserId = tokenRepository.findByUserId(userId);
		
		if(findByUserId.isPresent()) {
			UserDetails userDetails = findByUserId.get();
			Map<String, String> tokenData = userDetails.getTokenData();
			
			if(tokenData.containsKey(deviceId) && !tokenData.containsValue(token)) {
				tokenData.put(deviceId, token);
				tokenRepository.save(userDetails);
				
				return true;
			}else {
				tokenRepository.save(userDetails);
				return true;
			}
		}
			return false;
	}
	
	
	

}
