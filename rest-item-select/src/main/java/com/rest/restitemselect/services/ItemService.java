package com.rest.restitemselect.services;

import java.util.List;

import com.rest.restitemselect.entities.Item;
import com.rest.restitemselect.models.ItemModel;
import com.rest.restitemselect.responses.Response;

public interface ItemService {

	Response saveItem(ItemModel item);

	List<Item> getItems();

//	void serveItem(String itemname);

	Integer serveItem(Integer qty);

}
