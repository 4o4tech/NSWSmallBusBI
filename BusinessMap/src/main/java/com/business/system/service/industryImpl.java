package com.business.system.service;

import com.business.system.entity.Industry;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

import static com.mongodb.client.model.Filters.regex;

@Component
public class industryImpl implements IndustryRepository {
    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public Industry findbyName(String name) {

//        Criteria criteria = new Criteria();
//        criteria.where("dataset").is("d1");
//        Query query = new Query();
//        query.addCriteria(criteria);
//
        MongoCollection<Document> collection = mongoTemplate.getCollection(name);


//        Query query = new Query(Criteria.where("name").is(name));
//        Industry industryResult  = mongoTemplate.getCollection(name,Industry.class);
        Industry industry = new Industry();
        industry.setIndustryData(collection.toString());
        return industry;
    }


}
