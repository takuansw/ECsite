//  このクラスは何のために存在するクラスか
//   → 今までにputしてきたsessionの中から、ubitテーブルに入れたいものをgetして、DAOを実行しinsertする

package com.internousdev.ecsite.action;



import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;


public class BuyItemConfirmAction extends ActionSupport implements SessionAware{


	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();
	private Map<String, Object> session;

	int count ;

	public String execute()  throws SQLException {



		count = buyItemCompleteDAO.buyItemInfo(session.get("id").toString(),
										session.get("total_price").toString(),
										session.get("count").toString(),
										session.get("login_user_id").toString(),
										session.get("pay").toString()

											);
		if (count > 0) {
			buyItemCompleteDAO.updateItemStock(Integer.parseInt(session.get("count").toString()), session.get("id").toString());

		}




		return SUCCESS;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession (Map<String, Object> session) {
		this.session = session;
	}





}
