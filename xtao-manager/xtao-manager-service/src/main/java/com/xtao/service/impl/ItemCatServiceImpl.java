package com.xtao.service.impl;

import com.xtao.common.pojo.EasyUITreeNode;
import com.xtao.mapper.TbItemCatMapper;
import com.xtao.pojo.TbItemCat;
import com.xtao.pojo.TbItemCatExample;
import com.xtao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类管理
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper mapper;

    @Override
    public List<EasyUITreeNode> getItemCatList(long parentId) {
        // 根据parentId查询分类列表
        TbItemCatExample example = new TbItemCatExample();
        // 设置查询条件
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        // 执行查询
        List<TbItemCat> list = mapper.selectByExample(example);
        // 转换成EasyUITreeNode 列表
        List<EasyUITreeNode> result = new ArrayList<>();
        for (TbItemCat tbItemCat :
                list) {
            // 创建一个节点对象
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbItemCat.getId());
            node.setText(tbItemCat.getName());
            node.setState(tbItemCat.getIsParent() ? "closed" : "oped");
            // 添加到节点中
            result.add(node);
        }
        return result;
    }
}
