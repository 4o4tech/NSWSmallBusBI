package com.business.system.service;


import com.business.system.po.CrimeNumber;

import java.util.List;

public interface CrimeNumberService {
	List<CrimeNumber> findByPostCodeOrSuburb(String keywords);
}
