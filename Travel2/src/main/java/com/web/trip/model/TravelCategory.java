package com.web.trip.model;

public class TravelCategory {
	int tCate_num;
	String state;
	String city;
	public int gettCate_num() {
		return tCate_num;
	}
	public void settCate_num(int tCate_num) {
		this.tCate_num = tCate_num;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
