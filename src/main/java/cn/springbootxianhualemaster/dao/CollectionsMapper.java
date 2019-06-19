package cn.springbootxianhualemaster.dao;



import cn.springbootxianhualemaster.pojo.Collections;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface CollectionsMapper {

	//按条件查询留言数量
	int getCollectionsListPageCount(Map<String, Object> params);

	//分页
	List<Collections> getCollectionsListPage(Map<String, Object> params);


	//删除留言
	int deleteCollection(Integer id);

	//增加
	int addCollection(Map<String, Object> params);
	int addCollection(Collections collections);

	//查询（根据评论Id）
	Collections getCollectionsById(Integer id);

	//修改
	int updateCollection(Map<String, Object> params);

	List<Collections> getCollections();
}