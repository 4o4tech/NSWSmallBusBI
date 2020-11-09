package com.business.system.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document(collection = "businessEntries")
public class businessEntries {

//    {
//        "Year" : 2017,
//            "LGA_Name" : "Albury (C)",
//            "zero_employee" : 353,
//            "one_to_4" : 154,
//            "five_to_20" : 19,
//            "more_than_20" : "",
//            "total" : 524
//    }


    @Field("LGA_Name")
    private String LGA_Name;
    @Field("zero_employee")
    private int Zero_employee;
    @Field("one_to_4")
    private int One_to_4;
    @Field("five_to_20")
    private int Five_to_20;
    @Field("more_than_20")
    private int More_than_20;
    @Field("total")
    private int Total;

    public String getLGA_Name() {
        return LGA_Name;
    }

    public int getFive_to_20() {
        return Five_to_20;
    }

    public int getMore_than_20() {
        return More_than_20;
    }

    public int getOne_to_4() {
        return One_to_4;
    }

    public int getTotal() {
        return Total;
    }

    public int getZero_employee() {
        return Zero_employee;
    }

    public void setLGA_Name(String LGA_Name) {
        this.LGA_Name = LGA_Name;
    }

    public void setFive_to_20(int five_to_20) {
        Five_to_20 = five_to_20;
    }

    public void setOne_to_4(int one_to_4) {
        One_to_4 = one_to_4;
    }

    public void setMore_than_20(int more_than_20) {
        More_than_20 = more_than_20;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public void setZero_employee(int zero_employee) {
        Zero_employee = zero_employee;
    }
}
