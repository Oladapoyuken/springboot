package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping(value = "/view-product")
    public String viewProduct(){return "view-product";}

    @RequestMapping(value = "/add-product")
    public String addProduct(){return "add-product";}
}
