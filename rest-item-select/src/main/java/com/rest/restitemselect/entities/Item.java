package com.rest.restitemselect.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	private Integer id;

	private String itemName;

	private Integer price;

	private Integer count;
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Item(Integer id, String itemName, Integer price, Integer count) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.price = price;
		this.count=count;
	}

	public Item() {

	}

}
