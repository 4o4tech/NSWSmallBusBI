package com.business.system.controller;


import cn.hutool.json.JSONObject;
import com.business.system.entity.Industry;
import com.business.system.entity.hottestIndustry;
import com.business.system.entity.industryCount;
import com.business.system.entity.population;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


import java.util.*;

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
    public List<industryCount>  getHottestIndustry() {

        Query sortQuery = new Query();
        sortQuery.with(new Sort(Sort.Direction.DESC, "count"));

//        db.industryCount.find().sort({count: -1}).limit(10)
        List<industryCount> topIndustry = mongoTemplate
                .find(sortQuery.limit(10), industryCount.class);

        return topIndustry;
    }


/* move to denographicData.java


    // 人口数量

    @RequestMapping("/population")
    public  List<population>   getPopulationData(@RequestParam(value="code") Integer postCode) {


        //var name = db.LGA_postcode.find({POSTCODE:2127}).next().LGA_NAME
        Query query = new Query();
        CriteriaDefinition criteriaDefinition = Criteria.where("POSTCODE").is(postCode);
        query.addCriteria(criteriaDefinition);


        MongoCollection<Document> collection = mongoTemplate.getCollection("LGA_postcode");


        Bson eqBson = eq("POSTCODE",postCode);
        BasicDBObject fieldsObject = new BasicDBObject();
        fieldsObject.put("LGA_NAME", 1);

        FindIterable<Document> documents = collection.find(eqBson).projection(Document.parse(fieldsObject.toString()));
        List<String> getLGAName = new ArrayList<>();
        // Print the name from the list....
        for(Document document : documents) {
            String result = (String) document.get("LGA_NAME");
            getLGAName.add(result);
        }

        System.out.println("LGA Name is: " + getLGAName.get(0));


        String getName = getLGAName.get(0);


//        population = db.population.aggregate([
//                {$match:{LGA_Name:name}},
//        {$project:{
//            _id:0,
//                    Year:1,
//                    LGA_Name:"$LGA_Name",
//                    Males:"$Males - Total (no)",
//                    Females:"$Females - Total (no)",
//                    Person:"$Persons - Total (no)",
//                    Density:"$Population density (persons/km2)"
//        }}
//])




        Aggregation agg = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("LGA_Name").is(getName)),
                Aggregation.project("Year", "$LGA_Name")
                        .and("Males - Total (no)").as("Males")
                        .and("Females - Total (no)").as("Females")
                        .and("Persons - Total (no)").as("Person")
                        .and("Population density (persons/km2)").as("Density")
        );


//        mongoTemplate.aggregate(agg,"population", BasicDBObject.class);

        AggregationResults<population> output = mongoTemplate.aggregate(agg, "population",population.class);


        System.out.println(output.getMappedResults());

        List<population> resultList = output.getMappedResults();



        return resultList;
    }
*/




}
