package com.web.trip.model;

public class TravelBoardDTO {
	private int board_num;
	private String member_id;
	private String board_title;
	private String board_content;
	private int board_img;
	private String board_reg_date;
	private int board_readcount;
	private int board_likecount;
	private int prod_num;
	private int pack_num;
	private int prod_score;
	private int pack_score;

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

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public int getBoard_img() {
		return board_img;
	}

	public void setBoard_img(int board_img) {
		this.board_img = board_img;
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

	public int getPack_num() {
		return pack_num;
	}

	public void setPack_num(int pack_num) {
		this.pack_num = pack_num;
	}

	public int getProd_score() {
		return prod_score;
	}

	public void setProd_score(int prod_score) {
		this.prod_score = prod_score;
	}

	public int getPack_score() {
		return pack_score;
	}

	public void setPack_score(int pack_score) {
		this.pack_score = pack_score;
	}

}
