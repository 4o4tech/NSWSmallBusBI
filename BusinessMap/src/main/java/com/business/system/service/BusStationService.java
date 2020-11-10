package com.business.system.service;

import com.business.system.po.AmusementPark;
import com.business.system.po.BusStation;

import java.util.List;

public interface BusStationService {
	List<BusStation> findByAddress(String address);
}
