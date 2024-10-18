package com.southwind.controller;

import com.southwind.entity.Book;
import com.southwind.service.BookService;
import com.sun.jmx.mbeanserver.NamedObject;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class BookController {

    @Autowired
    private BookService bookService;


    @RequestMapping("/head")
    public String head(){
        return "head";
    }


    //显示所有图书
    @RequestMapping(value = "findAllBooks",method= RequestMethod.GET)
    public String findAllBooks(Model model){  //http://localhost:8080/bookmanage/findAllBooks
        model.addAttribute("bookList",bookService.findAllBooks());
        return "book_list";
    }


    //按书名查找书
    @RequestMapping("/findBooksByName")
    public String findBooksByName(){
        return "book_list_byname";
    }
    @GetMapping("/findBooksByName2")
    public String findBooksByName2(Model model,String bookName){
        model.addAttribute("book",bookService.findBooksByName(bookName));
        return "book_list_byname2";
    }

    //增添书籍,跳转到增添图书的页面
    @RequestMapping("/addBooks")
    public String addBooks1(){
        return "book_add";
    }
    //由增添图书的页面跳转到这里，并携带book数据
    @PostMapping("/addBooks2")
    public String addBooks2(Book book){
        bookService.addBooks(book);
        return "redirect:findAllBooks";  //执行完增添操作后，重定向跳转到查询所有图书页面
    }


    //修改图书（书名+数量）
    @RequestMapping("/updateBooks")
    public String updateBooks(){
        return "book_update";
    }
    @GetMapping("/updateBooks2")
    public String updateBooks2(Model model,String bookName){
        Book book=bookService.findBooksByName(bookName); //先找到要修改的图书，用于数据回显到修改页面
        model.addAttribute("book",book);
        return "books_update2";  //跳转到修改页面
    }
    @PutMapping("/updateBooks3")  //由修改页面提交到这个路径
    public String updateBooks3(Book book){
        bookService.updateBooks(book);  //执行修改操作
        return "redirect:findAllBooks";  //修改完成后重定向跳转到查询所有图书页面
    }




    //出售图书
    @RequestMapping("/sellBooks")
    public String sellBooks(){
        return "books_sell";
    }
    @PutMapping("/sellBooks2")
    public String sellBooks2(Book book){
       // System.out.println(book);
        bookService.sellBooks(book);
        return "redirect:findAllBooks";
    }

    //删除书籍
    @RequestMapping("/deleteBooks")
    public String deleteBooks(){
        return "books_delete";
    }
    @DeleteMapping("/deleteBooks2")
    public String deleteBooks2(String bookName){
        bookService.deleteBooks(bookName);
        return "redirect:findAllBooks";
    }



}
