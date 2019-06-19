package cn.springbootxianhualemaster.services;


import cn.springbootxianhualemaster.dao.ProductMapper;
import cn.springbootxianhualemaster.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;

	//根据条件查询
	@Override
	public List<Product> getProductList(Map<String, Object> params) {

		return productMapper.getProductList(params);
	}
	//根据id查看鲜花具体信息
	@Override
	public Product info(Integer id) {
		// TODO Auto-generated method stub
		return productMapper.info(id);
	}
	//	查看总数
	@Override
	public int getProductListCount(Map<String, Object> params) {

		return productMapper.getProductListCount(params);
	}

	//根据id  修改信息
	@Override
	public int update(Product product) {
		// TODO Auto-generated method stub
		return productMapper.update(product);
	}
	//根据id  删除信息
	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return productMapper.delete(id);
	}
	@Override
	public int add(Product product) {
		// TODO Auto-generated method stub
		return productMapper.add(product);
	}
	//查看鲜花
	
	@Override
	public List<Product> getProduct(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return productMapper.getProduct(params);
	}

}
