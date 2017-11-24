package com.web.trip.model;

public class CommentDTO {
	int comment_num;
	int board_num;
	String id;
	String comment_text;
	String comment_reg_date;
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
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
	public String getComment_text() {
		return comment_text;
	}
	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}
	public String getComment_reg_date() {
		return comment_reg_date;
	}
	public void setComment_reg_date(String comment_reg_date) {
		this.comment_reg_date = comment_reg_date;
	}
	
}
