package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;


public class BuyItemDAO {


	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	private BuyItemDTO buyItemDTO = new BuyItemDTO();


	public BuyItemDTO  getBuyItemInfo()   {





		String sql = "SELECT * FROM item_info_transaction";


		try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);

			 ResultSet resultSet = preparedStatement.executeQuery();



			 if(resultSet.next()) {
				 buyItemDTO.setId(resultSet.getInt("id"));
				 buyItemDTO.setItemName(resultSet.getString("item_name"));
				 buyItemDTO.setItemPrice(resultSet.getString("item_price"));
				 buyItemDTO.setItemStock(resultSet.getInt("item_stock"));
			 }


		} catch (Exception e) {
			e.printStackTrace();
		}




		return buyItemDTO;
	}



	 /*   BuyItemDTO のインスタンスの中に、DBからとってきた 商品の情報を入れてるだけ   */



}































