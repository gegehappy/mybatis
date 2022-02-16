package com.gege.dao;

import com.gege.domain.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> selectStudent();
    public List<Student> select1(int age);
}
