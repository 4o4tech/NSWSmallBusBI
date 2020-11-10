package com.business.system.service.impl;

import com.business.system.dao.TouristAttractionRepository;
import com.business.system.po.TouristAttraction;
import com.business.system.service.TouristAttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristAttractionServiceImpl implements TouristAttractionService{

	@Autowired
	private TouristAttractionRepository touristAttractionRepository;

	@Override
	public List<TouristAttraction> findByAddress(String address) {
		List<TouristAttraction> list=touristAttractionRepository.findByAddress(address);
		return list;
	}



}
