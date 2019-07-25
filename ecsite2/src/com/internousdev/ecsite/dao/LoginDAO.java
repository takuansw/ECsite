package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;



public class LoginDAO {


	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	private LoginDTO loginDTO = new LoginDTO(); //setメソッドで獲ってきたデータを格納するためにインスタンスを生成



	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword) {




		String sql = "SELECT * FROM login_user_transaction WHERE login_id = ? AND login_pass = ?";



		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, loginUserId);    //   何をとってくればいいかの指示（神から）
			preparedStatement.setString(2, loginPassword);

			ResultSet resultSet = preparedStatement.executeQuery(); //   トラック発車

			if ( resultSet.next()) {

				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));
				loginDTO.setAdmin_flg(resultSet.getString("admin_flg"));





//
//             もし、１行目にデータが存在する状況で、 かつ、
//            もし カラム login_id  の中身 が  null でなければ（しっかりユーザーIDが存在していれば）


				if (resultSet.getString("login_id") != null) {
					loginDTO.setLoginFlg(true);

					//  インスタンスのloginFlgにtrueを入れる
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return loginDTO;

	}














// 引数で与えられたログインIDのユーザーの数が、１以上であれば、返り血に true を返す



	public boolean isExistUser(String loginUserId) {


		boolean result = false;

		String sql = "SELECT COUNT (*) FROM login_user_transaction WHERE login_id = ?";



		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, loginUserId);

			ResultSet resultSet = preparedStatement.executeQuery();


			if(resultSet.next()) {

					if(resultSet.getInt("COUNT") > 0) {

						result = true;
					}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

}




















