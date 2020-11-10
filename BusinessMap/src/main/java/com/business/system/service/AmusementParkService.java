package com.business.system.service;

import com.business.system.po.AmusementPark;

import java.util.List;

public interface AmusementParkService {
	List<AmusementPark> findByName(String name);
}
