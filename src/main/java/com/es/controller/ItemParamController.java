package com.es.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.bean.ItemParam;
import com.es.bean.Msg;
import com.es.service.ItemParamService;

@Controller
public class ItemParamController {
	@Autowired
	private ItemParamService itemParamService;
	
	@RequestMapping("/itemparam/select")
	@ResponseBody
	public Msg getItemParam(@RequestParam(value="cid") Long cid) {
		ItemParam itemParam = itemParamService.getItemParam(cid);
		if(itemParam != null) {
			return Msg.success().add("itemParam", itemParam);
		}
		else {
			return Msg.fail();
		}
	}
	
	@RequestMapping(value="/itemparam/save",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveItemParam(@RequestBody ItemParam itemParam) {
		itemParamService.saveItemParam(itemParam);
		return Msg.success();
	}
	
	@RequestMapping(value="/itemparam/update",method=RequestMethod.PUT)
	@ResponseBody
	public Msg updateItemParam(@RequestBody ItemParam itemParam) {
		itemParamService.updateItemParam(itemParam);
		return Msg.success();
	}
	
}
