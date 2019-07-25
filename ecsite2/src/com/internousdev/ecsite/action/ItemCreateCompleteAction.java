/*session から引数をget   DAOのインスタンスからinsert文を実行

成功したらSUCCESSを

*/



package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;


public class ItemCreateCompleteAction extends ActionSupport implements SessionAware {


	public Map<String ,Object> session ;


	private ItemCreateCompleteDAO dao = new ItemCreateCompleteDAO();





	public String execute() throws SQLException{


		String result = SUCCESS;


		String itemName = session.get("itemName").toString();
		int itemPrice = Integer.parseInt(session.get("itemPrice").toString());
		int itemStock = Integer.parseInt(session.get("itemStock").toString());


		dao.itemInsert(itemName, itemPrice, itemStock);







		return result;


	}





	public Map<String , Object > getSession (){
		return session;
	}


	public void setSession (Map<String , Object> session) {
		this.session = session ;
	}

}
