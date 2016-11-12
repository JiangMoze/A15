package com.weikun.service;

import com.weikun.dao.UserDAOImpl;
import com.weikun.vo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/11/12.
 */
public class UserServiceImpl {
    private  UserDAOImpl dao=null;

    @Before
    public void prepare(){

        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        dao=(UserDAOImpl)ctx.getBean("dao");


    }


    @Test
    public void query() {
        dao.query();
    }

    @Test
    public void query1() {
        dao.query1();
    }
    @Test
    public void update() {
        dao.update();
    }
    @Test
    public void del() {

        dao.del();
    }
    @Test
    public void add() {

        User usr=new User();
        usr.setUsername("特朗普");
        usr.setPassword("999");
        dao.add(usr);

    }
    @After
    public void ok(){
        System.out.print("SUccess");
    }




}
