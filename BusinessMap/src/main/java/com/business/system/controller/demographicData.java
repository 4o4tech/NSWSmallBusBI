package com.business.system.controller;

import com.business.system.entity.Income;
import com.business.system.entity.population;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;


@RestController
public class demographicData {
    @Resource
    private MongoTemplate mongoTemplate;
    static String setName;

    // 人口数量

    @RequestMapping("/population")
    public List<population> getPopulationData(@RequestParam(value="code") Integer postCode) {


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
        setName = getLGAName.get(0);


//       db.population.aggregate([
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
                Aggregation.match(Criteria.where("LGA_Name").is(setName)),
                Aggregation.match(Criteria.where("Year").gte(2014).lte(2018)),
                Aggregation.project("Year", "LGA_Name")
                        .and("Males - Total (no)").as("Males")
                        .and("Females - Total (no)").as("Females")
                        .and("Persons - Total (no)").as("Person")
                        .and("Population density (persons/km2)").as("Density")
        );

        AggregationResults<population> output = mongoTemplate.aggregate(agg, "population",population.class);
//        System.out.println(output.getMappedResults());

        List<population> resultList = output.getMappedResults();

        return resultList;
    }



    @RequestMapping("/income")
    public List<Income> getIncomeData() {


//        db.income.aggregate([
//                {$match:{LGA_Name:"New South Wales"}},
//        {$project:{
//            _id:0,
//                    Year:1,
//                    LGA_Name:"$LGA_Name",
//                    Median_income:"$Median total income (excl Government pensions and allowances) ($)",
//        }}
//        ])

        // New South Wales AVG
//        Aggregation nswIncomeAgg = Aggregation.newAggregation(
//                Aggregation.match(Criteria.where("LGA_Name").is("New South Wales")),
//                Aggregation.project("Year", "LGA_Name")
//                        .and("Median_Total_Income").as("Median_Income")
//        );
//
//        AggregationResults<Income>  nswOutput = mongoTemplate.aggregate(nswIncomeAgg, "income",Income.class);
//
//        List<Income> nswResultList = nswOutput.getMappedResults();

        Criteria newCri = new Criteria();

        // search area
        Aggregation incomeAgg = Aggregation.newAggregation(
                Aggregation.match(newCri.orOperator(Criteria.where("LGA_Name").is(setName), Criteria.where("LGA_Name").is("New South Wales"))), //"$or" : [ { "LGA_Name" : "Parramatta (C)"} , { "LGA_Name" : "New South Wales"}]}}
                Aggregation.match(Criteria.where("Year").gte(2014).lte(2017)),  //{ "$match" : { "Year" : { "$gte" : 2014 , "$lte" : 2017}}}
                Aggregation.project("Year", "LGA_Name")
                            .and("Median_Total_Income").as("Median_Income")

        );

        AggregationResults<Income> output = mongoTemplate.aggregate(incomeAgg, "income",Income.class);
//        System.out.println(output.getMappedResults());

        List<Income> resultList = output.getMappedResults();


//        resultList.addAll(nswResultList);


        return resultList;
    }

}
