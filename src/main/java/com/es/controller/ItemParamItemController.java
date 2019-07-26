package com.es.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.bean.Item;
import com.es.bean.ItemParamItem;
import com.es.bean.Msg;
import com.es.service.ItemParamItemService;

@Controller
public class ItemParamItemController {
	@Autowired
	private ItemParamItemService itemParamItemService;
	
	@RequestMapping("/itemPI/select")
	@ResponseBody
	public Msg getItem(@RequestParam(value="itemId") Long itemId) {
		List<ItemParamItem> itemParamItem = itemParamItemService.getItemById(itemId);
		if(itemParamItem.get(0) != null) {
			return Msg.success().add("itemParamItem", itemParamItem.get(0));
		}
		else {
			return Msg.fail();
		}
	}
	
	@RequestMapping(value="/itemPI/update",method=RequestMethod.PUT)
	@ResponseBody
	public Msg updateItem(@RequestBody ItemParamItem itemParamItem) {
		itemParamItemService.updateItem(itemParamItem);
		return Msg.success();
	}
}
