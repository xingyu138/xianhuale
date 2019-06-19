package cn.springbootxianhualemaster.controller;


import cn.springbootxianhualemaster.pojo.Provider;
import cn.springbootxianhualemaster.pojo.Staff;
import cn.springbootxianhualemaster.services.ProviderService;
import cn.springbootxianhualemaster.util.Constants;
import cn.springbootxianhualemaster.util.PageUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/provider")
public class ProviderController {
	@Resource
	private ProviderService providerService;
		
	/**
	 * 获取订单行数
	 * 
	 */
	@RequestMapping(value = "/getProviderListPageCount.htm")
	@ResponseBody
	public Object getProviderListPageCount(String proName,Integer proId,String proPhone){
		Map<String ,Object> map = new HashMap<String, Object>();
		try{
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("proName", proName);
			params.put("id", proId);
			params.put("proPhone", proPhone);
			int count = providerService.getProviderListPageCount(params);
			
			map.put("success", true);
			map.put("result", count);
			map.put("message", "获取订单数量成功");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("success", false);
			map.put("message", "获取订单数量异常："+e);
		}
		return map;
	}
	/**
	 * 
	 * 分页供应商详情页
	 * @param pageNum
	 * @param pageSize
	 * @param proName
	 * @param proId
	 * @param proPhone
	 * 
	 */
	@RequestMapping("/getProviderListPage.htm")
	@ResponseBody
	public Object getProviderListPage(Integer pageNum, Integer pageSize,String proName,
			Integer proId,String proPhone ){
		Map<String ,Object> map = new HashMap<String,Object>();
		try{
			Integer start = PageUtil.getPageStart(pageNum, pageSize);
			Map<String ,Object> params = new HashMap<String,Object>();
			params.put("start",start);
			params.put("pageSize", pageSize);
			params.put("proName",proName);
			params.put("proId", proId);
			params.put("proPhone", proPhone);
			List<Provider> list = providerService.getProviderListPage(params);
			map.put("success", true);
			map.put("result", list);
			map.put("message","获取供应商成功");
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message", "获取供应商详情异常"+e);
		}
		return map;
	}
	
	@RequestMapping("/addOrUpdateProvider.htm")
	@ResponseBody
	public Object addOrUpdateProvider(Provider provider, HttpSession session){
		Map<String,Object> map = new HashMap<String, Object>();
		System.out.println("======>"+provider.getProAddress());
		try{			
			if(provider.getId() != null){
				int id=((Staff)session.getAttribute(Constants.USER_SESSION)).getId();
				provider.setModifyBy(id);
				providerService.updateProvider(provider);
				map.put("message", "修改供应商成功！");				
			}else{
				int id=((Staff)session.getAttribute(Constants.USER_SESSION)).getId();
				provider.setCreatedBy(id);
				providerService.addProvider(provider);
				map.put("message", "添加供应商成功！");
			}
			map.put("success", true);
		}catch(Exception e){
			e.printStackTrace();
			map.put("success",false);
			map.put("message","添加或修改供应商异常："+e);
		}
		return map;
	}
	@RequestMapping("/deleteProvider.htm")
	@ResponseBody
	public Object deleteProvider(Integer id ){
		Map<String , Object> map = new HashMap<String, Object>();
		try{
			int count = providerService.deleteProvider(id);
			if(count>0){
				map.put("success", true);
				map.put("message", "删除供应商成功！");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message", "删除供应商异常："+e);			
		}
		return map ;
	}
	@RequestMapping("/getProviderInfo.htm")
	@ResponseBody
	public Object getProviderInfo(Integer id){
		Map<String , Object>map = new HashMap<String, Object>();
		try{
			Provider provider =  providerService.getProviderById(id);
			map.put("result",provider);
			map.put("success", true);
			map.put("message","查询供应商成功！");
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message","查询供应商异常："+e);
		}
		return map;	
		
	}
	
}
