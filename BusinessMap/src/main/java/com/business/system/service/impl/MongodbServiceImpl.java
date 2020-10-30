package com.business.system.service.impl;


import java.util.List;
import com.business.system.dao.PictureRepository;
import com.business.system.po.Picture;
import com.business.system.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service("mongodbServiceImpl")
public class MongodbServiceImpl implements PictureService {
	
	private PictureRepository pictureRepository;
	@Autowired
	 public MongodbServiceImpl(PictureRepository pictureRepository){
		this.pictureRepository=pictureRepository;
	}
	
	public List<Picture> getpiclist(int current, int rowCount, String sortid){
		PageRequest pr;
		if("asc".equals(sortid))
			pr =new PageRequest(--current, rowCount,Direction.ASC,"id");
		else if("desc".equals(sortid))
			pr =new PageRequest(--current, rowCount,Direction.DESC,"id");
		else 
			pr =new PageRequest(--current, rowCount);
		Page<Picture> page=pictureRepository.findAll(pr);
		return page.getContent();
	}

	public Optional<Picture> getPictureByid(String s) {
		return pictureRepository.findById(s);
	}

//	public Picture getPictureByid(String id) {
//		Picture pic = pictureRepository.findById(id);
//
//		return pic;
//	}

	public int getpicturenum() {
		return (int) pictureRepository.count();
	}


//	public void deletePicture(String id) {
//		Picture pic = pictureRepository.findById(id);
//
//		pictureRepository.delete(pic);
//	}

	public void SaveorUpdatePicture(Picture p) {
		pictureRepository.save(p);
	}

	public List<Picture> getsearchresult(int current, int rowCount,
			String sortid, String search) {
		PageRequest pr;
		if("asc".equals(sortid))
			pr =new PageRequest(--current, rowCount,Direction.ASC,"id");
		else if("desc".equals(sortid))
			pr =new PageRequest(--current, rowCount,Direction.DESC,"id");
		else 
			pr =new PageRequest(--current, rowCount);
		Page<Picture> page= pictureRepository.findByAddressContaining(search, pr);
		return page.getContent();
	}

	public int getsearchresulttotal(String search) {
		List<Picture> list= pictureRepository.findByAddressContaining(search);
		return list.size();
	}



}
