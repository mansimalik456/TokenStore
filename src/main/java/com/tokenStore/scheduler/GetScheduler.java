package com.tokenStore.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.tokenStore.repository.TokenRepository;
import com.tokenStore.service.TokenService;

@Service
public class GetScheduler {
	
	@Autowired TokenService tokenService;
	@Autowired TokenRepository tokenRepository;
	
	Logger log = LoggerFactory.getLogger(TokenService.class);
	
	Logger logger = LoggerFactory.getLogger(GetScheduler.class);
	
	@Scheduled(cron = "0 * * ? * *")   // Scheduled After 1 minutes
	public void run() {
		Long userId = 2L;
		String deviceId = "123";
		log.info("Value: {}", tokenService.getUserDetail(userId, deviceId));
		System.out.println(tokenService.getUserDetail(userId, deviceId));
	}

}
