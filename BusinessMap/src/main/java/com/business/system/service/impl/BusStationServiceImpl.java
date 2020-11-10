package com.business.system.service.impl;

import com.business.system.dao.BusStationRepository;
import com.business.system.po.BusStation;
import com.business.system.service.BusStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusStationServiceImpl implements BusStationService{

	@Autowired
	private BusStationRepository busStationRepository;

	@Override
	public List<BusStation> findByAddress(String address) {
		List<BusStation> list=busStationRepository.findByAddress(address);
		return list;
	}



}
