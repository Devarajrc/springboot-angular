package com.rest.restitemselect.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rest.restitemselect.constants.StatusCode;
import com.rest.restitemselect.entities.Item;
import com.rest.restitemselect.mapper.ItemRowMapper;
import com.rest.restitemselect.responses.Response;
import com.rest.restitemselect.utils.CommonUtils;

@Repository
public class ItemDaoImpl implements ItemDao {

	private static final Logger logger = LoggerFactory.getLogger(ItemDaoImpl.class);

	Integer total_price=0;
	
	Integer updated_count=0;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Response saveItem(Item item) {
		Response response = CommonUtils.getResponseObject("Add item data");
		try {
			String sql = "INSERT INTO dish (id,name,unit_price,dish_id) VALUES(?,?,?,?)";
			int res = jdbcTemplate.update(sql, new Object[] { item.getId(), item.getItemName(), item.getPrice(),1 });
			if (res == 1) {
				response.setStatus(StatusCode.SUCCESS.name());
			} else {
				response.setStatus(StatusCode.ERROR.name());
			}
		} catch (Exception e) {
			logger.error("Exception in saveEmployee", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;
	}

	@Override
	public List<Item> getItems() {
		return jdbcTemplate.query("select id,name,unit_price,count from dish", new ResultSetExtractor<List<Item>>() {
			public List<Item> extractData(ResultSet resultObj) throws SQLException, DataAccessException{
				List<Item> itemList=new ArrayList<>();
				while(resultObj.next()) {
					Item item=new Item();
					item.setId(resultObj.getInt(1));
					item.setItemName(resultObj.getString("name"));
					item.setPrice(resultObj.getInt(3));
					item.setCount(resultObj.getInt("count"));
					if(item.getPrice()==19) {
						item.setPrice(item.getPrice()-4);
					}
					itemList.add(item);
					
				}
				return itemList;
			}
		});
		
		/*
		 * String sql = "SELECT id, item_name, price FROM item"; RowMapper<Item>
		 * rowMapper = new ItemRowMapper(); return this.jdbcTemplate.query(sql,
		 * rowMapper);
		 */
	}

	@Override
	public Integer serveItem(Integer qty) {
		logger.info("Inside dao " );
		String sql1 = "select unit_price,count FROM dish WHERE name='IDLI'";

		
		return jdbcTemplate.query(sql1, new ResultSetExtractor<Integer>() {
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				Item item=new Item();
				while(rs.next()) {
					total_price=rs.getInt("unit_price")*(qty);
					
					updated_count=rs.getInt("count")-(qty);
					String sql="update dish set count = ? where name='IDLI'"; 
					
					jdbcTemplate.update(sql, new Object[] {updated_count});
				}
				return total_price;
			}
		});
		
	}

}
