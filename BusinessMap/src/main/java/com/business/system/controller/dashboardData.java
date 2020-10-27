package com.business.system.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.business.system.entity.Industry;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


import java.util.Collections;
import java.util.List;
import java.util.Set;

import static com.mongodb.client.model.Filters.regex;


@RestController
public class dashboardData {
    @Resource
    private MongoTemplate mongoTemplate;

//    @ResponseBody
    @RequestMapping("/getData/{name}")
    public String industryData(@PathVariable String name, @RequestParam(value="code") String address){

//        Industry testIndustry = industryRepository.findbyName(name);

//        MongoCollection<Document> collection = mongoTemplate.getCollection("bank");
        System.out.println("Collection:  " +name);
        if(name == null || name == ""){
            name = "cafe"; // setDefault result
        }
        MongoCollection<Document> collection = mongoTemplate.getCollection(name);


        if(address == null || address == ""){
            address = "2000"; // setDefault result
        }
//        Bson regBson = regex("results.formatted_address", "NSW " +address);// to remove address number
        Bson regBson = regex("results.formatted_address",address);


        BasicDBObject fieldsObject = new BasicDBObject();
        fieldsObject.put("_id", 0);
        fieldsObject.put("results.name", 1);
        fieldsObject.put("results.formatted_address", 2);
        fieldsObject.put("results.geometry.location", 3);


        //add Bson to search
        FindIterable<Document> documents = collection.find(regBson).projection(Document.parse(fieldsObject.toString()));


        //to json (string)
        StringBuilder sb = new StringBuilder();
//        sb.append("[");
        for(Document document : documents) {
            sb.append(document.toJson() + ",");
        }
//        sb.append("]");

        JSONObject jsonObj = new JSONObject(sb.toString());
//        int count = jsonObj.size();
//        jsonObj.put("status", "ok");
//        jsonObj.put("length", sb.length());
//        jsonObj.put("devices", noPlateNumberCarForm.getDevicesId());



//

      return jsonObj.toString();
    }


    //        db.getCollectionNames().map(function(name) {
//            return { "name": name, "count": db[name].count() }
//        })



    @RequestMapping("/getCollect")
    public Set<String> getCollectionsList(String dbName) {

        Set<String> resultList = mongoTemplate.getCollectionNames();

        mongoTemplate.getCollection("industryCount");

//        regex("results.formatted_address",address);



        return resultList;
    }

}
