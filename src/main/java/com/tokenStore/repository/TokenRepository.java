package com.tokenStore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.tokenStore.entity.UserDetails;

@Repository
public interface TokenRepository extends MongoRepository<UserDetails, String>{
	
	Optional <UserDetails> findByUserId(Long userId);

}
