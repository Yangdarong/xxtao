package com.xtao.service.impl;

import com.xtao.mapper.TestMapper;
import com.xtao.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper mapper;

    @Override
    public String queryNow() {
        // 1-注入mapper
        // 2-调用mapper的方法 返回
        return mapper.queryNow();
    }
}
