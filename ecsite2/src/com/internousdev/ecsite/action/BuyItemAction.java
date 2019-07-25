//  このクラスは何のために存在するクラスか？


//    → 次のページに 前ページで入力された情報に基づいた、購入個数、合計金額、支払い方法を表示する準備をする
//


package com.internousdev.ecsite.action;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{


	private int count;
	private String pay;

	public Map<String,Object> session;

	private String errorMessage;


	public String execute() {

		String result = SUCCESS;;


		int itemStock = Integer.parseInt(session.get("item_stock").toString());



		if(count > itemStock) {


			setErrorMessage("在庫が足りません");

			return ERROR;

		}






		session.put("count", count);    //  購入金額を表示するため






		int intCount = Integer.parseInt(session.get("count").toString());
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());


		session.put("total_price", intCount * intPrice);   //   合計金額を表示するため









		String payment;


		if(pay.equals("1")) {

			payment = "現金払い";

			session.put("pay",payment);           //    支払い方法を表示するため
		}
		else {

			payment = "クレジットカード";

			session.put("pay", payment);          //   支払い方法を表示するため

		}





/*等しい を表すには

  String  →  .equals("1")  or == "1"
  int  →  == 1
*/





		return result;
	}







	public int getCount() {
		return count;
	}

	public void setCount (int count) {
		this.count = count;
	}

	public String getPay() {
		return pay;
	}

	public void setPay (String pay) {
		this.pay = pay;
	}

	public Map<String,Object> getSession() {
		return session;
	}

	public void setSession (Map<String,Object> session) {
		this.session = session;
	}


	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}


	public String getErrorMessage(){
		return errorMessage;
	}



}





