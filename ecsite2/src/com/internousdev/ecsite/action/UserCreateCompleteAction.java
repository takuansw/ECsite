/*このクラスは何をする？
前のアクションでユーザーの入力値は全てセッションに入れた
それを引数にいれ、DAOのinsertメソッドを実行する。
*/



/*  DAOのcreateUserメソッドを実行 引数は・・・どこから？ → userCrearteConfirmActionでputしたsessionから
 executeの返り血はサクセスのみ*/



package com.internousdev.ecsite.action;


import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware{


	private String loginUserId;
	private String loginPassword;
	private String userName;
//   ここでは定義はしたものの、jsp画面からname=""を受け取ってないので 何も入っていない


	private Map<String, Object> session;


	public String execute() throws SQLException {

		UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();

		userCreateCompleteDAO.createUser(session.get("loginUserId").toString(),   //  引数を sessionからgetしている
										 session.get("loginPassword").toString(), //  引数の型はStringなので
										 session.get("userName").toString() // sessionに入れ、型を忘れたObjectに
										 ); //                                .toString()で思い出させている




		String result = SUCCESS;


		return result;

	}




	public String getLoginUserId() {
		return loginUserId;
	}


	public void setLoginUserId (String loginUserid) {
		this.loginUserId = loginUserid;
	}




	public String getLoginPassword() {
		return loginPassword;
	}


	public void setLoginPassword (String loginPassword) {
		this.loginPassword = loginPassword;
	}



	public String getUserName() {
		return userName;
	}


	public void setUserName (String userName) {
		this.userName = userName;
	}







	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession (Map<String, Object> session) {
		this.session = session;
	}

}
