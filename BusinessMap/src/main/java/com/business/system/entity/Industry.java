package com.business.system.entity;

import javafx.application.Application;
import javafx.stage.Stage;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.MongoTemplate;

@Document(collection = "industry")
public class Industry{

   private String industryName;
   private String content;
   private String industryData;

   private String postCode;



    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getIndustryData( ){
        return industryData;
    }

    public void setIndustryData(String industryData) {
        this.industryData = industryData;
    }

    // public Stirng getPostCode(){
    //     return postCode;
    // }

    // public void setPostCode(String postCode){
    //     this.postCode = postCode;
    // }

    

}
