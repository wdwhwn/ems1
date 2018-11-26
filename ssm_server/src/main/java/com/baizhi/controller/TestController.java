package com.baizhi.controller;

import com.baizhi.entity.Employee;
import com.baizhi.service.TestA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by wdwhwn on 2018/11/25.
 */
@Controller
public class TestController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private TestA testA;
//查询全部
    @RequestMapping("/selectAll")
    public String selectAll(Map map){
        System.out.println("selectAll被执行了");
//        mongoTemplate.insert(new Employee(null,"wd",12));
        List<Employee> list = testA.selectAll();
        list.forEach(li-> System.out.println(li));
        return "index";
    }
//查询单个
@RequestMapping("/selectOne")
public String selectOne(Map map,String id){
    System.out.println("selectOne被执行了"+id);
//        mongoTemplate.insert(new Employee(null,"wd",12));
    Employee employee = testA.selectOne(id);
    System.out.println(employee);
    return "index";
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
    return "index";
}
//    删除一个员工
@RequestMapping("/delete")
public String delete(Map map,String id){
    System.out.println("delete被执行了"+id);
//        mongoTemplate.insert(new Employee(null,"wd",12));
    testA.delete(id);
    return "index";
}
//    修改一个员工
@RequestMapping("/update")
public String update(Map map,Employee employee){
    System.out.println("update被执行了"+employee);
//        mongoTemplate.insert(new Employee(null,"wd",12));
    testA.update(employee);
    return "index";

}

}
