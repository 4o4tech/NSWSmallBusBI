package com.business.system.service;


import com.business.system.po.RentalPrice;

import java.util.List;

public interface RentalPriceService {
	List<RentalPrice> findByPostCodeOrSuburb(String keywords);
}
