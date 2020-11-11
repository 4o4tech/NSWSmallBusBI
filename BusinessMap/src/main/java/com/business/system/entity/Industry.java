package com.business.system.entity;

//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.MongoTemplate;

public class Industry{
    private String name;
    private String postCode;
    private String result;
    private String industryData;




    public String getName() {
        return name;
    }

    public void setName(String industryName) {
        this.name = industryName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String content) {
        this.result = result;
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
