package com.mkx.wsapi.configuration;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Mybatis数据库连接管理
 * */
public class MybatisConfiguration {
    @Autowired
    private Environment environment;
    /**
     * 获取数据库连接会话
     * @Param properties 数据库连接配置
     * */
    public SqlSession getSqlSession(Properties properties) throws IOException {
        // 通过配置文件获取数据库连接信息
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");

		/*
		System.out.println("jdbc.driver" + properties.getProperty("jdbc.driver"));
		System.out.println("jdbc.url" + properties.getProperty("jdbc.url"));
		System.out.println("jdbc.user" + properties.getProperty("jdbc.user"));
		System.out.println("jdbc.password" + properties.getProperty("jdbc.password"));
        */
        // 通过配置信息构建一个SQLSessionFactory
        //System.out.println("开始创建会话工厂");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream, properties);
        //System.out.println("创建工厂对象成功");
        // 通过sqlSessionFactory打开一个数据库会话
        //System.out.println("开始创建连接会话");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //System.out.println("创建连接会话成功");
        return sqlSession;
    }

    /**
     * 获取默认的连接配置
     * */
    public Properties getDefaultConnectionProperties() {
        StringBuffer mysql_url = new StringBuffer();
        mysql_url.append("jdbc:mysql://");
        mysql_url.append(environment.getProperty("server.mysql.ip"));
        mysql_url.append(":3306/");
        mysql_url.append(environment.getProperty("server.mysql.database"));
        mysql_url.append("?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=true");

        Properties properties = new Properties();
        properties.setProperty("jdbc.driver", "com.mysql.jdbc.Driver");
        properties.setProperty("jdbc.url",  mysql_url.toString());
        properties.setProperty("jdbc.user", "root");
        properties.setProperty("jdbc.password", "tp151SG7611go");
        return properties;
    }
}

