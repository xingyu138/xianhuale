package cn.springbootxianhualemaster.controller;

import cn.springbootxianhualemaster.pojo.Collections;

import cn.springbootxianhualemaster.services.CollectionsService;
import cn.springbootxianhualemaster.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="collection")
public class CollectionsController {
	@Autowired
	private CollectionsService collectionService;

	//根据ID查询留言
	@RequestMapping(value="/getCollectionsById.htm")
	@ResponseBody
	public Object getCollectionsById(Integer id){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Collections collections= collectionService.getCollectionsById(id);
			map.put("result", collections);
			map.put("success", true);
			map.put("message","查询留言成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", "查询留言异常"+e);
		}
		return map;
	}

	/**
	 * 删除留言
	 */
	@RequestMapping("/deleteCollection.htm")
	@ResponseBody
	public Object deleteCollection(Integer id){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int count = collectionService.deleteCollection(id);
			map.put("success", true);
			map.put("message", "删除留言成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", "删除留言异常"+e);
		}
		return map;
	}

	//增加留言
	@RequestMapping("/addCollection.htm")
	@ResponseBody
	public Object addCollection(Integer userId, String productName,String commentsContent){
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("productName", productName);
		params.put("commentsContent", commentsContent);

		int count=collectionService.addCollection(params);
		if (count>0) {
			map.put("message", "增加留言成功");
			map.put("success", true);
		}else{
			map.put("success", false);
			map.put("message", "留言添加或修改异常");
		}
		return map;
	}


	//修改留言
	@RequestMapping("modifyCollection.htm")
	@ResponseBody
	public Object modifyCollection(Integer id , String commentsContent){
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		params.put("commentsContent",commentsContent);
		params.put("id", id);
		System.out.println("=====================>"+commentsContent);
		try {
			int count=collectionService.updateCollection(params);
			if (count>0) {
				map.put("success",true);
				map.put("message","修改留言成功");
			}else {
				map.put("success",false);
				map.put("message","修改留言失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success",false);
			map.put("message","修改留言异常"+e);
		}
		return map;
	}

	/**
	 * 获取留言信息-行数
	 */
	@RequestMapping(value="getCollectionsListPageCount.htm",method = RequestMethod.GET)
	@ResponseBody
	public Object getCollectionsListPageCount(String productName){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("productName", productName);
			int count = collectionService.getCollectionsListPageCount(params);

			map.put("result", count);
			map.put("success", true);
			map.put("message","查询留言数量成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message","查询留言数量异常"+e);
		}
		return map;
	}

	/**
	 * 获取留言信息，分页
	 */
	@RequestMapping("/getCollectionsListPage.htm")
	@ResponseBody
	public Object getCollectionsListPage(Integer pageNum, Integer pageSize,String productName){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer start = PageUtil.getPageStart(pageNum, pageSize);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("start", start);//第几页
			params.put("pageSize", pageSize);//页面容量
			params.put("productName", productName);
			List<Collections> list = collectionService.getCollectionsListPage(params);
			map.put("success", true);
			map.put("result", list);
			map.put("message", "获取留言信息成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("success", false);
			map.put("message", "获取留言异常"+e);
		}
		return map;
	}
}
