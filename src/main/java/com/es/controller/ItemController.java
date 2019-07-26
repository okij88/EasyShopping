package com.es.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.es.bean.Item;
import com.es.bean.ItemCat;
import com.es.bean.Msg;
import com.es.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/select")
	@ResponseBody
	public Msg getItem(@RequestParam(value="itemId") Long itemId) {
		Item item = itemService.getItemById(itemId);
		if(item != null) {
			return Msg.success().add("item", item);
		}
		else {
			return Msg.fail();
		}
	}
	
	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	@RequestMapping("/items/select")
	@ResponseBody
	public Msg getItems(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 15);
		List<Item> items = itemService.getItems();
//		List itemList = new ArrayList();
//		for (Item item : items) {
//			Map node = new HashMap<Object, Object>();
//			node.put("item", item);
//			node.put("key", item.getId());
//			itemList.add(node);
//		}
		PageInfo page = new PageInfo(items);
		if(page != null) {
			return Msg.success().add("pageHelper", page);
		}
		else {
			return Msg.fail();
		}
	}
	
	@RequestMapping(value="/item/save",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveItem(@RequestBody Map<String,Object> data) {
		String desc = (String) data.get("desc");
		String itemParams = (String) data.get("itemParams");
		String jString = JSON.toJSONString(data.get("item"));
		Class clazz = Item.class;
		Item item=JSON.parseObject(jString, clazz);
		itemService.saveItem(item,desc,itemParams);
		return Msg.success();
	}
	
	@RequestMapping(value="/item/update",method=RequestMethod.PUT)
	@ResponseBody
	public Msg updateItem(@RequestBody Item item) {
		itemService.updateItem(item);
		return Msg.success();
	}
}
