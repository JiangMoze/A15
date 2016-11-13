package com.weikun.service;

import com.weikun.dao.FatherDAOImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/11/13.
 */
public class FatherServiceImpl {
    private FatherDAOImpl fdao=null;
    @Before
    public void ok() {

        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        fdao=(FatherDAOImpl)ctx.getBean("fdao");

    }

    @Test
    public void queryAll(){
        fdao.queryAll();
    }


    @Test
    public void add(){
        fdao.add();
    }

    @Test
    public void del(){
        fdao.del();
    }
    @Test
    public void update() {
        fdao.update();

    }
}
