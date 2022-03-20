package edu.nju.example.controller;

import edu.nju.example.model.Item;
import edu.nju.example.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ExampleController {
    private ExampleService exampleService;

    // 设置自动装载
    @Autowired
    public void setExampleService(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    /**
     * 一个控制器的example, 返回hello world字符串的响应
     */
    @ResponseBody
    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }

    /**
     * 返回item表的所有项, 加上ResponseBody会返回json
     */
    @ResponseBody
    @GetMapping("/items")
    public List<Item> items() {
        return exampleService.getItems();
    }
}
