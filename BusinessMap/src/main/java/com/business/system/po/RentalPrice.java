package com.business.system.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;


@Document(collection = "rental_price")
public class RentalPrice implements Serializable{
	//声明实体类字段
	@Id
	private String id;
	@Field("suburb")
	private String suburb;
	@Field("postcode")
	private Integer postcode;
	@Field("dwelling_type")
	private String dwellingType;
	@Field("date")
	private String date;
	@Field("price_value")
	private Integer priceValue;

	//创建构造方法
	public RentalPrice(String suburb, Integer postcode, String dwellingType, String date, Integer priceValue) {
		this.suburb = suburb;
		this.postcode = postcode;
		this.dwellingType = dwellingType;
		this.date = date;
		this.priceValue = priceValue;
	}

	//声明字段的 get 和 set 方法
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public Integer getPostcode() {
		return postcode;
	}

	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}

	public String getDwellingType() {
		return dwellingType;
	}

	public void setDwellingType(String dwellingType) {
		this.dwellingType = dwellingType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getPriceValue() {
		return priceValue;
	}

	public void setPriceValue(Integer priceValue) {
		this.priceValue = priceValue;
	}
}
