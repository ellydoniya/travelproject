package com.web.trip.model;

public class CommentDTO {
	private int board_num;
	private String member_id;
	private int comment_num;
	private String comment_content;
	private String comment_reg_date;
	private int comment_parent;
	private int comment_depth;
	private int comment_order;

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

	public int getComment_num() {
		return comment_num;
	}

	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public String getComment_reg_date() {
		return comment_reg_date;
	}

	public void setComment_reg_date(String comment_reg_date) {
		this.comment_reg_date = comment_reg_date;
	}

	public int getComment_parent() {
		return comment_parent;
	}

	public void setComment_parent(int comment_parent) {
		this.comment_parent = comment_parent;
	}

	public int getComment_depth() {
		return comment_depth;
	}

	public void setComment_depth(int comment_depth) {
		this.comment_depth = comment_depth;
	}

	public int getComment_order() {
		return comment_order;
	}

	public void setComment_order(int comment_order) {
		this.comment_order = comment_order;
	}

}
