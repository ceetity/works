package com.southwind.entity;


import lombok.Data;
@Data  //自动生成get、set方法
public class Book {
    String name;  //书名
    double price;  //书价
    int amount;   //存量

}
