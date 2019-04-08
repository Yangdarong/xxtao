package com.xtao.test.pagehelper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xtao.mapper.TbItemMapper;
import com.xtao.pojo.TbItem;
import com.xtao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestPageHelper {

    @Test
    public void testHelper() {

        // 初始化Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:spring/applicationContext-dao.xml");

        // 获取Mapper的代理对象
        TbItemMapper itemMapper = context.getBean(TbItemMapper.class);
        PageHelper.startPage(1, 3);
        // 设置分页信息
        // 调用Mapper的方法查询数据
        TbItemExample example = new TbItemExample();    // 设置查询条件使用
        List<TbItem> list = itemMapper.selectByExample(example);// select * from tb_item;
        List<TbItem> list2 = itemMapper.selectByExample(example);// select * from tb_item;

        // 取分页信息
        PageInfo<TbItem> info = new PageInfo<>(list);

        System.out.println(list.size());
        System.out.println(list2.size());

        // 遍历结果集
        System.out.println("Total ===>> " + info.getTotal());
        for (TbItem tbItem :
                list2) {
            System.out.println(tbItem.getId() + ">> 名称>>" + tbItem.getTitle());
        }
    }
}
