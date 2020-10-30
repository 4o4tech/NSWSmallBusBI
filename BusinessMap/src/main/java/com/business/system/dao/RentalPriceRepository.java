package com.business.system.dao;

import com.business.system.po.RentalPrice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RentalPriceRepository extends MongoRepository<RentalPrice, String>{

	@Query("{$or:[{'Postcode':?0},{'Suburb':?1}]}")
	List<RentalPrice> findByPostCodeOrSuburb(Integer postCode, String suburb);
	
}
