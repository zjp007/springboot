package com.zjp.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "book实体", description = "书籍信息")
public class Books implements Serializable {

    public static final Integer DELETED = 1;

    public static final Integer NOT_DELETED = 0;

    @ApiModelProperty("书籍id")
    private Integer bookID;
    private String bookName;
    private Integer bookCounts;
    private String detail;
}
