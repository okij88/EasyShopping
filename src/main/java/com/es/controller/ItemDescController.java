package com.es.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.bean.Item;
import com.es.bean.ItemDesc;
import com.es.bean.Msg;
import com.es.service.ItemDescService;
@Controller
public class ItemDescController {
	@Autowired
	private ItemDescService itemDescService;
	
	@RequestMapping("/itemDs/select")
	@ResponseBody
	public Msg getItemDs(@RequestParam(value="itemId") Long itemId) {
		ItemDesc itemDesc = itemDescService.getItemById(itemId);
		if(itemDesc != null) {
			return Msg.success().add("itemDesc", itemDesc);
		}
		else {
			return Msg.fail();
		}
	}
	
	@RequestMapping(value="/itemDs/update",method=RequestMethod.PUT)
	@ResponseBody
	public Msg updateItem(@RequestBody ItemDesc itemDesc) {
		itemDescService.updateItem(itemDesc);
		return Msg.success();
	}
}
