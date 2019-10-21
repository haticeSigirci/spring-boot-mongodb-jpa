package com.haticekumru.mongodbonetoone.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Product {

    private String code;

    private String name;

    private String details;


}
