package cn.springbootxianhualemaster.services;



import cn.springbootxianhualemaster.pojo.Collections;

import java.util.List;
import java.util.Map;

public interface CollectionsService {


	//订单信息分页
	List<Collections> getCollectionsListPage(Map<String, Object> params);

	//订单信息数量
	int getCollectionsListPageCount(Map<String, Object> params);
	/**
	 * 根据Id查询留言
	 */
	Collections getCollectionsById(Integer id);

	//删除留言
	int deleteCollection(Integer id);

	//修改
	int updateCollection(Map<String, Object> params);

	//增加
	int addCollection(Collections collections);
	int addCollection(Map<String, Object> params);

	List<Collections> getCollections();
}