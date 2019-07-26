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
		// �����Ʒid
		long id = IDUtils.genItemId();
		// �����Ʒ��Ϣ
		item.setId(id);
		// ��Ʒ״̬��1-������2-�¼ܣ�3-ɾ��
		item.setStatus((byte) 1);
		item.setCreated(date);
		item.setUpdated(date);
		itemMapper.insert(item);

		// �����Ʒ����
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemId(id);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		itemDescMapper.insert(itemDesc);

		// �����Ʒ���
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
