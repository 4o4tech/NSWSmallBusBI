package com.business.system.controller;


import com.business.system.pagemodel.DataGrid;
import com.business.system.po.Picture;
import com.business.system.service.PictureService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
//@RequestMapping(value="/mongodb")
public class MongodbController {
	
	@Resource(name="mongodbServiceImpl")
	private PictureService mongodbService;
	
	@RequestMapping(value="/pictures", method=RequestMethod.GET)
	@ResponseBody
	public DataGrid<Picture> getpiclist(@RequestParam("current") int current, @RequestParam("rowCount") int rowCount
			, @RequestParam(required=false,value="sort[id]")String sortid
			, @RequestParam(required=false,value="searchPhrase")String searchPhrase){
		if(searchPhrase==null){
		List<Picture> list=mongodbService.getpiclist(current,rowCount,sortid);
		int total=mongodbService.getpicturenum();
		DataGrid<Picture> grid=new DataGrid<Picture>();
		grid.setCurrent(current);
		grid.setRowCount(rowCount);
		grid.setRows(list);
		grid.setTotal(total);
		return grid;
		}else{
			List<Picture> list=mongodbService.getsearchresult(current, rowCount, sortid, searchPhrase);
			int total=mongodbService.getsearchresulttotal(searchPhrase);
			DataGrid<Picture> grid=new DataGrid<Picture>();
			grid.setCurrent(current);
			grid.setRowCount(rowCount);
			grid.setRows(list);
			grid.setTotal(total);
			return grid;
		}
	}
	
	@RequestMapping(value="/mongo_index")
	public String showpic(){
		return "mongodb";
	}
	
	@RequestMapping(value="/test")
	public String returnHomepage(){
		return "test";
	}
	
	@RequestMapping(value="picture/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public void deletepicture(@PathVariable("id")String id){
		mongodbService.deletePicture(id);
	}
	
	
	@RequestMapping(value="/picture/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Picture getpicture(@PathVariable("id")String id){
		Picture p=mongodbService.getPictureByid(id);
		return p;
	}
	@RequestMapping(value="/picture",method=RequestMethod.POST)
	public String addpicture(@ModelAttribute("picture")Picture picture){
		mongodbService.SaveorUpdatePicture(picture);
		return "mongodb";
	}
	@RequestMapping(value="add",method=RequestMethod.GET)
	@ResponseBody
	public void ddd(){
		for(int i=0;i<10;i++){
			Picture p=new Picture("w","java");
			mongodbService.SaveorUpdatePicture(p);
		}
		
	}
}
