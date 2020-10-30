package com.business.system.po;

import org.springframework.data.annotation.Id;

import java.io.Serializable;



public class Picture implements Serializable{
	@Id
	private String id;
	private String address;
	private String name;
	
	public Picture(){}
	
	

	public Picture(String address, String name) {
		this.address = address;
		this.name = name;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Picture [id=" + id + ", address=" + address + ", name=" + name + "]";
	}

	
}
