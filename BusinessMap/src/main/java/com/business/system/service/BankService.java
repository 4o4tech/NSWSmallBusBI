package com.business.system.service;

import com.business.system.po.Bank;
import com.business.system.po.BusStation;

import java.util.List;

public interface BankService {
	List<Bank> findByAddress(String address);
}
