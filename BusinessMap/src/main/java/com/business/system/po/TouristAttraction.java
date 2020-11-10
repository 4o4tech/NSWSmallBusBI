package com.business.system.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Document(collection = "tourist_attraction")
public class TouristAttraction implements Serializable{
	//声明实体类字段
	@Id
	private String id;

	//声明字段的 get 和 set 方法
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
