package com.es.service;

import java.util.List;

import com.es.bean.Item;

public interface ItemService {
	Item getItemById(long itemId);
	List<Item> getItems();
	void saveItem(Item item, String desc, String itemParams);
	void updateItem(Item item);
}
