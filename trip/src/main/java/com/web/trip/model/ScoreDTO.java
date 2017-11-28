package com.web.trip.model;

public class ScoreDTO {
	private int board_num;
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
