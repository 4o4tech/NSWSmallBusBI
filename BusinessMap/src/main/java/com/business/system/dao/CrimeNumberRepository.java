package com.business.system.dao;

import com.business.system.po.CrimeNumber;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CrimeNumberRepository extends MongoRepository<CrimeNumber, String>{

	@Query("{$or:[{'postcode':?0},{'suburb':?1}]}")
	List<CrimeNumber> findByPostCodeOrSuburb(Integer postCode, String suburb);
	
}
