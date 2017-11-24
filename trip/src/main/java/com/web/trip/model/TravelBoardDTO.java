package com.web.trip.model;

public class TravelBoardDTO {
	private int board_num;
	private String member_id;
	private String board_title;
	private String board_text;
	private String board_org_img;
	private String board_str_img;
	private String board_reg_date;
	private int board_readcount;
	private int board_likecount;
	private int prod_num;
	private int prod_score;

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
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

	public String getBoard_org_img() {
		return board_org_img;
	}

	public void setBoard_org_img(String board_org_img) {
		this.board_org_img = board_org_img;
	}

	public String getBoard_str_img() {
		return board_str_img;
	}

	public void setBoard_str_img(String board_str_img) {
		this.board_str_img = board_str_img;
	}

	public String getBoard_reg_date() {
		return board_reg_date;
	}

	public void setBoard_reg_date(String board_reg_date) {
		this.board_reg_date = board_reg_date;
	}

	public int getBoard_readcount() {
		return board_readcount;
	}

	public void setBoard_readcount(int board_readcount) {
		this.board_readcount = board_readcount;
	}

	public int getBoard_likecount() {
		return board_likecount;
	}

	public void setBoard_likecount(int board_likecount) {
		this.board_likecount = board_likecount;
	}

	public int getProd_num() {
		return prod_num;
	}

	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}

	public int getProd_score() {
		return prod_score;
	}

	public void setProd_score(int prod_score) {
		this.prod_score = prod_score;
	}

}
