package com.zjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 部门表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deparment {

    private Integer id;
    private String deparmentName;
}
