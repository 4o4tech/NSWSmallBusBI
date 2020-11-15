package com.business.system.controller;

import com.business.system.entity.*;
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
    private String LGAName;


    public void setLGAName(String LGAName) {
        this.LGAName = LGAName;
    }

    public String getLGAName() {
        return LGAName;
    }



    // 人口数量

    @RequestMapping("/population")
    public List<population> getPopulationData(@RequestParam(value = "code") Integer postCode) {


        //var name = db.LGA_postcode.find({POSTCODE:2127}).next().LGA_NAME
        Query query = new Query();
        CriteriaDefinition criteriaDefinition = Criteria.where("POSTCODE").is(postCode);
        query.addCriteria(criteriaDefinition);


        MongoCollection<Document> collection = mongoTemplate.getCollection("LGA_postcode");


        Bson eqBson = eq("POSTCODE", postCode);
        BasicDBObject fieldsObject = new BasicDBObject();
        fieldsObject.put("LGA_NAME", 1);

        FindIterable<Document> documents = collection.find(eqBson).projection(Document.parse(fieldsObject.toString()));
        List<String> getLGAName = new ArrayList<>();
        // Print the name from the list....
        for (Document document : documents) {
            String result = (String) document.get("LGA_NAME");
            getLGAName.add(result);
        }

        System.out.println("LGA Name is: " + getLGAName.get(0));
        this.setName = getLGAName.get(0);

        setLGAName(getLGAName.get(0));


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

        AggregationResults<population> output = mongoTemplate.aggregate(agg, "population", population.class);
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



        String newLGAName;
        newLGAName = getLGAName();

        Criteria newCri = Criteria.where("LGA_Name").is(newLGAName);
        Criteria newCriNSW = Criteria.where("LGA_Name").is("New South Wales");

        // search area
        Aggregation incomeAgg = Aggregation.newAggregation(
                Aggregation.match(new Criteria().orOperator(newCri, newCriNSW)), //"$or" : [ { "LGA_Name" : "Parramatta (C)"} , { "LGA_Name" : "New South Wales"}]}}
                Aggregation.match(Criteria.where("Year").gte(2014).lte(2017)),  //{ "$match" : { "Year" : { "$gte" : 2014 , "$lte" : 2017}}}
                Aggregation.project("Year", "LGA_Name")
                        .and("Median_Total_Income").as("Median_Income")

        );

        AggregationResults<Income> output = mongoTemplate.aggregate(incomeAgg, "income", Income.class);
//        System.out.println(output.getMappedResults());

        List<Income> resultList = output.getMappedResults();


//        resultList.addAll(nswResultList);


        return resultList;
    }


    // age range fetch mongo data

    @RequestMapping("/ageRange")
    public List<ageRange> getAgeRangeData() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Criteria newCri = new Criteria();

        // search area
        String newLGAName;
        newLGAName = getLGAName();
        Aggregation ageRangeAgg = Aggregation.newAggregation(
                Aggregation.match(newCri.orOperator(Criteria.where("LGA_Name").is(newLGAName))),
                //"$or" : [ { "LGA_Name" : "Parramatta (C)"} , { "LGA_Name" : "New South Wales"}]}}
                Aggregation.match(Criteria.where("Year").gte(2018).lte(2018)),
                Aggregation.project("Year", "LGA_Name")
                        .and("zero_to_19").as("zero_to_19")
                        .and("twenty_to_39").as("twenty_to_39")
                        .and("fourty_to_59").as("fourty_to_59")
                        .and("sixty_to_79").as("sixty_to_79")
                        .and("eighty_over").as("eighty_over")

        );

        AggregationResults<ageRange> output = mongoTemplate.aggregate(ageRangeAgg, "population", ageRange.class);

        List<ageRange> resultList = output.getMappedResults();

        return resultList;
    }

    // business Number fetch mongo data
    @RequestMapping("/businessNumber")
    public List<businessNumber> getBusinessNumberData() {

        Criteria newCri = new Criteria();

        // search area
        Aggregation businessNumberAgg = Aggregation.newAggregation(
                Aggregation.match(newCri.orOperator(Criteria.where("LGA_Name").is(setName))), //"$or" : [ { "LGA_Name" : "Parramatta (C)"} , { "LGA_Name" : "New South Wales"}]}}
                Aggregation.match(Criteria.where("Year").gte(2019).lte(2019)),  //{ "$match" : { "Year" : { "$gte" : 2014 , "$lte" : 2017}}}
                Aggregation.project("Year", "LGA_Name")
                        .and("Number of employing businesses: 1-4 employees (no)").as("Employ_1_4")
                        .and("Number of employing businesses: 5-19 employees (no)").as("Employ_5_19")
                        .and("Number of employing businesses: 20 or more employees (no)").as("Employ_20_more")
                        .and("Total number of businesses (no)").as("Total_number")

        );

        AggregationResults<businessNumber> output = mongoTemplate.aggregate(businessNumberAgg, "economy", businessNumber.class);

        List<businessNumber> resultList = output.getMappedResults();

        return resultList;
    }

    //    Business Entries  fetch mongo data
    @RequestMapping("/businessEntries")
    public List<businessEntries> getBusinessEntriesData() {

        Criteria newCri = new Criteria();

        // search area
        Aggregation businessEntriesAgg = Aggregation.newAggregation(
                Aggregation.match(newCri.orOperator(Criteria.where("LGA_Name").is(setName))), //"$or" : [ { "LGA_Name" : "Parramatta (C)"} , { "LGA_Name" : "New South Wales"}]}}
                Aggregation.match(Criteria.where("Year").gte(2016).lte(2019)),  //{ "$match" : { "Year" : { "$gte" : 2014 , "$lte" : 2017}}}
                Aggregation.project("Year", "LGA_Name")
                        .and("Number of non employing business entries (no)").as("zero_employee")
                        .and("Number of employing business entries: 1-4 employees (no)").as("one_to_4")
                        .and("Number of employing business entries: 5-19 employees (no)").as("five_to_20")
                        .and("Number of employing business entries: 20 or more employees (no)").as("more_than_20")
                        .and("Total number of business entries (no)").as("total")

        );

        AggregationResults<businessEntries> output = mongoTemplate.aggregate(businessEntriesAgg, "economy", businessEntries.class);

        List<businessEntries> resultList = output.getMappedResults();

        return resultList;
    }

    //    Business Exits  fetch mongo data
    @RequestMapping("/exits")
    public List<Exits> getExitsData(){

        Criteria newCri = new Criteria();

        Aggregation BusinessExits = Aggregation.newAggregation(
                Aggregation.match(newCri.orOperator(Criteria.where("LGA_Name").is(setName))),
                Aggregation.match(Criteria.where("Year").gte(2016).lte(2019)),
                Aggregation.project("Year", "LGA_Name")
                        .and("Number of non employing business exits (no)").as("zero_employee")
                        .and("Number of employing business exits: 1-4 employees (no)").as("one_to_4")
                        .and("Number of employing business exits: 5-19 employees (no)").as("five_to_20")
                        .and("Number of employing business exits: 20 or more employees (no)").as("more_than_20")
                        .and("Number of employing business exits: 20 or more employees (no)").as("total")
        );

        AggregationResults<Exits> output = mongoTemplate.aggregate(BusinessExits,"economy", Exits.class);

        List<Exits> resultList = output.getMappedResults();

        return resultList;
    }
    //    education  fetch mongo data
    @RequestMapping("/education")
    public List<Education> getEducationata(){

        Criteria newCri = new Criteria();

        Aggregation education = Aggregation.newAggregation(
                Aggregation.match(newCri.orOperator(Criteria.where("LGA_Name").is(setName))),
                Aggregation.match(Criteria.where("Year").is(2016)),
                Aggregation.project("Year", "LGA_Name")
                        .and("Non-School Qualifications (%)").as("non_school")
                        .and("Postgraduate Degree (%)").as("post_grad")
                        .and("Graduate Diploma/Graduate Certificate (%)").as("grad")
                        .and("Bachelor Degree (%)").as("bachelor")
                        .and("Advanced Diploma/Diploma (%)").as("advanced")
                        .and("Certificate (%)").as("certificate")
                        .and("Non-School Qualifications - Inadequately described (%)").as("non_school_inadequate")
        );

        AggregationResults<Education> output = mongoTemplate.aggregate(education,"health_disability", Education.class);

        List<Education> resultList = output.getMappedResults();

        return resultList;
    }




}
