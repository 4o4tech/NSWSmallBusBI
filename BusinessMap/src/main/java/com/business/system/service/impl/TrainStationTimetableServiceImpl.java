package com.business.system.service.impl;

import com.business.system.dao.TrainStationTimetableRepository;
import com.business.system.po.TrainStationTimetable;
import com.business.system.service.TrainStationTimetableService;
import cn.hutool.core.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainStationTimetableServiceImpl implements TrainStationTimetableService{

	@Autowired
	private TrainStationTimetableRepository trainStationTimetableRepository;

	@Override
	public List<TrainStationTimetable> findByPostCodeOrSuburb(String keywords) {
		Integer postcode = 0;
		String suburb = "";
		if(NumberUtil.isInteger(keywords)){
			postcode = Integer.valueOf(keywords);
		}else {
			suburb = keywords;
		}
		List<TrainStationTimetable> list=trainStationTimetableRepository.findByPostCodeOrSuburb(postcode,suburb);
		return list;
	}



}
