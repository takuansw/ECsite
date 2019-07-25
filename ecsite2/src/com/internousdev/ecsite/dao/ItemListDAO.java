package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {



	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	private PreparedStatement ps;
	private String sql;











	public ArrayList<ItemInfoDTO> itemInfoGet() throws SQLException {



		ArrayList<ItemInfoDTO> itemListDTOList = new ArrayList<ItemInfoDTO>();


		sql = "select * from item_info_transaction";



		try {


			ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();


			while (rs.next()) {

				ItemInfoDTO dto = new ItemInfoDTO();

				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));  //  表のデータ型がintでもgetStringを使えばStringに変換
				dto.setItemStock(rs.getString("item_stock"));
				dto.setInsertDate(rs.getString("insert_date"));


				itemListDTOList.add(dto);

			}



		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			con.close();
		}

		return itemListDTOList;
	}







//  Delete


	public int AllItemDelete() throws SQLException{

		int i = 0;


		sql = "delete from item_info_transaction";

		try {

			ps = con.prepareStatement(sql);

			i = ps.executeUpdate();

		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}

		return i;

	}

}






























