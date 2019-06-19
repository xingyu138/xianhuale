package cn.springbootxianhualemaster.controller;


import cn.springbootxianhualemaster.pojo.Packing;
import cn.springbootxianhualemaster.services.PackingService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//包装名称
@RestController
@RequestMapping("/xianhuale//page/packing")
public class PackingController {
	@Autowired
	private PackingService packingService;
	/**
	 * 身份
	 * @return
	 */
	@RequestMapping("/getPackingList.htm")
	@ResponseBody
	public Object getRoleList(){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Packing> list =packingService.names();
			map.put("result", list);
			map.put("message", "供应商列表查询成功");
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", "供应商列表查询异常："+e);
		}
		
		return map;
	}}