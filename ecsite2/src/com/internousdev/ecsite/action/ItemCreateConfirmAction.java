/*  何のためのActionか

次のページに商品名、商品価格、商品在庫数を表示する。
次の次のActionで入力値を引数として使いたいので、ここでSessionに入れる必要がある  */

package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware{


	private String itemName;
	private String itemPrice;
	private String itemStock;

	private String errorMessage;

	public Map<String,Object> session;



	public String execute() {


		String result = ERROR;


		if( !(itemName.equals("")) &&
			!(itemPrice.equals("")) &&
			!(itemStock.equals("")) ) {


			session.put("itemName", itemName);

			session.put("itemPrice", itemPrice);

			session.put("itemStock", itemStock);





			result = SUCCESS;


		}


		else {

			setErrorMessage ("未入力の項目があります");

		}






		return result;

	}





	public String getItemName(){
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}







	public String getItemPrice(){
		return itemPrice;
	}


	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}








	public String getItemStock(){
		return itemStock;
	}


	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}










	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public String getErrorMessage() {
		return errorMessage;
	}








	public Map<String, Object> getSession(){
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}




}
