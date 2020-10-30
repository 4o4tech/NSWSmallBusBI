package com.business.system.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;


@Document(collection = "train_station_timetable")
public class TrainStationTimetable implements Serializable{
	//声明实体类字段
	@Id
	private String id;
	@Field("suburb")
	private String suburb;
	@Field("postcode")
	private Integer postcode;
	@Field("year")
	private Integer year;
	@Field("duration_time")
	private String durationTime;
	@Field("entry_number")
	private Integer entryNumber;
	@Field("exit_number")
	private Integer exitNumber;

	//创建构造方法
	public TrainStationTimetable(String suburb, Integer postcode,Integer year,String durationTime,Integer entryNumber,Integer exitNumber) {
		this.suburb = suburb;
		this.postcode = postcode;
		this.year = year;
		this.durationTime = durationTime;
		this.entryNumber = entryNumber;
		this.exitNumber = exitNumber;
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getDurationTime() {
		return durationTime;
	}

	public void setDurationTime(String durationTime) {
		this.durationTime = durationTime;
	}

	public Integer getEntryNumber() {
		return entryNumber;
	}

	public void setEntryNumber(Integer entryNumber) {
		this.entryNumber = entryNumber;
	}

	public Integer getExitNumber() {
		return exitNumber;
	}

	public void setExitNumber(Integer exitNumber) {
		this.exitNumber = exitNumber;
	}
}
