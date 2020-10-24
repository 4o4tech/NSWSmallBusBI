package com.business.system.controller;

import cn.hutool.json.JSONObject;
import com.business.system.entity.Industry;
import com.business.system.service.IndustryRepository;
import com.mongodb.AggregationOutput;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.mongodb.client.MongoCursor;


import javax.annotation.Resource;
import java.util.List;

import static com.mongodb.client.model.Filters.regex;

@Controller
public class industryController {

//    @Autowired
//    private IndustryRepository industryRepository;

    @Resource
    private MongoTemplate mongoTemplate;


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

//
//    @RequestMapping("/test1/{id}")
//    public String aaa(@PathVariable Long id){
//        return "id us："+id;
//    }
//

    /**
     * 根据name查询
     * @param
     * @return
     */
//    @ResponseBody
//    @GetMapping("/industry/{name}")

    @ResponseBody
    @RequestMapping("/industry/{name}")
    public String readIndustryByName(@PathVariable String name, @RequestParam (value="code") String address){

//        Industry testIndustry = industryRepository.findbyName(name);

//        MongoCollection<Document> collection = mongoTemplate.getCollection("bank");
        System.out.println("Collection:  " +name);

        MongoCollection<org.bson.Document> collection = mongoTemplate.getCollection(name);

        Bson regBson = regex("results.formatted_address", address);
        //add Bson to search
        FindIterable<org.bson.Document> documents = collection.find(regBson);
        //to json (string)



        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Document document : documents) {
            sb.append(document.toJson() + ",\n");
        }
        sb.append("]");
        return sb.toString();
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
