package com.gege;

import com.gege.dao.StudentDao;
import com.gege.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class myapp {
    public static void main(String[] args) throws IOException {
        String config="mybatis-config.xml";
        InputStream in= Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        SqlSession session=factory.openSession();
        //String sqlid="com.gege.dao.StudentDao.selectStudent";
        String sqlid="com.gege.dao.StudentDao.select1";
        List<Student> list=session.selectList(sqlid,"23");
        list.forEach(stu-> System.out.println(stu));
    }
}
