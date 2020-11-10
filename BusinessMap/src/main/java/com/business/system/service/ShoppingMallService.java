package com.business.system.service;

import com.business.system.po.ShoppingMall;

import java.util.List;

public interface ShoppingMallService {
	List<ShoppingMall> findByAddress(String address);
}
