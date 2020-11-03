package com.business.system.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "population")
public class population {

//    {
//        "Year" :2014,
//            "LGA_Name" :"Parramatta (C)",
//            "Males" :111448,
//            "Females" :109659,
//            "Person" :221107,
//            "Density" :""
//
//
//    }

//    @Id
//    private String id;
    @Field("Year")
    private Integer Year;
    @Field("LGA_Name")
    private String LGA_Name;
    @Field("Males")
    private Integer Males;
    @Field("Females")
    private Integer Females;
    @Field("Person")
    private Integer Person;
    @Field("Density")
    private Integer Density;

    public population(Integer Year, String LGA_Name, Integer Males, Integer Females, Integer Person,Integer Density ){

        this.Year = Year;
        this.LGA_Name = LGA_Name;
        this.Males = Males;
        this.Females = Females;
        this.Person = Person;
        this.Density = Density;
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

    public Integer getMales() {
        return Males;
    }

    public void setMales(Integer males) {
        Males = males;
    }

    public Integer getFemales() {
        return Females;
    }

    public void setFemales(Integer females) {
        Females = females;
    }

    public Integer getPerson() {
        return Person;
    }

    public void setPerson(Integer person) {
        Person = person;
    }

    public Integer getDensity() {
        return Density;
    }

    public void setDensity(Integer density) {
        Density = density;
    }







}
