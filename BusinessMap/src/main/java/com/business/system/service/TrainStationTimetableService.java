package com.business.system.service;


import com.business.system.po.TrainStationTimetable;

import java.util.List;

public interface TrainStationTimetableService {
	List<TrainStationTimetable> findByPostCodeOrSuburb(String keywords);
}
