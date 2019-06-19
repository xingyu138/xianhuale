package cn.springbootxianhualemaster.dao;



import cn.springbootxianhualemaster.pojo.Packing;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PackingMapper {
	public List<Packing> names();
}