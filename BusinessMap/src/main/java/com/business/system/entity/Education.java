package com.business.system.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "health_disability")
public class Education {

 /*
 education-----------------------
{
        "LGA_Name" : "Albury (C)",
        "non_school" : 59.2,
        "post_Grad" : 2.5,
        "Grad" : 2,
        "bachelor" : 11.3,
        "advanced" : 8.5,
        "certificate" : 23.8,
        "non_school_inadequate" : 11
}

  */

//    private String id;
    @Field("Year")
    private Integer Year;
    @Field("LGA_Name")
    private String LGA_Name;
    @Field("non_school")
    private Float Non_school;
    @Field("post_grad")
    private Float Post_Grad;
    @Field("grad")
    private Float Grad;
    @Field("bachelor")
    private Float Bachelor;
    @Field("advanced")
    private Float Advanced;
    @Field("certificate")
    private Float Certificate;
    @Field("non_school_inadequate")
    private Float Non_school_inadequate;


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

    public Float getNon_school() {
        return Non_school;
    }


    public void setNon_school(Float males) {
        Non_school = males;
    }

    public Float getPost_Grad() {
        return Post_Grad;
    }

    public void setPost_Grad(Float females) {
        Post_Grad = females;
    }

    public Float getGrad() {
        return Grad;
    }
    public void setGrad(Float person) {
        Grad = person;
    }

    public Float getBachelor() {
        return Bachelor;
    }

    public void setBachelor(Float density) {
        Bachelor = density;
    }

    public Float getAdvanced() {
        return Advanced;
    }

    public void setAdvanced(Float density) {
        Advanced = density;
    }

    public Float getCertificate() {
        return Certificate;
    }

    public void setCertificate(Float density) {
        Certificate = density;
    }

    public Float getNon_school_inadequate() {
        return Non_school_inadequate;
    }

    public void setNon_school_inadequate(Float density) {
        Non_school_inadequate = density;
    }


}
