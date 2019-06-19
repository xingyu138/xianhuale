package cn.springbootxianhualemaster.dao;

import cn.springbootxianhualemaster.pojo.Purpose;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
@Mapper
public interface PurposeMapper {
	public List<Purpose> names();
}