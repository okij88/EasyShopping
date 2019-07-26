package com.es.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.bean.ItemDesc;
import com.es.dao.ItemDescMapper;
@Service
public class ItemDescServiceImpl implements ItemDescService {
	@Autowired
	private ItemDescMapper itemDescMapper;
	
	public ItemDesc getItemById(Long itemId) {
		// TODO Auto-generated method stub
		return itemDescMapper.selectByPrimaryKey(itemId);
	}

	public void updateItem(ItemDesc itemDesc) {
		// TODO Auto-generated method stub
		Date date = new Date();
		itemDesc.setUpdated(date);
		itemDescMapper.updateByPrimaryKeySelective(itemDesc);
	}


}
