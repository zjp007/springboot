package com.zjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// 员工表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private String position;
    private String office;
    private Integer age;
    private Date startDate;
    private Float salary;

    private Deparment deparment;
}
