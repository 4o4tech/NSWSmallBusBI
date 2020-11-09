package com.business.system.controller;

import cn.hutool.json.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;

import static com.mongodb.client.model.Filters.regex;

@RestController
public class LGAController {

//
//    sb_total = db[collectiton_name].count()
//    total_post = 633
//    print(sb_total)
//    print("cafe number in this postal area:" + sb_local)
//    print("Average per postal area:" + sb_total/total_post)

    @Resource
    private MongoTemplate mongoTemplate;

    //    @ResponseBody
    @RequestMapping("/getAvgIndustry/{name}")
    public Map<String, Long> avgIndustryLGA(@PathVariable String name, @RequestParam(value = "code") String address) {

        if (name == null || name == "") {
            name = "cafe"; // setDefault result
        }
//        else{
//            name.replaceAll("\\s*", "_");
//        }

        name = name.toLowerCase();
        System.out.println("Collection:  " + name);
        MongoCollection<Document> collection = mongoTemplate.getCollection(name);

        if (address == null || address == "") {
            address = "2000"; // setDefault result
        }
//      Bson regBson = regex("results.formatted_address", "NSW " +address);// to remove address number
        Bson regBson = regex("results.formatted_address", address);
        //add Bson to search
        Long localAmount = collection.countDocuments(regBson);
        Long totalAmount =collection.countDocuments();
        long avgIndustry = totalAmount/633L;

        HashMap<String, Long> hmap = new HashMap<>();
        hmap.put("localAmount", localAmount);
        hmap.put("totalAmount", totalAmount);
        hmap.put("avgIndustry", avgIndustry );

        return hmap;

    }
}
