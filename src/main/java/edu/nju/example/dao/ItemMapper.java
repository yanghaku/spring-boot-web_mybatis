package edu.nju.example.dao;

import edu.nju.example.model.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
// 这是my-batis根据数据库自动生成的
public interface ItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Item row);

    Item selectByPrimaryKey(Integer id);

    List<Item> selectAll();

    int updateByPrimaryKey(Item row);
}