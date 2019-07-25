package com.internousdev.ecsite.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;



public class MyPageDAO {


	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();


//    DBから 購入履歴に 表示する 情報を 取得するための メソッド

	public ArrayList<MyPageDTO> getMyPageUserInfo
		(String user_master_id) throws SQLException {



		ArrayList<MyPageDTO> myPageDTOList = new ArrayList<MyPageDTO>();  // 空のリストを生成



		String sql ="SELECT "
							+ "ubit.id, iit.item_name, ubit.total_price, ubit.total_count, "
							+ "ubit.pay, ubit.insert_date ,lut.user_name "     //   とってきたいカラム名
					+ "FROM "
							+ "user_buy_item_transaction ubit "
					+ "LEFT JOIN "
							+ "item_info_transaction iit "
					+ "ON "
							+ "ubit.item_transaction_id  =  iit.id "
					+ "LEFT JOIN "
							+ "login_user_transaction lut "
					+"ON "
							+ "ubit.user_master_id = lut.login_id "
					+ "WHERE "
							+ "ubit.user_master_id = ? "
					+ "ORDER BY "
							+ "ubit.insert_date DESC ";



		try {

				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				/*preparedStatement.setString(1, item_transaction_id);*/
				preparedStatement.setString(1, user_master_id);

				ResultSet resultSet = preparedStatement.executeQuery();



						while(resultSet.next()){


									MyPageDTO dto = new MyPageDTO();


									dto.setId(resultSet.getString("id"));
									dto.setItemName(resultSet.getString("item_name"));
									dto.setTotalPrice(resultSet.getString("total_price"));
									dto.setTotalCount(resultSet.getString("total_count"));
									dto.setPayment(resultSet.getString("pay"));
									dto.setInsert_date(resultSet.getString("insert_date"));       //   作った箱に  DBからとってきたデータを入れる
									dto.setUserName(resultSet.getString("user_name"));

									myPageDTOList.add(dto);
						}



						if(myPageDTOList.isEmpty()){ //  Listが空なら

							myPageDTOList = null;

						}



		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return myPageDTOList;



	}


//   DBから 購入履歴 を 削除するための メソッド

     //                                      どの商品か              どのユーザーの買った
	public int buyItemHistoryDelete(String user_master_id) throws SQLException {

		String sql =
				"DELETE FROM "
						+ "user_buy_item_transaction "
				+ "WHERE "
						+ "user_master_id = ? ";

		PreparedStatement preparedStatement;

		int result = 0;


		try {

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, user_master_id);

			result = preparedStatement.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			connection.close();
		}

		return result;


	}

}

























