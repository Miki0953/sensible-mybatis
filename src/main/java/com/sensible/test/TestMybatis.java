package com.sensible.test;

import com.sensible.mapper.UserMapper;
import com.sensible.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author liuyc
 * @Description:
 * @date 2020/3/29 00290:22
 */
public class TestMybatis {
    public static void main(String[] args){
        String resource = "mybatis/mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            // 1.最原始的用户，不面向接口
            User user = session.selectOne("com.sensible.mapper.UserMapper.getUserById", 1);
            System.out.println(user);
            // 2.面向接口
            UserMapper userMapper = session.getMapper(UserMapper.class);
            userMapper.getUserById(2);
            System.out.println(userMapper.getUserById(2));

            // 3.删除接口
//            System.out.println(userMapper.delUser(user.getId()));
//            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
