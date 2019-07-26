package com.es.service;

import com.es.bean.Item;
import com.es.bean.ItemDesc;

public interface ItemDescService {

	ItemDesc getItemById(Long itemId);

	void updateItem(ItemDesc itemDesc);

}
