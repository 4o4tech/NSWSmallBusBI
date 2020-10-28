package com.business.system.dao;

import com.business.system.po.Picture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PictureRepository extends MongoRepository<Picture, String>{
	Picture findById(String id);
//	default Picture findById(String id) {
//		return null;
//	}

	Page<Picture> findAll(Pageable pageable);
	Page<Picture> findByAddressContaining(String address,Pageable pageable);
	List<Picture> findByAddressContaining(String address);
	
}
