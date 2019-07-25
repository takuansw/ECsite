

package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;


public class MyPageAction extends ActionSupport implements SessionAware {


	public Map<String, Object> session;

	private MyPageDAO myPageDAO = new MyPageDAO();

	private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();

	private String deleteFlg;
	private String message;




	public String execute() throws SQLException {



		if(!session.containsKey("login_user_id")) {   //   ログインしてるかの判定
			return ERROR;  //  してなければ ERROR を返す    ここでこのメソッドは終わり！
		}
//                             メソッドの中、return を返してしまったらその下の処理は実行されない！
//		                        → 条件によって、メソッドを中断するときに使える！




		if(deleteFlg == null)  {  //何もしてない状態なら


			String user_master_id = session.get("login_user_id").toString();


			myPageList = myPageDAO.getMyPageUserInfo(user_master_id);	//   ユーザーID  を 引数に




		} else if (deleteFlg.equals("1")) {   //    myPage.jsp の 削除ボタンを押すと deleteFlg に "1" が入り、フィールドに送られる

			delete();
		}

		String result = SUCCESS;

		return result;

	}




	public void delete() throws SQLException {


		String user_master_id = session.get("login_user_id").toString();


		int res = myPageDAO.buyItemHistoryDelete(user_master_id);



		if (res > 0) {     //     削除に成功したら

			myPageList = null;

			setMessage("商品情報を正しく削除しました。");

		} else if (res == 0) {

			setMessage("商品情報の削除に失敗しました。");
		}


	}







		public void setDeleteFlg(String deleteFlg) {
			this.deleteFlg = deleteFlg;
		}



		@Override
		public void setSession(Map<String, Object> session){
			this.session = session;
		}


		public ArrayList<MyPageDTO> getMyPageList() {
			return this.myPageList;                          //  このゲッターのおかげで次のJSPがgetすることができる
		}


		public String getMessage() {

			return this.message;
		}


		public void setMessage(String message){
			this.message = message;
		}

	}


























