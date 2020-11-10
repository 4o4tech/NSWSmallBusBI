package com.business.system.dao;

import com.business.system.po.TouristAttraction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TouristAttractionRepository extends MongoRepository<TouristAttraction, String>{

	@Query("{'results.formatted_address':{ '$regex' : ?0}}")
	List<TouristAttraction> findByAddress(String address);
	
}
