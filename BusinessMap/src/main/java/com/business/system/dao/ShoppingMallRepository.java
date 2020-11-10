package com.business.system.dao;

import com.business.system.po.ShoppingMall;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ShoppingMallRepository extends MongoRepository<ShoppingMall, String>{

	@Query("{'results.formatted_address':{ '$regex' : ?0}}")
	List<ShoppingMall> findByAddress(String address);
	
}
