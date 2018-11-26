package com.baizhi.service;

import com.baizhi.entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

/**
 * Created by wdwhwn on 2018/11/25.
 */
public class TastB {
    public static void main(String[] args) throws IOException {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestA helloService = (TestA) classPathXmlApplicationContext.getBean("testAService");
        List<Employee> list = helloService.selectAll();
        list.forEach(li-> System.out.println(li));
        System.in.read();
    }
}
