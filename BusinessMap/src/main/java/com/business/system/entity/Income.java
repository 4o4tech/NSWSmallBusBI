package com.business.system.entity;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "population")
public class Income {

//    { "Year" : 2014, "LGA_Name" : "New South Wales", "Median_income" : 45697 }

    @Field("Year")
    private Integer Year;
    @Field("LGA_Name")
    private String LGA_Name;
    @Field("Median_Income")
    private Integer Median_Income;

    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer Year) {
        this.Year = Year;
    }

    public String getLGA_Name() {
        return LGA_Name;
    }

    public void setLGA_Name(String LGA_Name) {
        this.LGA_Name = LGA_Name;
    }

    public Integer getMedian_Income() {
        return Median_Income;
    }

    public void setMedian_Income(Integer Median_Income) {
        this.Median_Income = Median_Income;
    }
}
