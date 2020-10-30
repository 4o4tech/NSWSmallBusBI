package com.business.system.controller;

import com.business.system.model.QueryCollectionService;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;

@Controller
public class IndexController {
//	@RequestMapping("/test")
//    public String test(){
//        return "index";
//    }

    @Resource
    private MongoTemplate mongoTemplate;

    @ResponseBody
    @GetMapping(path = "status")
    public long status(){
        MongoCollection<Document> collection = mongoTemplate.getCollection("bank");

//        System.out.println(collection.count());

//        Boolean status = mongoTemplate.collectionExists("cafe");
        return collection.countDocuments();
    }


    @ResponseBody
    @GetMapping(path = "industryName")
    public String  allIndustry(){
        //get collection
        MongoCollection<Document> collection = mongoTemplate.getCollection("bank");

//        Bson bson = eq("results.formatted_address", "{$regex:\"2000\"}");

        Bson regBson = regex("results.formatted_address", "2000");
        //add Bson to search
        FindIterable<Document> documents = collection.find(regBson);
        //to json (string)
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Document document : documents) {
            sb.append(document.toJson() + ",\n");
        }
        sb.append("]");
        return sb.toString();

    }









}

