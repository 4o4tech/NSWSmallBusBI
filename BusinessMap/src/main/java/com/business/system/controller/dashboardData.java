package com.business.system.controller;

import cn.hutool.json.JSONObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.mongodb.client.model.Filters.regex;


@RestController
public class dashboardData {
    @Resource
    private MongoTemplate mongoTemplate;

//    @ResponseBody
    @RequestMapping("/getData/{name}")
    public JSONObject industryData(@PathVariable String name, @RequestParam(value="code") String address){

//        Industry testIndustry = industryRepository.findbyName(name);

//        MongoCollection<Document> collection = mongoTemplate.getCollection("bank");
        System.out.println("Collection:  " +name);

        MongoCollection<Document> collection = mongoTemplate.getCollection(name);

        if(address == null || address == ""){
            address = "2000"; // setDefault result
        }
        Bson regBson = regex("results.formatted_address", address);
        //add Bson to search
        FindIterable<Document> documents = collection.find(regBson);
        //to json (string)


        StringBuilder sb = new StringBuilder();
//        sb.append("[");
        for(Document document : documents) {
            sb.append(document.toJson() + ",");
        }
//        sb.append("]");
        JSONObject jsonObj = new JSONObject(sb.toString());

        jsonObj.put("status", "ok");
        jsonObj.put("length", sb);
//        jsonObj.put("devices", noPlateNumberCarForm.getDevicesId());

        return jsonObj;
    }

}
