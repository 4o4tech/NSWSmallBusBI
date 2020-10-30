package com.business.system.service.impl;

import com.business.system.dao.RentalPriceRepository;
import com.business.system.po.RentalPrice;
import com.business.system.service.RentalPriceService;
import cn.hutool.core.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalPriceServiceImpl implements RentalPriceService{

	@Autowired
	private RentalPriceRepository rentalPriceRepository;

	@Override
	public List<RentalPrice> findByPostCodeOrSuburb(String keywords) {
		Integer postcode = 0;
		String suburb = "";
		if(NumberUtil.isInteger(keywords)){
			postcode = Integer.valueOf(keywords);
		}else {
			suburb = keywords;
		}
		List<RentalPrice> list = rentalPriceRepository.findByPostCodeOrSuburb(postcode,suburb);
		return list;
	}



}
