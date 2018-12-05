package com.alen.springboot.demo.entity;

import lombok.*;

/**
 * @author alen
 * @create 2018-12-03 12:25
 **/
@AllArgsConstructor
@Builder
@Data
@ToString
public class Users {
    private int id;
    private String name;
    private  Integer age;
}


