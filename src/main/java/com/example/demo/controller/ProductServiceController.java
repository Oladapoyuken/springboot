package com.example.demo.controller;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductServiceController {

    @Autowired
    ProductDao productDao;

    @RequestMapping(value = "/product")
    public ResponseEntity<Object> getProduct(){

        return new ResponseEntity<>(productDao.getProduct(), HttpStatus.OK);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product){
        productDao.createProduct(product);
        return new ResponseEntity<>("Product created Successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product){
        productDao.updateProduct(id, product);
        return new ResponseEntity<>("Product updated Successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id){
        productDao.deleteProduct(id);
        return new ResponseEntity<>("Product deleted Successfully", HttpStatus.OK);
    }

//    @RequestMapping(value = "/")
//    @HystrixCommand(fallbackMethod = "fallback_hello", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeOutInMilliSeconds", value = "1000")
//    })
//    public String hello() throws InterruptedException{
//        Thread.sleep(3000);
//        return "Hello Hystrix";
//    }
//
//    private String fallback_hello(){
//        return "Sorry responds is taking longer than normal";
//    }


}
