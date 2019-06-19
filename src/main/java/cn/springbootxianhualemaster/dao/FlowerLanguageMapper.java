package cn.springbootxianhualemaster.dao;


import cn.springbootxianhualemaster.pojo.FlowerLanguage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FlowerLanguageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FlowerLanguage record);

    int insertSelective(FlowerLanguage record);

    FlowerLanguage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FlowerLanguage record);

    int updateByPrimaryKey(FlowerLanguage record);
}