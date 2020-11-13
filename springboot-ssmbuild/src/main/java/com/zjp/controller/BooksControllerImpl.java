package com.zjp.controller;

import com.zjp.pojo.Books;
import com.zjp.service.BooksService;
import com.zjp.utils.PageUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Api(tags = "book控制类")
@RestController
public class BooksControllerImpl implements BooksController{

    @Autowired
    private BooksService booksService;

    @Override
    @ApiOperation(value = "新增或更新书本信息", notes = "更新带 booksId, 新增不需要", httpMethod = "POST")
    @RequestMapping(value = "/book/save",
            produces = "application/json;charset=UTF-8")
    public Books save(Books books) {
        return booksService.save(books);
    }

    @Override
    //@ApiModelProperty(value = "value", required = true)
    @ApiOperation(value = "根据 booksId 获取书本信息", notes = "notes", httpMethod = "GET")
    @RequestMapping(value = "/book/get",
            produces = "application/json;charset=UTF-8")
    public Books getById(@ApiParam("书籍id") @RequestParam("booksId") Integer booksId) {
        return booksService.getById(booksId);
    }

    @Override
    @RequestMapping(value = "/book/delete",
            produces = "application/json;charset=UTF-8")
    public Integer deletes(@ApiParam("ids=1,2,3") HttpServletRequest request) {
        String ids = request.getParameter("ids");
        List<Integer> idList = PageUtils.toIntegerList(ids, ",");
        return booksService.deletes(idList);
    }

    @Override
    @RequestMapping(value = "/book/getList",
            produces = "application/json;charset=UTF-8")
    public List<Books> getByPageList(HttpServletRequest request) {
        Map<String, Object> map = PageUtils.getHttpMap(request);
        return booksService.getByPageList(map);
    }

    @Override
    @RequestMapping(value = "/book/getCount",
            produces = "application/json;charset=UTF-8")
    public Integer getCountByPageList(HttpServletRequest request) {
        Map<String, Object> map = PageUtils.getHttpMap(request);
        return booksService.getCountByPageList(map);
    }
}
