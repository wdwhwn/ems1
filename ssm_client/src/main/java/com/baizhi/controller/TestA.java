package com.baizhi.controller;

import com.baizhi.entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by wdwhwn on 2018/11/25.
 */
@Controller
public class TestA {
    ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    com.baizhi.service.TestA testA = (com.baizhi.service.TestA) classPathXmlApplicationContext.getBean("testAService");
    //查询全部
    @RequestMapping("/selectAll")
    public String selectAll(Map map){
        System.out.println("selectAll被执行了");
//        mongoTemplate.insert(new Employee(null,"wd",12));
        List<Employee> list = testA.selectAll();
        list.forEach(li-> System.out.println(li));
        map.put("list",list);
        return "index";
    }
    //查询单个
    @RequestMapping("/selectOne")
    public String selectOne(Map map,String id,String m){
        System.out.println("selectOne被执行了"+id+"||"+m);
//        mongoTemplate.insert(new Employee(null,"wd",12));
        Employee employee = testA.selectOne(id);
        System.out.println(employee);
        map.put("employee",employee);
        if(!"1".equals(m)) {
            return "selectOne";
        }
        return "update";
    }
    //分页查询
    @RequestMapping("/selectByPage")
    public String selectByPage(Map map,int nowPage,int pageSize){
        System.out.println("selectOne被执行了"+nowPage+"||"+pageSize);
        List<Employee> list = testA.selectByPage(nowPage, pageSize);
        list.forEach(li-> System.out.println(li));

        return "index";
    }
    //    添加一个员工
    @RequestMapping("/insert")
    public String insert(Map map,Employee employee){
        System.out.println("selectOne被执行了"+employee);
//        mongoTemplate.insert(new Employee(null,"wd",12));
        testA.insert(employee);
        return "redirect:/selectAll.do";
    }
    //    删除一个员工
    @RequestMapping("/delete")
    public String delete(Map map,String id){
        System.out.println("delete被执行了"+id);
//        mongoTemplate.insert(new Employee(null,"wd",12));
        testA.delete(id);
        return "redirect:/selectAll.do";
    }
    //    修改一个员工
    @RequestMapping("/update")
    public String update(Map map,Employee employee){
        System.out.println("update被执行了"+employee);
//        mongoTemplate.insert(new Employee(null,"wd",12));
        testA.update(employee);
        return "redirect:/selectAll.do";

    }
}
