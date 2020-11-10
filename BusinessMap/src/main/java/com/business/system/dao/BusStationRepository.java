package com.business.system.dao;

import com.business.system.po.AmusementPark;
import com.business.system.po.BusStation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BusStationRepository extends MongoRepository<BusStation, String>{

	@Query("{'results.formatted_address':{ '$regex' : ?0}}")
	List<BusStation> findByAddress(String address);
	
}
