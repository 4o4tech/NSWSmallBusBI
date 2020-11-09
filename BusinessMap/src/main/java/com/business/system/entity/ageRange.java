package com.business.system.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ageRange")
public class ageRange {


//    { "LGA_Name" : "Albury (C)", "zero_to_19" : 13764, "twenty_to_39" : 14068, "fourty_to_59" : 13230, "sixty_to_79" : 10116, "eighty_over" : 2589 }

    @Field("LGA_Name")
    private String LGA_Name;
    @Field("zero_to_19")
    private int Age_0_19;
    @Field("twenty_to_39")
    private int Age_20_39;
    @Field("fourty_to_59")
    private int Age_40_59;
    @Field("sixty_to_79")
    private int Age_60_79;
    @Field("eighty_over")
    private int Age_80_over;


    public String getLGA_Name() {
        return this.LGA_Name;
    }

    public void setLGA_Name(String LGA_Name) {
        this.LGA_Name = LGA_Name;
    }

    public int getAge_0_19() {
        return Age_0_19;
    }

    public void setAge_0_19(int age_0_19) {
        Age_0_19 = age_0_19;
    }

    public int getAge_20_39() {
        return Age_20_39;
    }

    public void setAge_20_39(int age_20_39) {
        Age_20_39 = age_20_39;
    }

    public int getAge_40_59() {
        return Age_40_59;
    }

    public void setAge_40_59(int age_40_59) {
        Age_40_59 = age_40_59;
    }

    public int getAge_60_79() {
        return Age_60_79;
    }

    public void setAge_60_79(int age_60_79) {
        Age_60_79 = age_60_79;
    }

    public int getAge_80_over() {
        return Age_80_over;
    }

    public void setAge_80_over(int age_80_over) {
        Age_80_over = age_80_over;
    }
}
