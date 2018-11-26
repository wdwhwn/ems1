package com.baizhi.test;

import com.baizhi.entity.Employee;
import com.baizhi.service.TestA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by wdwhwn on 2018/11/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestC {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private TestA testA;
        @Test
    public void test1(){
            List<Employee> list = testA.selectAll();
            list.forEach(li-> System.out.println(li));
    }
}
