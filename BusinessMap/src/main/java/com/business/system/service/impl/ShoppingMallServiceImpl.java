package com.business.system.service.impl;

import com.business.system.dao.ShoppingMallRepository;
import com.business.system.po.ShoppingMall;
import com.business.system.service.ShoppingMallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingMallServiceImpl implements ShoppingMallService{

	@Autowired
	private ShoppingMallRepository shoppingMallRepository;

	@Override
	public List<ShoppingMall> findByAddress(String address) {
		List<ShoppingMall> list=shoppingMallRepository.findByAddress(address);
		return list;
	}



}
