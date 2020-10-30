package com.business.system.service;


import com.business.system.po.Picture;

import java.util.List;
import java.util.Optional;

public interface PictureService{
//	List<Picture> getpiclist(int current, int rowCount, String sortid);//document for one page
	int getpicturenum();//overall num
	Optional<Picture> getPictureByid(String id);//get document by ID
	void SaveorUpdatePicture(Picture p);
//	void deletePicture(String id);
	List<Picture> getsearchresult(int current,int rowCount,String sortid,String search);//search result for one page
	int getsearchresulttotal(String search);//overall num of search result

	List<Picture> getpiclist(int current, int rowCount, String sortid);
}
