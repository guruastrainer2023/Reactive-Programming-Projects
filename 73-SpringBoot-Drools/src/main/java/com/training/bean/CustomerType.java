package com.training.bean;

public enum CustomerType {
	
	LOYAL, NEW, DISSATISFIED;
	 
    public String getValue() {
        return this.toString();
    }

}
