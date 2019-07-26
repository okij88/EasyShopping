package com.es.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.bean.ItemParamItem;
import com.es.bean.ItemParamItemExample;
import com.es.bean.ItemParamItemExample.Criteria;
import com.es.dao.ItemParamItemMapper;
@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {
	@Autowired
	ItemParamItemMapper itemParamItemMapper;
	public List<ItemParamItem> getItemById(Long itemId) {
		// TODO Auto-generated method stub
		ItemParamItemExample example = new ItemParamItemExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andItemIdEqualTo(itemId);
		return itemParamItemMapper.selectByExampleWithBLOBs(example);
	}
	public void updateItem(ItemParamItem itemParamItem) {
		// TODO Auto-generated method stub
		Date date = new Date();
		itemParamItemMapper.updateByPrimaryKeySelective(itemParamItem);
	}

}
