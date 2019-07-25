package com.internousdev.ecsite.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;





public class BuyItemCompleteDAO {



	private DateUtil dateUtil = new DateUtil();



	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();




	public int buyItemInfo(String item_transaction_id, String total_price,
							String total_count, String user_master_id, String pay  //     ←ここの順番はバラバラでいい
							) throws SQLException { //                                ただし、Actionの引数は対応させる

		 int i = 0;


		String sql = "INSERT INTO user_buy_item_transaction (item_transaction_id, total_price, total_count, user_master_id, pay, insert_date) VALUES(?,?,?,?,?,?)";




		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, item_transaction_id);
			preparedStatement.setString(2, total_price);
			preparedStatement.setString(3, total_count);  //                        ここは対応させる必要があるが、
			preparedStatement.setString(4, user_master_id);
			preparedStatement.setString(5, pay);
			preparedStatement.setString(6, dateUtil.getDate());  // getDateメソッド＝このメソッドが実行された時間を表示

			i = preparedStatement.executeUpdate();




		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

			return i;
		}








	public void updateItemStock(int count, String id) throws SQLException {


		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();


		String sql = "UPDATE item_info_transaction SET item_stock = item_stock - ? WHERE id = ?";


		try {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, count);
			preparedStatement.setString(2, id);
			preparedStatement.executeUpdate();


		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
}