package com.zjp.controller;

import com.zjp.pojo.Books;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface BooksController {

    Books save(Books books);

    Books getById(Integer booksId);

    Integer deletes(HttpServletRequest request);

    List<Books> getByPageList(HttpServletRequest request);

    Integer getCountByPageList(HttpServletRequest request);
}
