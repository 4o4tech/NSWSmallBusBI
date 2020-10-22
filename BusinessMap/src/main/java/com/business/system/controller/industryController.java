package com.business.system.controller;

import cn.hutool.json.JSONObject;
import com.business.system.entity.Industry;
import com.business.system.service.IndustryRepository;
import com.mongodb.AggregationOutput;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.mongodb.client.MongoCursor;


import javax.swing.text.Document;
import java.util.List;

@Controller
public class industryController {

    @Autowired
    private IndustryRepository industryRepository;


//    @RequestMapping("/industry_search")
//    public String industryPage(){
//        return "industry";
//    }

    @GetMapping("/industry_search")
    public String industryPage(Model model) {
        model.addAttribute("searchIndustry", new Industry());
        return "industry";
    }

    @PostMapping("/industry_search")
    public String industrySubmit(@ModelAttribute Industry searchIndustry, Model model){
//        Industry newIndustry  = new Industry();
        model.addAttribute("searchIndustry", searchIndustry);

        return "industry_dashboard";
    }

    @GetMapping("/search_all")
    public String getMessage(@ModelAttribute Industry searchIndustry,Model model){
//        model.addAttribute("searchIndustry", searchIndustry);

        searchIndustry.setName("Cafe");
        model.addAttribute("searchIndustry", searchIndustry);
        return "industry_dashboard";
    }



    /**
     * 根据name查询
     * @param name
     * @return
     */
    @GetMapping(value="/{name}")
    public String readIndustryByName(@PathVariable("name") String name){

        Industry testIndustry = industryRepository.findbyName(name);

        return testIndustry.getIndustryData();
    }



    /**
     * 根据id查询
     * @param industry
     * @return
     */
//    @GetMapping(value="/{industry}")
//    public List<Industry> readIndsutryById(@PathVariable("industry") String industry){
//
//
//        MongoCollection<Document> collection  = mongoTemplate.getCollection(industry).distinct();
//        try (
//
//
//                FindIterable fit = collection.find();
//
//               ArrayList<Document> docs = new ArrayList<Document>();
//
//               fit.into(docs);
//
//            for (Document doc : docs) {
//
//            System.out.println(doc);
//        }
//
//        }
//
//        return industryList;
//    }



//    @RequestMapping("/search")
//    public void search(){
//
//        List<Industry> industryList = (List<Industry>) mongoTemplate.getCollection(industry);
//
//        //
//        System.out.println(industryList);
////        System.out.println();
//    }



}
