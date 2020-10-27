package com.business.system.entity;

import lombok.Data;

@Data
public class industryCount {
    private String name;
    private int count;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
