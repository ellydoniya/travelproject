package com.web.trip.model;

public class TravelBookingDTO {
	
	int booking_num;
	int prod_num;
	String id;
	String member_email;
	int booking_person;
	String booking_date;
	int booking_price;
	int booking_check;
	
	public int getBooking_num() {
		return booking_num;
	}
	public void setBooking_num(int booking_num) {
		this.booking_num = booking_num;
	}
	public int getProd_num() {
		return prod_num;
	}
	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public int getBooking_person() {
		return booking_person;
	}
	public void setBooking_person(int booking_person) {
		this.booking_person = booking_person;
	}
	public String getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}
	public int getBooking_price() {
		return booking_price;
	}
	public void setBooking_price(int booking_price) {
		this.booking_price = booking_price;
	}
	public int getBooking_check() {
		return booking_check;
	}
	public void setBooking_check(int booking_check) {
		this.booking_check = booking_check;
	}
	
}
