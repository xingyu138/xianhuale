package cn.springbootxianhualemaster.dao;

import cn.springbootxianhualemaster.pojo.Product;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Map;
@Mapper
public interface ProductMapper {
	//根据 条件查询鲜花
    List<Product> getProductList(Map<String, Object> params);
    //查看总数
    int getProductListCount(Map<String, Object> params);
    //根据id查看鲜花具体信息
    Product info(Integer id);
    //根据id  添加信息
    int add(Product product);
    //根据id  修改信息
    int update(Product product);
    //根据id  删除信息
    int delete(Integer id);
    //查看鲜花
    List<Product> getProduct(Map<String, Object> params);

}