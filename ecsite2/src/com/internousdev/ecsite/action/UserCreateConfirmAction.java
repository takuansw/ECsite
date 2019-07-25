/*このクラスは何をする？
 →前ページで入力した情報を表示するための準備をし、成功を返す→次のページへ
 前ページで入力した情報が空白だった場合、errorMessageに文字列を入力し、エラーを返す→前のページへ
*/

package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.LoginDAO;
import com.opensymphony.xwork2.ActionSupport;


public class UserCreateConfirmAction extends ActionSupport implements SessionAware{


	private String loginUserId;
	private String loginPassword;
	private String userName;

	private String errorMessage ;


	public Map<String, Object> session;

	private LoginDAO loginDAO = new LoginDAO();



	public String execute()  {

		String result = ERROR;


		if ( !(loginUserId.equals("")) && !(loginPassword.equals("")) && !(userName.equals(""))) {  // 全て入力されていれば




				if( ! loginDAO.isExistUser(loginUserId)  ){  //     !:いなければ  ←  Exist:存在して

					result = SUCCESS;

					session.put("loginUserId", loginUserId);
					session.put("loginPassword", loginPassword);
					session.put("userName", userName);

				}
				else {


					setErrorMessage("すでに登録されているユーザーIDです");
				}




		} else {   //  どこかしらに空白があれば

			setErrorMessage("未入力の項目があります。");

		}



		return result;
	}





/*
全て入力されている場合で、もし、データが既に存在していなければ、SUCCESSを、そうでなければ、エラーメッセージをセット
全て入力されていない場合で、エラーメッセーじをセットし、EROORを返す。*/


/*

	dto = dao.select()



	if(全て入力されている) {

		if(既に存在していれば){

			setError("既に存在してます")

			result = ERROR;

		}
		else {

		 	result = SUCCESS;
		 	session.put
		 	session.put
		 	session.put

		}


	} else {

		seterror("未入力です")
	}
	*/



/*	既に存在する  をどうやって表すか

	入力値を引数にisExistメソッドの実行（select count (*) from  テーブル where id = ?  で、指定したデータの数を取得できる書き方）

		COUNTの数が １以上であれば その引数と同じIDがデータベース内に存在しているということになり、trueを返す。 */






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



	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage (String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
