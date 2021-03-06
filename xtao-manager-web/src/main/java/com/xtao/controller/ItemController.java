package com.xtao.controller;

import com.xtao.common.pojo.EasyUIDataGridResult;
import com.xtao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/item/list", method = RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        // 1.引入服务
        // 2.注入服务
        // 3.调用服务方法
        return itemService.getItemList(page, rows);
    }
}
