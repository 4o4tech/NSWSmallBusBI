package com.business.system.service;

import com.business.system.po.TouristAttraction;

import java.util.List;

public interface TouristAttractionService {
	List<TouristAttraction> findByAddress(String address);
}
