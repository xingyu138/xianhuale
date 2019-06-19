package cn.springbootxianhualemaster.controller;


import cn.springbootxianhualemaster.pojo.Purpose;
import cn.springbootxianhualemaster.services.PurposeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//用途列表

@RestController
@RequestMapping("/xianhuale//page/purpose")
public class PurposeController {
	@Autowired
	private PurposeService purposeService;
	/**
	 * 获取所有用户身份
	 * @return
	 */
	@RequestMapping("/getPurposeList.htm")
	@ResponseBody
	public Object getPurposeList(){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Purpose> list =purposeService.names();
			map.put("result", list);
			map.put("message", "供应商列表查询成功");
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", "供应商列表查询异常："+e);
		}
		
		return map;
	}
}
