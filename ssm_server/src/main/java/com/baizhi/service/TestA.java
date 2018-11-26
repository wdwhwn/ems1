package com.baizhi.service;

import com.baizhi.entity.Employee;

import java.util.List;

/**
 * Created by wdwhwn on 2018/11/25.
 */
public interface TestA {
//  查询全部
    public List<Employee> selectAll();
//    查询单个员工信息
    public Employee selectOne(String id);
//    分页查询
    public List<Employee> selectByPage(int nowPage,int pageSize);
//    添加一个员工
    public void insert(Employee employee);
//    删除一个员工
    public void delete(String id);
//    修改一个员工信息
    public void update(Employee employee);

}
