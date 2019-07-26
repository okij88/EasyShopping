package com.es.service;

import java.util.List;

import com.es.bean.ItemCat;



public interface ItemCatService {

	List<ItemCat> getItemCatList(Long parentId);
	
}
