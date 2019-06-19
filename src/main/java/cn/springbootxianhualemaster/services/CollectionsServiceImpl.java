package cn.springbootxianhualemaster.services;


import cn.springbootxianhualemaster.dao.CollectionsMapper;
import cn.springbootxianhualemaster.pojo.Collections;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service(value="collectionService")
public class CollectionsServiceImpl implements CollectionsService {

	@Resource
	private CollectionsMapper collectionsMapper;
	
	/**
	 * 根据Id查询留言
	 */
	@Override
	public Collections getCollectionsById(Integer id) {
		return collectionsMapper.getCollectionsById(id);
	}

	//删除留言
	@Override
	public int deleteCollection(Integer id) {
		return collectionsMapper.deleteCollection(id);
	}

	//增加留言
	@Override
	public int addCollection(Collections collections) {
		return collectionsMapper.addCollection(collections);
	}
	@Override
	public int addCollection(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return collectionsMapper.addCollection(params);
	}

	@Override
	public List<Collections> getCollectionsListPage(Map<String, Object> params) {
		return collectionsMapper.getCollectionsListPage(params);
	}

	@Override
	public int getCollectionsListPageCount(Map<String, Object> params) {
		return collectionsMapper.getCollectionsListPageCount(params);
	}

	@Override
	public List<Collections> getCollections() {
		// TODO Auto-generated method stub
		return collectionsMapper.getCollections();
	}

	@Override
	public int updateCollection(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return collectionsMapper.updateCollection(params);
	}

	


}
