package com.southwind.entity;

import lombok.Data;

@Data
public class User {
  private long id;
  private String name;
  private String password;
  private double score;
}





//package com.southwind.entity;
//
//import lombok.Data;
//import org.springframework.dao.DataAccessException;
//
//import java.util.Date;
//
//@Data
//public class User {
//  private long id;
//  private String name;
//  private String password;
//  private Double score;
////  private double score;
////  private Date birthday;
//}
