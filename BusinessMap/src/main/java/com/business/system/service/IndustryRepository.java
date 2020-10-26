package com.business.system.service;

import com.business.system.entity.Industry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IndustryRepository {

    Industry findbyName(String name);


}