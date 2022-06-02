package com.tokenStore.entity;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document("userdetails")
@Data
public class UserDetails {
	
	@Id
	private String id;
	
	@Indexed(unique = true)
	private Long userId;
	private Map<String, String> tokenData;
	

}
