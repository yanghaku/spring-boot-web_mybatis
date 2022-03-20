package edu.nju.example.service.impl;

import edu.nju.example.dao.ItemMapper;
import edu.nju.example.model.Item;
import edu.nju.example.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleServiceImpl implements ExampleService {
    private ItemMapper itemMapper;

    // 设置自动装载
    @Autowired
    public void setItemMapper(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    public List<Item> getItems() {
        return itemMapper.selectAll();
    }
}
