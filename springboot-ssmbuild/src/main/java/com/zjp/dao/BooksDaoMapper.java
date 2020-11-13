package com.zjp.dao;

import com.zjp.pojo.Books;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BooksDaoMapper {
    Integer add(Books books);

    Integer deletes(@Param("booksIDList") List<Integer> booksIDList);

    Integer update(Books books);

    Books getById(Integer booksId);

    List<Books> getByPageList(Map<String, Object> map);

    Integer getCountByPageList(Map<String, Object> map);
}
