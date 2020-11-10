package com.business.system.dao;

import com.business.system.po.AmusementPark;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AmusementParkRepository extends MongoRepository<AmusementPark, String>{

	@Query("{'results.name':{ '$regex' : ?0}}")
	List<AmusementPark> findByName(String name);
	
}
