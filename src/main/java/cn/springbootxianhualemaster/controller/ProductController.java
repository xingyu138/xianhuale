package cn.springbootxianhualemaster.controller;





import cn.springbootxianhualemaster.dao.ProductDao;
import cn.springbootxianhualemaster.pojo.Product;

import cn.springbootxianhualemaster.pojo.Products;
import cn.springbootxianhualemaster.services.IFileService;
import cn.springbootxianhualemaster.services.ProductService;
import cn.springbootxianhualemaster.util.PageUtil;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://127.0.0.1:8020", maxAge = 3600)
@RestController
@RequestMapping(value="/xianhuale/page/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	  @Autowired
	    private IFileService iFileService;
	@Resource
	private ProductDao productDao;
	/**
	 * 获取订单信息-行数
	 * @param productName
	 * @param 
	 * @param 
	 * @return
	 */
	@RequestMapping("/getProductCount.htm")
	@ResponseBody
	public Object getBillListPageCount(String productName, Integer category_id , Integer purpose_id,
			Integer flowers_id,
			Integer color_id,Integer packing_id,Integer amount,Integer price1,Integer price2){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("productName", productName);
			params.put("category_id", category_id);
			params.put("purpose_id", purpose_id);
			params.put("flowers_id", flowers_id);
			params.put("color_id", color_id);
			params.put("packing_id", packing_id);
			params.put("amount", amount);
			params.put("price1", price1);
			params.put("price2", price2);
			System.out.println("======================================>"+price1+price2);
			int count = productService.getProductListCount(params);

			map.put("success", true);
			map.put("result", count);
			map.put("message", "获取数量成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", "获取数量异常："+e);
		}

		return map;
	}

	/**
	 * 获取订单信息-分页
	 * @param pageNum
	 * @param pageSize
	 * @param productName
	 * @param 
	 * @param 
	 * @return
	 */
	@RequestMapping("/getProductListPage.htm")
	@ResponseBody
	public Object getProductListPage(Integer pageNum, Integer pageSize, 
			String productName, Integer category_id , Integer purpose_id,
			Integer flowers_id,
			Integer color_id,Integer packing_id,Integer amount,Integer price1,Integer price2){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer start = PageUtil.getPageStart(pageNum, pageSize);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("start", start);//第几页
			params.put("pageSize", pageSize);//页面容量
			params.put("productName", productName);
			params.put("category_id", category_id);
			params.put("purpose_id", purpose_id);
			params.put("flowers_id", flowers_id);
			params.put("color_id", color_id);
			params.put("packing_id", packing_id);
			params.put("amount", amount);
			params.put("price1", price1);
			params.put("price2", price2);
			List<Product> list = productService.getProductList(params);
			map.put("success", true);
			map.put("result", list);
			map.put("message", "获取信息成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", "获取信息异常："+e);
		}
		return map;
	}
