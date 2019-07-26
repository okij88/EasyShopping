package com.es.service;

import java.util.List;

import com.es.bean.ItemParamItem;

public interface ItemParamItemService {

	List<ItemParamItem> getItemById(Long itemId);

	void updateItem(ItemParamItem itemParamItem);

}
