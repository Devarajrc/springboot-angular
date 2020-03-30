package com.rest.restitemselect.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rest.restitemselect.entities.Item;

public class ItemRowMapper implements RowMapper<Item> {

	@Override
	public Item mapRow(ResultSet row, int rowNum) throws SQLException {
		Item item = new Item();

		item.setId(row.getInt("Id"));
		item.setItemName(row.getString("item_Name"));
		item.setPrice(row.getInt("price"));

		return item;

	}

}
