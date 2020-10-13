package com.business.system.entity;

import javafx.application.Application;
import javafx.stage.Stage;

public class Industry{



    private String industryName;
    private String content;
    private String industryData;

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

}