//	直接根据条件查询商品
    @RequestMapping("/getProduct.htm")
    @ResponseBody
    public Object getProduct(String productName, Integer category_id , Integer purpose_id,
                             Integer flowers_id,
                             Integer color_id,Integer packing_id,Integer amount,Integer price1,Integer price2){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("productName", productName);
            params.put("category_id", category_id);
            params.put("purpose_id", purpose_id);
            params.put("flowers_id", flowers_id);
            params.put("color_id", color_id);
            params.put("packing_id", packing_id);
            params.put("amount", amount);
            params.put("price1", price1);
            params.put("price2", price2);
            List<Product> list = productService.getProduct(params);
            map.put("success", true);
            map.put("result", list);
            map.put("message", "获取信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "获取信息异常："+e);
        }
        return map;
    }
	@RequestMapping("/getProductId.htm")
	@ResponseBody
	public Object getProductId(Integer id){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Product product = productService.info(id);
			map.put("result", product);
			map.put("success", true);
			map.put("message", "查询商品成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", "查询商品异常："+e);
		}
		return map;
	}
	//删除
	@RequestMapping("/delete.htm")
	@ResponseBody
	public Object delete(Integer id){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int count = productService.delete(id);
			map.put("success", true);
			map.put("message", "删除商品成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", "删除商品异常："+e);
		}
		return map;
	}
	//增加或者修改
	@RequestMapping("/addOrUpdate.htm")
	@ResponseBody
	public Object addOrUpdate(@RequestParam(value = "productPics") MultipartFile file,
			
			HttpServletRequest request,
			@RequestParam(value = "id") int id
			,@RequestParam(value = "productName") String productName,
			@RequestParam(value = "category_id") int category_id,
			@RequestParam(value = "purpose_id") int purpose_id,
			@RequestParam(value = "flowers_id") int flowers_id,
			@RequestParam(value = "price")Double price,
			@RequestParam(value = "color_id") int color_id,
			@RequestParam(value = "packing_id") int packing_id,
			@RequestParam(value = "amount") int amount,
			@RequestParam(value = "sold") int sold) {
		Map<String, Object> map = new HashMap<String, Object>();
		String path = request.getSession().getServletContext().getRealPath("upload");
        String targetFileName = iFileService.upload(file,path);
        String url = "http://129.204.22.202/leo/img/"+targetFileName;
        Product p=new Product();
        System.out.println("===================>"+id+productName+category_id);
        p.setId(id);
        p.setProductName(productName);
        p.setCategory_id(category_id);
        p.setPurpose_id(purpose_id);
        p.setFlowers_id(flowers_id);
        p.setPrice(price);
        p.setColor_id(color_id);
        p.setPacking_id(packing_id);
        p.setAmount(amount);
        p.setSold(sold);
        if (!file.isEmpty()) {
        	  p.setProductPic(url);
		}
        int a=productService.update(p);
        Map<String, Object> fileMap = Maps.newHashMap();
        fileMap.put("uri",targetFileName);
        fileMap.put("url",url);
        return fileMap;
	}
	//添加
	@RequestMapping("/addOrUpdatea.htm")
	@ResponseBody
	public Object addOrUpdatea(@RequestParam(value = "productPic") MultipartFile file,
			HttpServletRequest request
			,@RequestParam(value = "productName") String productName,
			@RequestParam(value = "category_id") int category_id,
			@RequestParam(value = "purpose_id") int purpose_id,
			@RequestParam(value = "flowers_id") int flowers_id,
			@RequestParam(value = "price")Double price,
			@RequestParam(value = "color_id") int color_id,
			@RequestParam(value = "packing_id") int packing_id,
			@RequestParam(value = "amount") int amount,
			@RequestParam(value = "sold") int sold) {
		  String path = request.getSession().getServletContext().getRealPath("upload");
          String targetFileName = iFileService.upload(file,path);
          String url = "http://129.204.22.202/leo/img/"+targetFileName;
          Product p=new Product();
          p.setProductName(productName);
          p.setCategory_id(category_id);
          p.setPurpose_id(purpose_id);
          p.setFlowers_id(flowers_id);
          p.setPrice(price);
          p.setColor_id(color_id);
          p.setPacking_id(packing_id);
          p.setAmount(amount);
          p.setSold(sold);
          p.setProductPic(url);
         
          int a=productService.add(p);
		
		
		
         Map<String, Object> fileMap = Maps.newHashMap();
          fileMap.put("uri",targetFileName);
          fileMap.put("url",url);
          return fileMap;
		
	}
	//	搜索引擎根据条件查询商品
	@RequestMapping("/getProductSearch.htm")
	@ResponseBody
	public Object getProductSearch(String keyword){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			List<Products> list=productDao.queryProduct(keyword);
			System.out.println(list);
			map.put("success", true);
			map.put("result", list);
			map.put("message", "获取信息成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", "获取信息异常："+e);
		}
		return map;
	}
}
