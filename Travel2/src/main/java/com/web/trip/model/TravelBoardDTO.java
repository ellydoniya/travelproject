package com.web.trip.model;

public class TravelBoardDTO {
	
	int board_num;
	String id;
	String board_title;
	String board_text;
	String board_ong_img;
	String board_sub_img;
	String reg_date;
	int readcount;
	int likecount;
	int prod_num;
	int Prod_score;
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_text() {
		return board_text;
	}
	public void setBoard_text(String board_text) {
		this.board_text = board_text;
	}
	public String getBoard_ong_img() {
		return board_ong_img;
	}
	public void setBoard_ong_img(String board_ong_img) {
		this.board_ong_img = board_ong_img;
	}
	public String getBoard_sub_img() {
		return board_sub_img;
	}
	public void setBoard_sub_img(String board_sub_img) {
		this.board_sub_img = board_sub_img;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getLikecount() {
		return likecount;
	}
	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}
	public int getProd_num() {
		return prod_num;
	}
	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}
	public int getProd_score() {
		return Prod_score;
	}
	public void setProd_score(int prod_score) {
		Prod_score = prod_score;
	}
	
}
