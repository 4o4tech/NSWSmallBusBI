package com.business.system.dao;

import com.business.system.po.Park;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ParkRepository extends MongoRepository<Park, String>{

	@Query("{'results.formatted_address':{ '$regex' : ?0}}")
	List<Park> findByAddress(String address);
	
}
