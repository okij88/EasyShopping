package com.es.service;

import com.es.bean.ItemParam;

public interface ItemParamService {

	ItemParam getItemParam(Long cid);

	void saveItemParam(ItemParam itemParam);

	void updateItemParam(ItemParam itemParam);
	
}
