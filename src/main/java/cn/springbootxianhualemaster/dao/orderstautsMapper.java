package cn.springbootxianhualemaster.dao;


import cn.springbootxianhualemaster.pojo.orderstauts;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface orderstautsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(orderstauts record);

    int insertSelective(orderstauts record);

    orderstauts selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(orderstauts record);

    int updateByPrimaryKey(orderstauts record);
}