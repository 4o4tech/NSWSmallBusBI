package com.business.system.dao;

import com.business.system.po.Bank;
import com.business.system.po.BusStation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BankRepository extends MongoRepository<Bank, String>{

	@Query("{'results.formatted_address':{ '$regex' : ?0}}")
	List<Bank> findByAddress(String address);
	
}
