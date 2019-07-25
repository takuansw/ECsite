/*何をするか*/



/*商品の情報が1件ずつ入ったDTOのリストを作る
↑これはDAOの戻り値で作る
*/

package com.internousdev.ecsite.action;


import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class ItemListAction extends ActionSupport {


	private ItemListDAO dao = new ItemListDAO();

	private ArrayList<ItemInfoDTO> itemList = new ArrayList<ItemInfoDTO>();

	private String result;




	public String execute () throws SQLException{




		result = SUCCESS;

		itemList = dao.itemInfoGet();



		return result;

	}





	public ArrayList<ItemInfoDTO> getItemList () {
		return this.itemList;

	}


	public void setItemList(ArrayList<ItemInfoDTO> itemList){
		this.itemList = itemList;
	}




}





















