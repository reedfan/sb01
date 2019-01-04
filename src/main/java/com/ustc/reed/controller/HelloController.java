package com.ustc.reed.controller;

import com.ustc.reed.pojo.Book;
import com.ustc.reed.rabbitmq.MsgProducer;
import com.ustc.reed.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private MsgProducer msgProducer;

    @Autowired
    private Book book;
    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/sendmsg")
    public String sendMsg() {
        String content = "jj";

        msgProducer.sendMsd(content);
        return content;
    }

    @GetMapping(value = "/sendAll")
    public String sendAll() {
        String content = "hello ,rabbit";

        msgProducer.sendMsd(content);
        return content;
    }





    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        helloService.say();
        return book.getAuthor();
    }

    @RequestMapping(value = "/hello1/{price}",method = RequestMethod.GET)
    public Integer price(@PathVariable("price") Integer price){
        return price;
    }

    @GetMapping(value = "/haha")
    public Integer welcome(@RequestParam(value = "id",required = false,defaultValue = "0") Integer price){
        return price;
    }

    @GetMapping(value = "/getPassword")
    public String getPassWorld(){
        String user = "jj";

        return helloService.getPassWord(user);


    }




}
