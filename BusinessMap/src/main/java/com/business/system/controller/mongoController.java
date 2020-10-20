package com.business.system.controller;

import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.business.system.entity.Industry;
//import com.mongodb.client.result.DeleteResult;
//import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public class mongoController {
    @Autowired
    MongoTemplate mongoTemplate;

    MongoCollection collection;



    @RequestMapping("/query")
    public String query() {

        MongoCollection<Document> collection = mongoTemplate.getCollection("cafe");
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while(mongoCursor.hasNext()){
            System.out.println(mongoCursor.next());
        }
//        Query query = Query.query(Criteria.where("results.types").is("cafe"));
//        List<Industry> industryList = mongoTemplate.find(query, Industry.class);
//        return industryList.size() + "";
        return "sccuess";
    }
}
