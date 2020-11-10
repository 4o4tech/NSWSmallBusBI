package com.business.system.service.impl;

import com.business.system.dao.ParkRepository;
import com.business.system.po.Park;
import com.business.system.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkServiceImpl implements ParkService{

	@Autowired
	private ParkRepository parkRepository;

	@Override
	public List<Park> findByAddress(String address) {
		List<Park> list=parkRepository.findByAddress(address);
		return list;
	}



}
