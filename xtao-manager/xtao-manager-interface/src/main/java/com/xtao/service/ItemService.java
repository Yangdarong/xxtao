package com.xtao.service;

import com.xtao.common.pojo.EasyUIDataGridResult;

/**
 * 商品相关的处理的service
 */
public interface ItemService {

    /**
     * 根据当前的页码和每页的行数进行分页查询
     * @param page
     * @param rows
     * @return
     */
    EasyUIDataGridResult getItemList(Integer page, Integer rows);
}
