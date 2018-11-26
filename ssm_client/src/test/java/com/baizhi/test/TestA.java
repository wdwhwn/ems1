package com.baizhi.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by wdwhwn on 2018/11/25.
 */
public class TestA {
    public static void main(String[] args) throws IOException {
      ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("springApplication_provider.xml");
        TestA helloService = (TestA) classPathXmlApplicationContext.getBean("demoService");

        System.in.read();
    }
}
