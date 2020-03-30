package com.rest.restitemselect.dao;

import java.util.List;

import com.rest.restitemselect.entities.Item;
import com.rest.restitemselect.responses.Response;

public interface ItemDao {

	Response saveItem(Item item);

	List<Item> getItems();

//	void serveItem(String itemname);

	Integer serveItem(Integer qty);

}
