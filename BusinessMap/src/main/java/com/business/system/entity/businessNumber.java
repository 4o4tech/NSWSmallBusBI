package com.business.system.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document(collection = "economy")
public class businessNumber {

//    {
//        "LGA_Name" : "Albury (C)",
//            "support1" : 3427,
//            "support2" : 628,
//            "support3" : 437,
//            "number0" : 4617,
//            "number1" : 1190,
//            "number2" : 562,
//            "number3" : 125
//    }

    @Field("LGA_Name")
    private String LGA_Name;
    @Field("Total_number")
    private int Total_number;
    @Field("Employ_1_4")
    private int Employ_1_4;
    @Field("Employ_5_19")
    private int Employ_5_19;
    @Field("Employ_20_more")
    private int Employ_20_more;


    public String getLGA_Name() {
        return LGA_Name;
    }
    public void setLGA_Name(String LGA_Name) {
        this.LGA_Name = LGA_Name;
    }

    public int getEmploy_1_4() {
        return Employ_1_4;
    }

    public void setEmploy_1_4(int employ_1_4) {
        Employ_1_4 = employ_1_4;
    }

    public int getEmploy_5_19() {
        return Employ_5_19;
    }

    public void setEmploy_5_19(int employ_5_19) {
        Employ_5_19 = employ_5_19;
    }

    public int getEmploy_20_more() {
        return Employ_20_more;
    }

    public void setEmploy_20_more(int employ_20_more) {
        Employ_20_more = employ_20_more;
    }

    public int getTotal_number() {
        return Total_number;
    }

    public void setTotal_number(int total_number) {
        Total_number = total_number;
    }
}
