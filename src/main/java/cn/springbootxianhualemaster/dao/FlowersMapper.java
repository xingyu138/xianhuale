package cn.springbootxianhualemaster.dao;



import cn.springbootxianhualemaster.pojo.Flowers;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface FlowersMapper {
	public List<Flowers> names();
}