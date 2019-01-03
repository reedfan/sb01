package com.ustc.reed.controller;

import com.ustc.reed.pojo.Book;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController {

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView){

        List<Book> bookList = new ArrayList<>();
        Book book = new Book();
        book.setAuthor("reed");
        book.setPrice(10);
        bookList.add(book);
        modelAndView.setViewName("index");
        modelAndView.addObject("bookList",bookList);
        return modelAndView;





    }


}
