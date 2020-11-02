package com.business.system.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.business.system.entity.Industry;
import com.business.system.entity.hottestIndustry;
import com.business.system.entity.industryCount;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


import java.util.Collections;
import java.util.List;
import java.util.Set;

import static com.mongodb.client.model.Filters.eq;
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


        if(name == null || name == ""){
            name = "cafe"; // setDefault result
        }
//        else{
//            name.replaceAll("\\s*", "_");
//        }
        name = name.toLowerCase();

        System.out.println("Collection:  " +name);
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



//    @RequestMapping("/getCollect")
    @RequestMapping("/getCollection/{name}")
    public List<industryCount> getCollectionsList(@PathVariable String name) {

        name = name.toLowerCase();

        Query query = new Query();
        CriteriaDefinition criteriaDefinition = Criteria.where("name").is(name);
        query.addCriteria(criteriaDefinition);

        System.out.println(query.toString());
//        regex("results.formatted_address",address);

        List<industryCount> res = mongoTemplate.find(query, industryCount.class);

        int getNumber = 0;
        // Print the name from the list....
        for(industryCount model : res) {
            getNumber = model.getCount();
        }

        System.out.printf("Count Number is  %d", getNumber);

        Query gteQuery = new Query();
        Query ltQuery = new Query();

        gteQuery.addCriteria(Criteria.where("count").gte(getNumber));
        gteQuery.with(new Sort(Sort.Direction.ASC, "count"));

        ltQuery.addCriteria(Criteria.where("count").lt(getNumber));
        ltQuery.with(new Sort(Sort.Direction.DESC, "count"));

        //db.industryCount.find({'count':{$gte:resAmount[0]}}).sort({count: 1}).limit(5);
        List<industryCount>  gteResult = mongoTemplate
                .find(gteQuery
                        .limit(5),
                        industryCount.class);


        //db.industryCount.find({'count':{$lt:resAmount[0]}}).sort({count:-1}).limit(5);
        List<industryCount>  ltResult = mongoTemplate
                .find(ltQuery.limit(5),
                        industryCount.class);


//        gteResult.addAll(ltResult);
        //merge two list together
        ltResult.addAll(gteResult);



        return ltResult;
    }



    //    @RequestMapping("/getCollect")
    @RequestMapping("/hottestIndustry")
    public List<industryCount>  getCollectionsList() {

        Query sortQuery = new Query();
        sortQuery.with(new Sort(Sort.Direction.DESC, "count"));

//        db.industryCount.find().sort({count: -1}).limit(10)
        List<industryCount> topIndustry = mongoTemplate
                .find(sortQuery.limit(10), industryCount.class);


//        System.out.printf("Count Number is  %d", topIndustry);

        return topIndustry;
    }




}
