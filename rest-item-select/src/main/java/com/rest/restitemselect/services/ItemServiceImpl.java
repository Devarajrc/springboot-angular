package com.rest.restitemselect.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.restitemselect.dao.ItemDao;
import com.rest.restitemselect.entities.Item;
import com.rest.restitemselect.models.ItemModel;
import com.rest.restitemselect.responses.Response;

@Service
public class ItemServiceImpl implements ItemService {

	private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

	@Autowired
	ItemDao itemDao;

	@Override
	public Response saveItem(ItemModel itemModel) {
		try {
			Item item = new Item();
			BeanUtils.copyProperties(itemModel, item);
			Response response = itemDao.saveItem(item);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;

	}

	@Override
	public List<Item> getItems() {
		try {
			logger.info("ServiceImpl " );
			return itemDao.getItems();
		} catch (Exception ex) {
			logger.info("Exception getAppointments:", ex);
		}
		return null;
	}

	@Override
	public Integer serveItem(Integer qty) {
		try {
			logger.info("Inside service " );
			return	itemDao.serveItem(qty);
		} catch (Exception ex) {
			logger.info("exception in serve " + ex.getMessage());

		}
		return qty;

	}

	

}
