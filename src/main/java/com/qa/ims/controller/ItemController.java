package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	private ItemDAO itemDAO;
	private Utils utils;

	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Items items : items) {
			LOGGER.info(items.toString());
		}
		return items;
	}

	/**
	 * Creates a Item by taking in user input
	 */
	@Override
	public Items create() {
		LOGGER.info("Name of Item");
		String itemName = utils.getString();
		LOGGER.info("Please enter value of Item");
		float value = utils.getFloat();
		Item item = itemDAO.create(new Item(itemName, value));
		LOGGER.info("Item created");
		return item;
	}

	/**
	 * Updates an existing Item by taking in user input
	 */
	@Override
	public Items update() {
		LOGGER.info("Please enter the id of the Item you would like to update");
		Long Itemid = utils.getLong();
		LOGGER.info("Please enter New Item Name");
		String itemName = utils.getString();
		LOGGER.info("Please enter New value of Item");
		float value = utils.getString();
		Item item = itemDAO.update(new Item(Itemid, itemName, value));
		LOGGER.info("Item Updated");
		return item;
	}

	/**
	 * Deletes an existing Item by the id of the Item
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the Item you would like to delete");
		Long Itemid = utils.getLong();
		return itemDAO.delete(Itemid);
	}
}