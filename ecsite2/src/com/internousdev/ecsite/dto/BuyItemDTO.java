package com.internousdev.ecsite.dto;

public class BuyItemDTO {


	private int id; //商品の番号
	private String itemName;
	private String itemPrice;
	private int itemStock;






	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}




	public String getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public int getItemStock() {
		return itemStock;
	}

	public void setItemStock (int itemStock) {
		this.itemStock = itemStock;
	}


}
