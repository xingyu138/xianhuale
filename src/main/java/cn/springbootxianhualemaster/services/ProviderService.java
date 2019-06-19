package cn.springbootxianhualemaster.services;



import cn.springbootxianhualemaster.pojo.Provider;

import java.util.List;
import java.util.Map;

public interface ProviderService {

	List<Provider> getProviderListPage(Map<String, Object> params);

	int getProviderListPageCount(Map<String, Object> params);

	int addProvider(Provider provider);

	int deleteProvider(Integer id);

	void updateProvider(Provider provider);

	Provider getProviderById(Integer id);

}