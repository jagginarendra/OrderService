package com.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class SearchController extends BaseController{

    @GetMapping("/names/all")
    public List<String> getAllNames(){

        return Arrays.asList("sachin","sourav","dravid","zaheer");

    }

}
