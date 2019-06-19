package cn.springbootxianhualemaster.dao;

import cn.springbootxianhualemaster.pojo.Color;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ColorMapper {
	
	public List<Color> names();
}