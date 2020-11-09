package com.business.system.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document(collection = "businessNumber")
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
    @Field("support1")
    private int support1;
    @Field("support2")
    private int support2;
    @Field("support3")
    private int support3;
    @Field("number0")
    private int number0;
    @Field("number1")
    private int number1;
    @Field("number2")
    private int number2;
    @Field("number3")
    private int number3;


    public String getLGA_Name() {
        return LGA_Name;
    }

    public int getSupport1() {
        return support1;
    }

    public int getSupport2() {
        return support2;
    }

    public int getSupport3() {
        return support3;
    }

    public int getNumber0() {
        return number0;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public int getNumber3() {
        return number3;
    }

    public void setLGA_Name(String LGA_Name) {
        this.LGA_Name = LGA_Name;
    }

    public void setSupport1(int support1) {
        this.support1 = support1;
    }

    public void setSupport2(int support2) {
        this.support2 = support2;
    }

    public void setSupport3(int support3) {
        this.support3 = support3;
    }

    public void setNumber0(int number0) {
        this.number0 = number0;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public void setNumber3(int number3) {
        this.number3 = number3;
    }
}
