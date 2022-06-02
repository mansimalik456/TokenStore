package com.tokenStore.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public interface TokenService {
	
	public Object addToeknInTheUserDetails(Long uesrId, String deviceId, String token);

	public Object getUserDetail(Long userId, String deviceId);

	public boolean updateTokenData(Long userId, String deviceId, String token); 
	
	
}
