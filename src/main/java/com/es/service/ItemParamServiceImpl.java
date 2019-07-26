package com.es.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.bean.ItemParam;
import com.es.bean.ItemParamExample;
import com.es.bean.ItemParamExample.Criteria;
import com.es.dao.ItemParamMapper;
import com.mysql.fabric.xmlrpc.base.Data;

@Service
public class ItemParamServiceImpl implements ItemParamService{
	@Autowired
	private ItemParamMapper itemParamMapper;
	
	public ItemParam getItemParam(Long cid) {
		ItemParamExample example = new ItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		List<ItemParam> list= itemParamMapper.selectByExampleWithBLOBs(example);
		if(list!=null && !list.isEmpty()) {
			return list.get(0);
		}else {
			return null;
		}
	}


	public void saveItemParam(Long cid, String itemParam) {
		Date date = new Date();
		// TODO Auto-generated method stub
		ItemParam itemParam2 = new ItemParam();
		itemParam2.setItemCatId(cid);
		itemParam2.setParamData(itemParam);
		itemParam2.setCreated(date);
		itemParam2.setUpdated(date);
		itemParamMapper.insert(itemParam2);
	}


	public void saveItemParam(ItemParam itemParam) {
		// TODO Auto-generated method stub
		Date date = new Date();
		itemParam.setCreated(date);
		itemParam.setUpdated(date);
		itemParamMapper.insert(itemParam);
	}


	public void updateItemParam(ItemParam itemParam) {
		// TODO Auto-generated method stub
		Date date = new Date();
		itemParam.setUpdated(date);
		itemParamMapper.updateByPrimaryKeySelective(itemParam);
	}

}
