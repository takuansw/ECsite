/*このクラスでは何をするか
→  ログインしてなければresultにloginを入れる → login.jspへ
    「もしログイン済みなら、次のページに表示するための商品情報をgetし、sessionに入れ、resultにsuccessを入れる」→buyItem.jspへ
     resultを返す*/



package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemSelectDAO;
import com.internousdev.ecsite.dto.ItemSelectDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;   //   home.jsp  から受け取るname=""は無い    から  sessionだけ

	ArrayList<ItemSelectDTO> itemNameList = new ArrayList<ItemSelectDTO>();

	private ItemSelectDAO itemSelectDAO = new ItemSelectDAO();


	public String execute(){

		String result = "login";    //  デフォだとlogin.jspに飛ばされる



//              ログインする際、必ずlogin_user_idがsessionにputされる
		if (session.containsKey("login_user_id")) {  // もしログイン済みなら    itemSelect.jspに飛ぶ



			itemNameList = itemSelectDAO.getItemSelectInfo();   // フィールドのリストに名前だけ入ったDTOのリストを入れる



			result = SUCCESS;                               //         SUCCESS を 返し、 itemSelect.jsp に飛ぶ
		}



		return  result;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return this.session;
	}



	public ArrayList<ItemSelectDTO> getItemNameList () {
		return itemNameList;
	}



}











