package com.rest.restitemselect.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.restitemselect.entities.Item;
import com.rest.restitemselect.models.ItemModel;

import com.rest.restitemselect.responses.Response;
import com.rest.restitemselect.services.ItemService;
import com.rest.restitemselect.utils.CommonUtils;

@RestController
@RequestMapping("/item")
public class ItemController {

	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

	@Autowired
	ItemService itemService;

	@CrossOrigin("http://localhost:4200")
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
	public Response saveRegister(@RequestBody ItemModel item, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("saveitem: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("saveitem: Received request: " + CommonUtils.getJson(item));
		return itemService.saveItem(item);
	}

	@CrossOrigin("http://localhost:4200")
	@RequestMapping(value = "/items", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ResponseEntity<List<Item>> getItems(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("getItems: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));

		List<Item> list = itemService.getItems();

		Response res = CommonUtils.getResponseObject("List of Items");

		logger.info("getItems: Sent response");
		return new ResponseEntity<List<Item>>(list, HttpStatus.OK);
	}

	@CrossOrigin("http://localhost:4200")
	@RequestMapping(value = "/serve/{qty}", method = RequestMethod.GET, produces = "application/json")
	public Integer serveItem(@PathVariable("qty") Integer qty, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("serveItem: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
	//	logger.info("serveItem: Received request: " + CommonUtils.getJson(item_name));
		return	itemService.serveItem(qty);
	//	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
