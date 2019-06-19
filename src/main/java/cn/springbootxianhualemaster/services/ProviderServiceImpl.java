package cn.springbootxianhualemaster.services;


import cn.springbootxianhualemaster.dao.ProviderMapper;
import cn.springbootxianhualemaster.pojo.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("providerService")
public class ProviderServiceImpl implements ProviderService{
		
	@Autowired
	private ProviderMapper providerMapper;
	
	@Override
	public List<Provider> getProviderListPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return providerMapper.getProviderListPage(params);
	}

	@Override
	public int getProviderListPageCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return providerMapper.getProviderListPageCount(params);
	}

	@Override
	public int addProvider(Provider provider) {
		// TODO Auto-generated method stub
		return providerMapper.addProvider(provider);
	}

	@Override
	public int deleteProvider(Integer id) {
		// TODO Auto-generated method stub
		return providerMapper.deleteProvider(id);
	}

	@Override
	public void updateProvider(Provider provider) {
		// TODO Auto-generated method stub
		providerMapper.updateProvider(provider);
	}

	@Override
	public Provider getProviderById(Integer id) {
		// TODO Auto-generated method stub
		return providerMapper.getProviderById(id);
	}

}
