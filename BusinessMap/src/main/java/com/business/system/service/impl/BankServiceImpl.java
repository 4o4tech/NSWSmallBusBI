package com.business.system.service.impl;

import com.business.system.dao.BankRepository;
import com.business.system.po.Bank;
import com.business.system.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService{

	@Autowired
	private BankRepository bankRepository;

	@Override
	public List<Bank> findByAddress(String address) {
		List<Bank> list=bankRepository.findByAddress(address);
		return list;
	}



}
