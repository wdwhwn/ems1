package com.baizhi.service;

import com.baizhi.entity.Employee;
import com.mongodb.client.result.DeleteResult;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created by wdwhwn on 2018/11/25.
 */
//@Service
public class TestAImpl implements  TestA {
//    @Autowired
    private MongoTemplate mongoTemplate;
//查询全部
    @Override
    public List<Employee> selectAll() {
        System.out.println("远程方法被调用了");
        // 查询所有
        List<Employee> list = mongoTemplate.findAll(Employee.class);
        // jdk新特性 函数式编程

        list.forEach(user -> System.out.println(user));
        return list;
    }
//查询单个员工信息
    @Override
    public Employee selectOne(String id) {
        Employee employee = mongoTemplate.findById(id, Employee.class);
        return employee;
    }
    //    分页查询

    @Override
    public List<Employee> selectByPage(int nowPage,int pageSize) {
         long count = mongoTemplate.count(new BasicQuery("{}"), Employee.class);
         System.out.println(count);
         List<Employee> users = mongoTemplate.find(new BasicQuery("{}").skip((nowPage - 1) * pageSize).limit(pageSize), Employee.class);
         users.forEach(user -> System.out.println(user));
        return null;
    }


//添加一个员工
    @Override
    public void insert(Employee employee) {
        mongoTemplate.insert(employee);
    }
//删除一个员工
    @Override
    public void delete(String id) {
//        DeleteResult deleteResult = mongoTemplate.remove(new BasicQuery("{id:"+id+"}"), Employee.class);
        mongoTemplate.remove(new Query(Criteria.where("id").is(id)),Employee.class);

    }
// 修改一个员工信息
    @Override
    public void update(Employee employee) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(employee.getId()));

        Employee employeeTest1 = mongoTemplate.findOne(query, Employee.class);

        System.out.println("userTest1 - " + employeeTest1);

//modify and update with save()
        employeeTest1.setAge(employee.getAge());
        employeeTest1.setName(employee.getName());
        mongoTemplate.save(employeeTest1);

//get the updated object again
//        Employee employeeTest1_1 = mongoTemplate.findOne(query, Employee.class);

//        System.out.println("userTest1_1 - " + employeeTest1_1);

    }


    public TestAImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}
