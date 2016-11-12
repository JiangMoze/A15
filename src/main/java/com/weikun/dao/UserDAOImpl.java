package com.weikun.dao;

import com.weikun.vo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/11/12.
 */
public class UserDAOImpl extends JdbcDaoSupport implements  IUserDAO {



    public void query1() {
        List<User> list=this.getJdbcTemplate().
                query("select * from user where username like ?",
                        new PreparedStatementSetter() {
                            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                                preparedStatement.setString(1,"卫%");
                            }
                        }, new RowMapper<User>() {
                            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                                User user=new User();
                                user.setUsername(resultSet.getString("username"));
                                user.setPassword(resultSet.getString("password"));
                                return user;
                            }
                        });
        for(User user :list){

            System.out.println(user.getUsername()+user.getPassword());
        }

    }
    public void query() {
        List<Map<String,Object>> list=this.getJdbcTemplate().queryForList("select * from user");

        for(Map<String,Object> m :list){
                System.out.println(m.get("username"));
        }
    }

    public void update() {

        this.getJdbcTemplate().update("update user set username=? where id=?","希拉里",1386);
    }
    public void del() {
        this.getJdbcTemplate().update("delete from user where id=?",new PreparedStatementSetter(){
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1,1383);
            }
        });

    }

    public void add(User user) {

        this.getJdbcTemplate().
                update("insert into user (username,password) values(?,?)",
                        new Object[]{user.getUsername(),user.getPassword()},
                        new int[]{Types.VARCHAR,Types.VARCHAR});

    }
}
