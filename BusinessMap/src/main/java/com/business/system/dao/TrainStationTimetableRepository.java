package com.business.system.dao;

import com.business.system.po.TrainStationTimetable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TrainStationTimetableRepository extends MongoRepository<TrainStationTimetable, String>{

	@Query("{$or:[{'Postcode':?0},{'Suburb':?1}]}")
	List<TrainStationTimetable> findByPostCodeOrSuburb(Integer postCode, String suburb);
	
}
