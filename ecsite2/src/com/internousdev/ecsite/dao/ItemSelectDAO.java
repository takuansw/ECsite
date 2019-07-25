package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemSelectDTO;
import com.internousdev.ecsite.util.DBConnector;


public class ItemSelectDAO {


	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	private ArrayList<ItemSelectDTO> itemSelectDTOList = new ArrayList<ItemSelectDTO>();


	public ArrayList<ItemSelectDTO>  getItemSelectInfo()   {





		String sql = "SELECT * FROM item_info_transaction";


		try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);

			 ResultSet resultSet = preparedStatement.executeQuery();



			 while (resultSet.next()) {

				 ItemSelectDTO itemSelectDTO = new ItemSelectDTO();


				 itemSelectDTO.setItemName(resultSet.getString("item_name"));


				 itemSelectDTOList.add(itemSelectDTO);
			 }


		} catch (Exception e) {
			e.printStackTrace();
		}




		return itemSelectDTOList;
	}



	 /*   BuyItemDTO のインスタンスの中に、DBからとってきた 商品の情報を入れてるだけ   */



}































