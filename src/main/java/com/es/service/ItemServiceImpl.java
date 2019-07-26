package com.es.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.bean.Item;
import com.es.bean.ItemDesc;
import com.es.bean.ItemParamItem;
import com.es.dao.ItemDescMapper;
import com.es.dao.ItemMapper;
import com.es.dao.ItemParamItemMapper;
import com.es.untils.IDUtils;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private ItemDescMapper itemDescMapper;
	@Autowired
	private ItemParamItemMapper itemParamItemMapper;

	public Item getItemById(long itemId) {
		// TODO Auto-generated method stub
		return itemMapper.selectByPrimaryKey(itemId);
	}

	public List<Item> getItems() {
		// TODO Auto-generated method stub
		return itemMapper.selectByExample(null);
	}

	public void saveItem(Item item, String desc, String itemParams) {
		// TODO Auto-generated method stub
		Date date = new Date();
		// 获得商品id
		long id = IDUtils.genItemId();
		// 添加商品信息
		item.setId(id);
		// 商品状态，1-正常，2-下架，3-删除
		item.setStatus((byte) 1);
		item.setCreated(date);
		item.setUpdated(date);
		itemMapper.insert(item);

		// 添加商品描述
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemId(id);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		itemDescMapper.insert(itemDesc);

		// 添加商品规格
		ItemParamItem itemParamItem = new ItemParamItem();
		itemParamItem.setItemId(id);
		itemParamItem.setParamData(itemParams);
		itemParamItem.setCreated(date);
		itemParamItem.setUpdated(date);
		itemParamItemMapper.insert(itemParamItem);

	}

	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		Date date = new Date();
		item.setUpdated(date);
		itemMapper.updateByPrimaryKeySelective(item);
	}

}
