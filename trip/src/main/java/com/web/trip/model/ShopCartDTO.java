package com.web.trip.model;

public class ShopCartDTO {
	private String member_id;
	private int shop_cart_num;
	private int shop_prod_num;
	private int shop_prod_qty;

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getShop_cart_num() {
		return shop_cart_num;
	}

	public void setShop_cart_num(int shop_cart_num) {
		this.shop_cart_num = shop_cart_num;
	}

	public int getShop_prod_num() {
		return shop_prod_num;
	}

	public void setShop_prod_num(int shop_prod_num) {
		this.shop_prod_num = shop_prod_num;
	}

	public int getShop_prod_qty() {
		return shop_prod_qty;
	}

	public void setShop_prod_qty(int shop_prod_qty) {
		this.shop_prod_qty = shop_prod_qty;
	}

}
