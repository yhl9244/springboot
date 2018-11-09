package com.example.springbootswagger.controller;

import com.example.springbootswagger.entity.Book;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

/**
 * 用户创建某本图书	POST	/books/
 * 用户修改对某本图书	PUT	/books/:id/
 * 用户删除对某本图书	DELETE	/books/:id/
 * 用户获取所有的图书 GET /books
 * 用户获取某一图书  GET /books/:id
 * Created by suneee on 2018/6/13.
 * 官方文档：http://swagger.io/docs/specification/api-host-and-base-path/
 */
@RestController
@RequestMapping(value = "/books")
public class BookController {

    Map<Long, Book> books = Collections.synchronizedMap(new HashMap<Long, Book>());

    @ApiOperation(value = "获取图书列表", notes = "获取图书列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Book> getBook() {
        List<Book> book = new ArrayList<>(books.values());
        return book;
    }

    @ApiOperation(value = "创建图书", notes = "创建图书")
    @ApiImplicitParam(name = "book", value = "图书实体", required = true, dataType = "Book")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postBook(@RequestBody Book book){
        books.put(book.getId(), book);
        return "success";
    }

    @ApiOperation(value = "获取图书信息", notes = "根据url的id来获取图书信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Long id) {
        return books.get(id);
    }

    @ApiOperation(value = "更新图书信息", notes = "根据url的id来更新图书信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "图书ID", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "book", value = "图书实体", required = true, dataType = "Book")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putBook(@PathVariable Long id, @RequestBody Book book) {
        Book book1 = books.get(id);
        book1.setName(book.getName());
        book1.setPrice(book.getPrice());
        books.put(id, book1);
        return "success";
    }

    @ApiOperation(value = "删除图书信息", notes = "根据url的id来删除图书信息")
    @ApiImplicitParam(name = "id", value = "图书实体ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable Long id){
        books.remove(id);
        return "success";
    }

    @ApiIgnore//使用该注解忽略这个API
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String  jsonTest() {
        return " hi you!";
    }
}
