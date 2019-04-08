package com.xtao.controller;

import com.xtao.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    // 测试使用的controller 查询当前时间

    @Autowired
    private TestService testService;

    @RequestMapping("/test/queryNow")
    @ResponseBody
    public String queryNow() {
        // 1-引入服务

        // 2-注入服务
        // 3-调用服务方法
        return testService.queryNow();
    }
}
