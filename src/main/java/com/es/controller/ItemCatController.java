package com.es.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.bean.ItemCat;
import com.es.bean.Msg;
import com.es.service.ItemCatService;

@Controller
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/list")
	@ResponseBody
	//���idΪnull��ʹ��Ĭ��ֵ��Ҳ����parentidΪ0�ķ����б�
	public List categoryList(@RequestParam(value="id", defaultValue="0") Long parentId) throws Exception {
		List catList = new ArrayList();
		//��ѯ���ݿ�
		List<ItemCat> list = itemCatService.getItemCatList(parentId);
		for (ItemCat ItemCat : list) {
			Map<Object, Object> node = new HashMap<Object, Object>();
			node.put("id", ItemCat.getId());
			node.put("name", ItemCat.getName());
			//����Ǹ��ڵ�Ļ������óɹر�״̬�������Ҷ�ӽڵ����open״̬
			node.put("state", ItemCat.getIsParent()?"closed":"open");
			catList.add(node);
		}
		return catList;
	}
	
	@RequestMapping("/alllist")
	@ResponseBody
	public List getAllItemCat(@RequestParam(value="id", defaultValue="0") Long parentId) throws Exception {
		List catList = new ArrayList();
		//��ѯ���ݿ�
		List<ItemCat> list = itemCatService.getItemCatList(parentId);
		for (ItemCat itemCat : list) {
			Map<String, Object> node = new HashMap<String, Object>();
			node.put("id", itemCat.getId());
			node.put("name", itemCat.getName());
			if(itemCat.getIsParent()) {
				node.put("include", getAllItemCat(itemCat.getId()));
			}
			catList.add(node);
		}
		
		return catList;
	}
}
