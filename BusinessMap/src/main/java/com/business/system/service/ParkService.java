package com.business.system.service;

import com.business.system.po.Park;

import java.util.List;

public interface ParkService {
	List<Park> findByAddress(String address);
}
