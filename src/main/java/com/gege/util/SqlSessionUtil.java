package com.gege.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    public static SqlSessionFactory factory;
    static {
        String config="mybatis-config.xml";
        InputStream in= null;
        try {
            in = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        factory=builder.build(in);
    }

    public static ThreadLocal<SqlSession> t=new ThreadLocal<SqlSession>();

    public static SqlSession getSession(){
        SqlSession session=t.get();
        if (session==null){
            session=factory.openSession();
        }
        return session;
    }
    public static void closeSession(SqlSession session){
        if (session!=null){
            session.close();
            t.remove();
        }

    }

}
