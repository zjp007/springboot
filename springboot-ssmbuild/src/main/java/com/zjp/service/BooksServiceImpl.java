package com.zjp.service;


import com.zjp.dao.BooksDaoMapper;
import com.zjp.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksDaoMapper booksDaoMapper;

    public void setBooksDaoMapper(BooksDaoMapper booksDaoMapper) {
        this.booksDaoMapper = booksDaoMapper;
    }

    @Override
    public Books save(Books books) {
        if(books != null){
            if(books.getBookID() != null){
                booksDaoMapper.update(books);
            }else {
                booksDaoMapper.add(books);
            }
        }
        return books;
    }

    @Override
    public Books getById(Integer booksId) {
        Books result = new Books();
        if(booksId != null){
            result = booksDaoMapper.getById(booksId);
        }
        return result;
    }

    @Override
    public Integer deletes(List<Integer> booksIDList) {
        Integer result = 0;
        if(booksIDList != null && !booksIDList.isEmpty()){
            result = booksDaoMapper.deletes(booksIDList);
        }
        return result;
    }

    @Override
    public List<Books> getByPageList(Map<String, Object> map) {
        List<Books> result = new ArrayList<>();
        if(map != null && !map.isEmpty()){
            result = booksDaoMapper.getByPageList(map);
        }
        return result;
    }

    @Override
    public Integer getCountByPageList(Map<String, Object> map) {
        Integer result = 0;
        if(map != null && !map.isEmpty()){
            result = booksDaoMapper.getCountByPageList(map);
        }
        return result;
    }
}
