package cn.springbootxianhualemaster.dao;


import cn.springbootxianhualemaster.pojo.Orderpayment_type;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Orderpayment_typeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orderpayment_type record);

    int insertSelective(Orderpayment_type record);

    Orderpayment_type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orderpayment_type record);

    int updateByPrimaryKey(Orderpayment_type record);
}