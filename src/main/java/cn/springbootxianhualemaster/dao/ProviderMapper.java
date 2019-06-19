package cn.springbootxianhualemaster.dao;



import cn.springbootxianhualemaster.pojo.Provider;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface ProviderMapper {
     //供应商列表     
    List<Provider> getProviderListPage(Map<String, Object> params);
    //供应商数量
	int getProviderListPageCount(Map<String, Object> params);
	//添加供应商
	int addProvider(Provider provider);
	//删除供应商
	int deleteProvider(Integer id);
	//更改供应商
	void updateProvider(Provider provider);
	//根据Id查询供应商
	Provider getProviderById(Integer id);
}