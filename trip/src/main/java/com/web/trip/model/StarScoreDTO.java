package com.web.trip.model;

public class StarScoreDTO {
	private int star_num;
	private int board_num;
	private int prod_num;
	private int prod_score;

	public int getStar_num() {
		return star_num;
	}

	public void setStar_num(int star_num) {
		this.star_num = star_num;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
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
