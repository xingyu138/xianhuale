package cn.springbootxianhualemaster.dao;



import cn.springbootxianhualemaster.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CategoryMapper {
	public List<Category> names();
}