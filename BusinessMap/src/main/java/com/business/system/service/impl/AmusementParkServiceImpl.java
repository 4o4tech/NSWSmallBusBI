package com.business.system.service.impl;

import com.business.system.dao.AmusementParkRepository;
import com.business.system.po.AmusementPark;
import com.business.system.service.AmusementParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmusementParkServiceImpl implements AmusementParkService{

	@Autowired
	private AmusementParkRepository amusementParkRepository;

	@Override
	public List<AmusementPark> findByName(String name) {
		List<AmusementPark> list=amusementParkRepository.findByName(name);
		return list;
	}



}
