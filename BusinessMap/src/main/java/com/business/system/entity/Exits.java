package com.business.system.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;


@Document(collection = "economy")
public class Exits {
	
	/*
	 * { "Year" : 2017, 
	 * "LGA_Name" : "Albury (C)",
	 *  "zero_employee" : 353, 
	 *  "one_to_4": 154, 
	 *  "five_to_20" : 19,
	 *   "more_than_20" : "",
	 *    "total" : 524 }
	 */
	
	  @Id
//    private String id;
    @Field("Year")
    private Integer Year;
    @Field("LGA_Name")
    private String LGA_Name;
    @Field("zero_employee")
    private Integer Zero_employee;
    @Field("one_to_4")
    private Integer One_to_4;
    @Field("five_to_20")
    private Integer Five_to_20;
    @Field("more_than_20")
    private Integer More_than_20;
    @Field("total")
    private Integer Total;

    public Exits(Integer Year, String LGA_Name, Integer Zero_employee, Integer One_to_4, Integer Five_to_20,Integer More_than_20, Integer Total ){

        this.Year = Year;
        this.LGA_Name = LGA_Name;
        this.Zero_employee = Zero_employee;
        this.One_to_4 = One_to_4;
        this.Five_to_20 = Five_to_20;
        this.More_than_20 = More_than_20;
        this.Total = Total;
    }


    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer year) {
        Year = year;
    }


    public String getLGA_Name() {
        return LGA_Name;
    }

    public void setLGA_Name(String LGA_Name) {
        this.LGA_Name = LGA_Name;
    }

    public Integer getZero_employee() {
        return Zero_employee;
    }
    

    public void setZero_employee(Integer males) {
    	Zero_employee = males;
    }

    public Integer getOne_to_4() {
        return One_to_4;
    }

    public void setOne_to_4(Integer females) {
    	One_to_4 = females;
    }

    public Integer getFive_to_20() {
        return Five_to_20;
    }

    public void setFive_to_20(Integer person) {
    	Five_to_20 = person;
    }

    public Integer getMore_than_20() {
        return More_than_20;
    }

    public void setMore_than_20(Integer density) {
    	More_than_20 = density;
    }
    
    public Integer getTotal() {
        return Total;
    }

    public void setTotal(Integer density) {
    	Total = density;
    }






}
