package com.weikun.dao;

import com.weikun.po.Father;
import com.weikun.po.Son;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/11/13.
 */
public class FatherDAOImpl implements IFatherDAO {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void queryAll() {
        Session session=null;
        try {
            session=this.sessionFactory.openSession();

            Query q=session.createQuery("from Father as f");

            List<Father> list=q.list();
            Iterator<Father> it=list.iterator();

            while(it.hasNext()){
                Father f=it.next();
                System.out.println(f.getFname());

                Set<Son> ss=f.getSons();

                Iterator<Son> it1=ss.iterator();
                while(it1.hasNext()){
                    System.out.println(it1.next().getSname());
                }

            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.clear();
            session.close();
        }

    }

    public void update() {
        Session session=null;
        try {
            session=this.sessionFactory.openSession();

            Father f=(Father)session.load(Father.class,3);
            f.setFname("haerbin");
            Set<Son> s=f.getSons();
            Son s1=(Son)s.toArray()[0];
            s1.setSname("heilongj1");

            session.update(f);


        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.clear();
            session.close();
        }

    }
    public void del() {
        Session session=null;
        try {
            session=this.sessionFactory.openSession();

            Father f=(Father)session.load(Father.class,2);
            System.out.print(f.getFname());
            session.delete(f);
            System.out.print("ok");

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.clear();
            session.close();
        }

    }
    public void add() {
        Session session=this.sessionFactory.openSession();
        Father f=new Father();
        f.setFname("JSON");

        Son s1=new Son();
        s1.setSname("Hello1");
        s1.setFather(f);
        f.getSons().add(s1);


        Son s2=new Son();
        s2.setSname("Hello2");
        s2.setFather(f);
        f.getSons().add(s2);

        session.save(f);
        System.out.print("ok");
        session.flush();
        session.clear();
        session.close();
    }
}
