package com.business.system.service.impl;

import com.business.system.dao.CrimeNumberRepository;
import com.business.system.po.CrimeNumber;
import com.business.system.service.CrimeNumberService;
import cn.hutool.core.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrimeNumberServiceImpl implements CrimeNumberService{

	@Autowired
	private CrimeNumberRepository crimeNumberRepository;

	@Override
	public List<CrimeNumber> findByPostCodeOrSuburb(String keywords) {
		Integer postcode = 0;
		String suburb = "";
		if(NumberUtil.isInteger(keywords)){
			postcode = Integer.valueOf(keywords);
		}else {
			suburb = keywords;
		}
		List<CrimeNumber> list=crimeNumberRepository.findByPostCodeOrSuburb(postcode,suburb);
		return list;
	}



}
