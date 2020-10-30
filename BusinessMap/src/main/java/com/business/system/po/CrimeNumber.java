package com.business.system.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;


@Document(collection = "crime_number")
public class CrimeNumber implements Serializable{
	//声明实体类字段
	@Id
	private String id;
	@Field("suburb")
	private String suburb;
	@Field("postcode")
	private Integer postcode;
	@Field("month")
	private String month;
	@Field("num")
	private Integer num;

	//创建构造方法
	public CrimeNumber(String suburb, Integer postcode, String month, Integer num) {
		this.suburb = suburb;
		this.postcode = postcode;
		this.month = month;
		this.num = num;
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

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
}
