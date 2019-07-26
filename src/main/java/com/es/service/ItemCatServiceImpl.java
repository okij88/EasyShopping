package com.es.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.bean.ItemCat;
import com.es.bean.ItemCatExample;
import com.es.bean.ItemCatExample.Criteria;
import com.es.bean.ItemCatExample.Criterion;
import com.es.dao.ItemCatMapper;
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private ItemCatMapper itemCatMapper;
	
	public List<ItemCat> getItemCatList(Long parentId) {
		// TODO Auto-generated method stub
		ItemCatExample example = new ItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		return itemCatMapper.selectByExample(example);
	}

}
