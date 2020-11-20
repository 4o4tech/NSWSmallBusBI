package com.business.system.controller;


import com.business.system.pagemodel.DataGrid;
import com.business.system.po.*;
import com.business.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	@Autowired
	private BusStationService busStationService;
	@Autowired
	private BankService bankService;
	@Autowired
	private ParkService parkService;
	@Autowired
	private ShoppingMallService shoppingMallService;
	@Autowired
	private TouristAttractionService touristAttractionService;



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
	public String returnHomepage(@RequestParam("keywords") String keywords, HttpServletRequest request){
		request.getSession().removeAttribute("keywords");
		request.getSession().setAttribute("keywords",keywords);
		return "test";
	}

	@RequestMapping(value="/getRentalPriceList")
	@ResponseBody
	public List<RentalPrice> getRentalPriceList(@RequestParam("keywords") String keywords,HttpServletRequest request){
		keywords = (String)request.getSession().getAttribute("keywords");
		List<RentalPrice> rentalPriceList =	rentalPriceService.findByPostCodeOrSuburb(keywords);
		return rentalPriceList;
	}

	@RequestMapping(value="/getTrainStationTimetableList")
	@ResponseBody
	public List<TrainStationTimetable> getTrainStationTimetableList(@RequestParam("keywords") String keywords,HttpServletRequest request){
		keywords = (String)request.getSession().getAttribute("keywords");
		List<TrainStationTimetable> trainStationTimetableList = trainStationTimetableService.findByPostCodeOrSuburb(keywords);
		return trainStationTimetableList;
	}

	@RequestMapping(value="/getCrimeNumberList")
	@ResponseBody
	public List<CrimeNumber> getCrimeNumberList(@RequestParam("keywords") String keywords,HttpServletRequest request){
		keywords = keywords = (String)request.getSession().getAttribute("keywords");
		List<CrimeNumber> crimeNumberList = crimeRateService.findByPostCodeOrSuburb(keywords);
		return crimeNumberList;
	}

	@RequestMapping(value="/getPieList")
	@ResponseBody
	public Map<String,Integer> getPieList(@RequestParam("keywords") String keywords,HttpServletRequest request){
		keywords = (String)request.getSession().getAttribute("keywords");
		List<BusStation> busStationList = busStationService.findByAddress(keywords);
		List<Bank> bankList = bankService.findByAddress(keywords);
		List<Park> parkList = parkService.findByAddress(keywords);
		List<ShoppingMall> shoppingMallList = shoppingMallService.findByAddress(keywords);
		List<TouristAttraction> touristAttractionList = touristAttractionService.findByAddress(keywords);
		Integer busStaitons = busStationList == null ? 0 : busStationList.size();
		Integer banks = bankList == null ? 0 : bankList.size();
		Integer parks = parkList == null ? 0 : parkList.size();
		Integer shoppingMalls = shoppingMallList == null ? 0 : shoppingMallList.size();
		Integer touristAttractions = touristAttractionList == null ? 0 : touristAttractionList.size();

		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("busStation",busStaitons);
		map.put("bank",banks);
		map.put("park",parks);
		map.put("shoppingMall",shoppingMalls);
		map.put("touristAttraction",touristAttractions);

		return map;
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
