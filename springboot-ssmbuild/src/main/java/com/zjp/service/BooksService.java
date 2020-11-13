package com.zjp.service;

import com.zjp.pojo.Books;

import java.util.List;
import java.util.Map;

public interface BooksService {

    Books save(Books books);

    Books getById(Integer booksId);

    Integer deletes(List<Integer> booksIDList);

    List<Books> getByPageList(Map<String, Object> map);

    Integer getCountByPageList(Map<String, Object> map);

}
