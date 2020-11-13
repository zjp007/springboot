package com.zjp.pojo;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "person")
//@PropertySource(value = "classpath:application.properties")

//@Validated
public class Person {

    //@Email(message = "邮箱格式错误")
    private String lastName;
    private Integer age;
    private Map<String, Object> map;
    private List<Object> list;

    public Person() {
    }

    public Person(String lastName, Integer age, Map<String, Object> map, List<Object> list) {
        this.lastName = lastName;
        this.age = age;
        this.map = map;
        this.list = list;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", map=" + map +
                ", list=" + list +
                '}';
    }
}
