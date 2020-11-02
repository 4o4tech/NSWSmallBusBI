package com.business.system.controller;


import com.business.system.pagemodel.DataGrid;
import com.business.system.po.CrimeNumber;
import com.business.system.po.Picture;
import com.business.system.po.RentalPrice;
import com.business.system.po.TrainStationTimetable;
import com.business.system.service.CrimeNumberService;
import com.business.system.service.PictureService;
import com.business.system.service.RentalPriceService;
import com.business.system.service.TrainStationTimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping(value="/mongodb")
public class MongodbController {
	
	@Resource(name="mongodbServiceImpl")
	private PictureService mongodbService;
	@Autowired
	private CrimeNumberService crimeRateService;
	@Autowired
	private RentalPriceService rentalPriceService;
	@Autowired
	private TrainStationTimetableService trainStationTimetableService;


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

	///// George Part
	@RequestMapping(value="/test")
	public String returnHomepage(@RequestParam("keywords") String keywords){
		return "test";
	}

	@RequestMapping(value="/getRentalPriceList")
	@ResponseBody
	public List<RentalPrice> getRentalPriceList(@RequestParam("keywords") String keywords){
		List<RentalPrice> rentalPriceList =	rentalPriceService.findByPostCodeOrSuburb(keywords);
		return rentalPriceList;
	}

	@RequestMapping(value="/getTrainStationTimetableList")
	@ResponseBody
	public List<TrainStationTimetable> getTrainStationTimetableList(@RequestParam("keywords") String keywords){
		List<TrainStationTimetable> trainStationTimetableList = trainStationTimetableService.findByPostCodeOrSuburb(keywords);
		return trainStationTimetableList;
	}

	@RequestMapping(value="/getCrimeNumberList")
	@ResponseBody
	public List<CrimeNumber> getCrimeNumberList(@RequestParam("keywords") String keywords){
		List<CrimeNumber> crimeNumberList = crimeRateService.findByPostCodeOrSuburb(keywords);
		return crimeNumberList;
	}


	/////// George Part end /////


	

	
	@RequestMapping(value="/picture/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Optional<Picture> getpicture(@PathVariable("id")String id){
		Optional<Picture> p = mongodbService.getPictureByid(id);
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
